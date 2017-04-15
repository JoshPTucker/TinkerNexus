/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
/* hide nav by default */
$('.primary-nav').hide();

/* Slick Carousel */
$('.carousel').slick({
  prevArrow: "<img class='pArrow' src='css/images/prevArrow.png'>",
  nextArrow: "<img class='nArrow' src='css/images/nextArrow.png'>",
  arrows: true,
  dots: true,
  autoplay: true,
  autoplaySpeed: 6000,
  infinite: true,
  speed: 710,
  slidesToShow: 3,
  slidesToScroll: 3,
  responsive: [
    {
      breakpoint: 1024,
      settings: {
        slidesToShow: 3,
        slidesToScroll: 3,
        infinite: true,
        dots: true
      }
    },
    {
      breakpoint: 600,
      settings: {
        slidesToShow: 2,
        slidesToScroll: 2
      }
    },
    {
      breakpoint: 480,
      settings: {
        slidesToShow: 1,
        slidesToScroll: 1
      }
    }
  ]
});
});