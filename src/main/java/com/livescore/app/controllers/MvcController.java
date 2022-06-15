package com.livescore.app.controllers;


import com.livescore.app.elenamodel.*;
import com.livescore.app.elenamodel.mymodels.FixtureEvents;
import com.livescore.app.elenamodel.mymodels.FixtureLineup;
import com.livescore.app.elenamodel.mymodels.FixtureStats;
import com.livescore.app.newsmodel.Articles;
import com.livescore.app.newsservices.NewsService;
import com.livescore.app.elenaservices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class MvcController {

    @Autowired
    StandingService standingService;

    @Autowired
    TeamService teamService;

    @Autowired
    FixtureService fixtureService;

    @Autowired
    StatService statService;

    @Autowired
    StageService stageService;

    @Autowired
    LeagueService leagueService;

    @Autowired
    EventService eventService;

    @Autowired
    NewsService newsService;

    @Autowired
    LineUpService lineUpService;

    @Autowired
    VenueService venueService;


    @GetMapping("/")
    public String home(Model model){

        List<FixturesResponse> Eng = leagueService.getNextFixturesByLeagueId(234);
        List<FixturesResponse> Ita = leagueService.getNextFixturesByLeagueId(318);
        List<FixturesResponse> Spa = leagueService.getNextFixturesByLeagueId(466);

        List<Articles>  news = newsService.getNewsArticles();

        ZoneId defaultZoneId = ZoneId.systemDefault();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM yyyy");

        Date date1 = new Date();



        LocalDate localDate = LocalDate.now().plusDays(1);
        Date date2 = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        LocalDate localDate2 = LocalDate.now().plusDays(2);
        Date date3 = Date.from(localDate2.atStartOfDay(defaultZoneId).toInstant());

        LocalDate localDate3 = LocalDate.now().plusDays(3);
        Date date4 = Date.from(localDate3.atStartOfDay(defaultZoneId).toInstant());



        String today = sdf.format(date1);
        String tomorrow = sdf.format(date2);
        String dayAfter = sdf.format(date3);
        String last = sdf.format(date4);




        model.addAttribute("Eng", Eng);
        model.addAttribute("Ita", Ita);
        model.addAttribute("Spa", Spa);
        model.addAttribute("news", news);
        model.addAttribute("today",today);
        model.addAttribute("tomorrow",tomorrow);
        model.addAttribute("dayAfter",dayAfter);
        model.addAttribute("last",last);



        return "index";
    }

//    @GetMapping("/team")
//    public String team(Model model){
//
//        LeagueResponse Eng = leagueService.getNextFixturesByLeagueId(234);
//        LeagueResponse Ita = leagueService.getNextFixturesByLeagueId(318);
//        LeagueResponse Spa = leagueService.getNextFixturesByLeagueId(466);
//
//        NewsResponses news = newsService.getNewsArticles();
//
//
//
//        model.addAttribute("Eng", Eng);
//        model.addAttribute("Ita", Ita);
//        model.addAttribute("Spa", Spa);
//        model.addAttribute("news", news);
//
//        return "team";
//    }

    @GetMapping("/standings/{id}")
    public String standings(Model model,@PathVariable(name = "id"
    ) Integer id){

        StandingData standings = standingService.getStandingByStageId(id);
        LeagueResponse stand = standingService.getLeagueStandingByStageId(id);
        model.addAttribute("teams",standings);
        model.addAttribute("stand", stand);




        return "standings";
    }


    @GetMapping("/fixtures/season/{id}")
    public String getFixturesBySeasonId(Model model,@RequestParam(value = "from", required = false) @DateTimeFormat(pattern="yyyy-MM-dd")  String date, @PathVariable(name = "id"
    ) Integer id){

        FixtureData fixtures = fixtureService.getFixtureBySeasonId(id, date);
        model.addAttribute("fixtures",fixtures);

       return "fixtures";
    }

    @GetMapping("/fixtures/{id}")
    public String getFixturesById(Model model, @PathVariable(name = "id"
    ) Integer id){

        FixtureData fixture = fixtureService.getFixtureById(id);
        List<FixturesResponse> prevFixtures = fixtureService.getHeadToHeadByFixtureId(id);


        FixturesResponse home = fixtureService.getFixtureHomeTeamById(id);
        FixturesResponse away = fixtureService.getFixtureAwayTeamById(id);
        LeagueResponse league = fixtureService.getFixtureLeagueById(id);



        FixtureStats stats = statService.getStats(id, home.getIdHome(),away.getIdAway());
        FixtureEvents events = eventService.getStats(id, home.getIdHome(), away.getIdAway());
        FixtureLineup lineups = lineUpService.getLineUps(id, home.getIdHome(), away.getIdAway());



        Integer seasonId = away.getIdSeason();
        StageResponse stage = stageService.getStageBySeasonId(seasonId);
        Integer standingId = stage.getId();
        StandingData standings = standingService.getStandingByStageId(standingId);





        model.addAttribute("fixture",fixture);
        model.addAttribute("league",league);
        model.addAttribute("home",home);
        model.addAttribute("away",away);
        model.addAttribute("stats", stats);
        model.addAttribute("teams",standings);
        model.addAttribute("prevFixtures", prevFixtures);
        model.addAttribute("events", events);
        model.addAttribute("lineups", lineups);


        return "fixture-details";
    }


    @GetMapping("/teams/{id}")
    public String getTeamById(Model model, @PathVariable(name = "id"
    ) Integer id){

        TeamResponse teams = teamService.getTeamById(id);
        List<FixturesResponse> results = fixtureService.getResultsByTeamId(teams.getId());
        LeagueResponse league = fixtureService.getFixtureLeagueById(results.get(0).getId());
        List<Articles>  news = newsService.getTeamNewsArticles(teams.getName());
        List<FixturesResponse> fixtures = fixtureService.getFixturesByTeamId(id);


        for(FixturesResponse f : results){

            if(f.getHomeName().equals(teams.getName())){

                VenueResponse venue;
                if(f.getIdVenue() != null){

                    venue = venueService.getVenueById(f.getIdVenue());

                }else{

                    venue = venueService.getVenueById(566);
                }
                model.addAttribute("venue", venue);

                break;
            }

        }

        model.addAttribute("teams",teams);
        model.addAttribute("results",results);
        model.addAttribute("league", league);
        model.addAttribute("news", news);
        model.addAttribute("fixtures", fixtures);



        return "team";
    }

    @GetMapping("/app")
    public String appPage(){



        return "app";
    }

    @GetMapping("/news")
    public String newsPage(Model model){


        List<Articles> news = newsService.getLatestArticles();

        model.addAttribute("news", news);

        return "news";
    }
}
