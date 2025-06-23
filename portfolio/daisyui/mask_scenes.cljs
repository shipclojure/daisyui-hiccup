(ns daisyui.mask-scenes
  (:require
   [daisyui.core :as ui]
   [portfolio.replicant :as portfolio :refer [defscene]]))

(portfolio/configure-scenes
 {:title "Mask Scenes"})

(def sample-image "https://img.daisyui.com/images/stock/photo-1567653418876-5bb0e566e1c2.webp")

(defn mask-scene [shape title]
  [:img {:alt (str title " CSS mask")
         :class (ui/mask-class {::ui/shape shape :class "w-40 h-40"})
         :src sample-image}])

(defscene mask-squircle
  :title "Squircle"
  (mask-scene ::ui/squircle "Squircle"))

(defscene mask-heart
  :title "Heart"
  (mask-scene ::ui/heart "Heart"))

(defscene mask-hexagon
  :title "Hexagon (vertical)"
  (mask-scene ::ui/hexagon "Hexagon"))

(defscene mask-hexagon-2
  :title "Hexagon-2 (horizontal)"
  (mask-scene ::ui/hexagon-2 "Hexagon-2"))

(defscene mask-decagon
  :title "Decagon"
  (mask-scene ::ui/decagon "Decagon"))

(defscene mask-pentagon
  :title "Pentagon"
  (mask-scene ::ui/pentagon "Pentagon"))

(defscene mask-diamond
  :title "Diamond"
  (mask-scene ::ui/diamond "Diamond"))

(defscene mask-square
  :title "Square"
  (mask-scene ::ui/square "Square"))

(defscene mask-circle
  :title "Circle"
  (mask-scene ::ui/circle "Circle"))

(defscene mask-star
  :title "Star"
  (mask-scene ::ui/star "Star"))

(defscene mask-star-2
  :title "Star-2 (bold)"
  (mask-scene ::ui/star-2 "Star-2"))

(defscene mask-triangle
  :title "Triangle (pointing top)"
  (mask-scene ::ui/triangle "Triangle"))

(defscene mask-triangle-2
  :title "Triangle-2 (pointing down)"
  (mask-scene ::ui/triangle-2 "Triangle-2"))

(defscene mask-triangle-3
  :title "Triangle-3 (pointing left)"
  (mask-scene ::ui/triangle-3 "Triangle-3"))

(defscene mask-triangle-4
  :title "Triangle-4 (pointing right)"
  (mask-scene ::ui/triangle-4 "Triangle-4"))

(defscene mask-shapes-grid
  :title "All Mask Shapes"
  [:div.grid.grid-cols-4.gap-4
   (mask-scene ::ui/squircle "Squircle")
   (mask-scene ::ui/heart "Heart")
   (mask-scene ::ui/hexagon "Hexagon")
   (mask-scene ::ui/hexagon-2 "Hexagon-2")
   (mask-scene ::ui/decagon "Decagon")
   (mask-scene ::ui/pentagon "Pentagon")
   (mask-scene ::ui/diamond "Diamond")
   (mask-scene ::ui/square "Square")
   (mask-scene ::ui/circle "Circle")
   (mask-scene ::ui/star "Star")
   (mask-scene ::ui/star-2 "Star-2")
   (mask-scene ::ui/triangle "Triangle")
   (mask-scene ::ui/triangle-2 "Triangle-2")
   (mask-scene ::ui/triangle-3 "Triangle-3")
   (mask-scene ::ui/triangle-4 "Triangle-4")])

(defscene mask-half-modifiers
  :title "Mask Half Modifiers"
  [:div.flex.gap-4
   [:div.text-center
    [:img {:alt "Half-1 mask"
           :class (ui/mask-class {::ui/shape ::ui/circle ::ui/half ::ui/half-1 :class "w-32 h-32"})
           :src sample-image}]
    [:p.mt-2 "Half-1"]]
   [:div.text-center
    [:img {:alt "Half-2 mask"
           :class (ui/mask-class {::ui/shape ::ui/circle ::ui/half ::ui/half-2 :class "w-32 h-32"})
           :src sample-image}]
    [:p.mt-2 "Half-2"]]])

(defscene mask-different-elements
  :title "Mask on Different Elements"
  [:div.flex.gap-4.items-center
   [:img {:alt "Masked image"
          :class (ui/mask-class {::ui/shape ::ui/heart :class "w-24 h-24"})
          :src sample-image}]
   [:div {:class (ui/mask-class {::ui/shape ::ui/star :class "w-24 h-24 bg-gradient-to-r from-pink-500 to-violet-500"})}]
   [:div {:class (ui/mask-class {::ui/shape ::ui/hexagon :class "w-24 h-24 bg-primary"})}]])

(defscene mask-with-avatar
  :title "Mask as Avatar"
  [:div.flex.gap-4.items-center
   [:div.avatar
    [:div {:class (ui/mask-class {::ui/shape ::ui/squircle :class "w-24"})}
     [:img {:src sample-image}]]]
   [:div.avatar
    [:div {:class (ui/mask-class {::ui/shape ::ui/hexagon :class "w-24"})}
     [:img {:src sample-image}]]]
   [:div.avatar
    [:div {:class (ui/mask-class {::ui/shape ::ui/circle :class "w-24"})}
     [:img {:src sample-image}]]]])