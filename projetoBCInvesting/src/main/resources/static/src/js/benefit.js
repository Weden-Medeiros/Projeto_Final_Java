/**
 * @name benefit carousel
 * @function handle carousel tag
 */

$(function() {
  var $carousel = $('#benefit_slider');

  // Handle carousel
  $carousel.slick({
    dots: true,
    arrows: false,
    speed: 800,
    slidesToShow: 1,
    autoplay: false,
    fade: true
  });
});
