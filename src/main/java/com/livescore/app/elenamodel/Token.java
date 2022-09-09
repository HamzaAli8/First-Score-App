package com.livescore.app.elenamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Token {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Long expiresIn;
    @JsonProperty("token_type")
    private String tokenType;
    private Instant expiration;

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
        expiration = Instant.now().plus(expiresIn, ChronoUnit.SECONDS);
    }

    public boolean isExpired(){
        return expiration.isBefore(Instant.now());
    }
}
