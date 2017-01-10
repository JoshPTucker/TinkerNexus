/****************************************** 
 * 
 * SLIDER STUFF
 * 
 ******************************************/
jQuery(document).ready(function ($) {

            var jssor_1_options = {
              $AutoPlay: true,
              $SlideWidth: 386,
              $SlideSpacing: 80,
              $Cols: 3,
              $Align: 466,
              $ArrowNavigatorOptions: {
                $Class: $JssorArrowNavigator$,
                $Steps: 3
              },
              $BulletNavigatorOptions: {
                $Class: $JssorBulletNavigator$,
                $Steps: 3,
                $ActionMode: 3
              }
            };

            var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);
        });

