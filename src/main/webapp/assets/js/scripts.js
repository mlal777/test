function myFunction() {
  var x = document.getElementById("myDIV");
  if (x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
  }
}

function changeBG(el, tw, one, two, three, four, display){
  el = document.getElementById(el);
  tw = document.getElementById(tw);
  one = document.getElementById(one);
  two = document.getElementById(two);
  three = document.getElementById(three);
  four = document.getElementById(four);

  el.style.background = "#fff";
  el.style.boxShadow = "box-shadow: 0px 14px 24px rgba(0, 0, 0, 0.07)";
  tw.style.background = "transparent";
  tw.style.boxShadow = "none"; 

  one.style.display = display;
  two.style.display = display;
  three.style.display = display;
  four.style.display = display;

}

function Show(el, ts, tw){
  el = document.getElementById(el);
  el.style.display = "block";

  ts = document.getElementById(ts);
  ts.style.display = "block";

  tw = document.getElementById(tw);
  tw.style.display = "none";
}

function Hide(el, ts, tw){
  el = document.getElementById(el);
  el.style.display = "None";

  ts = document.getElementById(ts);
  ts.style.display = "block";

  tw = document.getElementById(tw);
  tw.style.display = "none";
}

(function($){
  "use strict";
  
  $('.komb-slider').slick({
    dots: true,
    infinite: false,
    speed: 800,
    slidesToShow: 1,
    variableWidth: true,
    swipeToSlide: true,
    prevArrow: $(".btn-carousel-prev"),
    nextArrow:$(".btn-carousel-next")
  });

  $('.komb-slider-2').slick({
    dots: true,
    infinite: false,
    speed: 800,
    slidesToShow: 1,
    variableWidth: true,
    swipeToSlide: true,
    prevArrow: $(".btn-carousel-prev-2"),
    nextArrow:$(".btn-carousel-next-2")
  });

  $('.komb-slider-3').slick({
    dots: true,
    infinite: false,
    speed: 800,
    slidesToShow: 1,
    variableWidth: true,
    swipeToSlide: true,
    prevArrow: $(".btn-carousel-prev-3"),
    nextArrow:$(".btn-carousel-next-3")
  });

  $('.komb-slider-4').slick({
    dots: true,
    infinite: false,
    speed: 800,
    slidesToShow: 1,
    variableWidth: true,
    swipeToSlide: true,
    prevArrow: $(".btn-carousel-prev-4"),
    nextArrow:$(".btn-carousel-next-4")
  });

  $('.komb-slider-5').slick({
    dots: true,
    infinite: false,
    speed: 800,
    slidesToShow: 1,
    variableWidth: true,
    swipeToSlide: true,
    prevArrow: $(".btn-carousel-prev-5"),
    nextArrow:$(".btn-carousel-next-5")
  });

  $('.mobile-menu').on('click', function() {
      var button = $(this).closest('.header-button');
      var parent = $(this).closest('.header-menu');
      if (parent.hasClass('open')) {
        $(this).closest('.app').removeClass('fixed');
        parent.removeClass('open');
        $(this).removeClass('mobile');
      } else {
        $(this).closest('.app').addClass('fixed');
        parent.addClass('open');
        $(this).addClass('mobile');
      }

      $(".product-filter").removeClass("open");
      $("body").find(".overlay-product").remove();
      $("body").removeClass("stuck-mobile");
    });
  
})(jQuery);