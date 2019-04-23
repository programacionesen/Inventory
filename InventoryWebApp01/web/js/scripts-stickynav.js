$(function() {
 
  // Do our DOM lookups beforehand
  var nav_container = $(".js--main-nav");
  var nav = $("nav");
 
  nav_container.waypoint({
    handler: function(direction) {
        nav.toggleClass('sticky', direction=='down');
    }
  });

 
});