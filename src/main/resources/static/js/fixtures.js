var elements = document.getElementsByClassName('clickable-row');
for (var i = 0; i < elements.length; i++) {
    var element = elements[i];
    element.addEventListener('click', function() {
        var href = this.dataset.href;
        if (href) {
            window.location.assign(href);
        }
    });
}