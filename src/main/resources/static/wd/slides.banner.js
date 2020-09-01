jQuery(function ($) {
    if ($(".picbox").length > 0) {
        var defaultOpts = { interval: 4000, fadeInTime: 500, fadeOutTime: 500 };
        var _titles = $("ul.switch li");
        var _titles_bg = $("ul.switch li");
        var _bodies = $("ul.picbox li");
        var _count = _titles.length;
        var _current = 0;
        var _intervalID = null;
        var stop = function () { window.clearInterval(_intervalID); };
        var slide = function (opts) {
            if (opts) {
                _current = opts.current || 0;
            } else {
                _current = (_current >= (_count - 1)) ? 0 : (++_current);
            };
            _bodies.filter(":visible").fadeOut(defaultOpts.fadeOutTime, function () {
                _bodies.eq(_current).fadeIn(defaultOpts.fadeInTime);
                _bodies.removeClass("current").eq(_current).addClass("current");
            });
            _titles.removeClass("current").eq(_current).addClass("current");
            _titles_bg.removeClass("current").eq(_current).addClass("current");
        };
        var go = function () {
            if (_titles.length < 2) return;
            stop();
            _intervalID = window.setInterval(function () { slide(); }, defaultOpts.interval);
        };
        var itemMouseOver = function (target, items) {
            //stop();
            var i = $.inArray(target, items);
            slide({ current: i });
        };
        _titles.hover(function () { if ($(this).attr('class') != 'current') { itemMouseOver(this, _titles); } else { stop(); } }, go);
        _bodies.hover(stop, go);
        go();
    }
});