(ns daisyui.loading-scenes
  (:require [daisyui.core :as ui]
            [portfolio.replicant :refer [defscene]]))

(defscene loading-sizes
  :title "Loading sizes"
  [:div.flex.gap-2
   (for [size (keys ui/size->loading-cls)]
     [::ui/loading {::ui/size size}])])

(defscene loading-dots
  :title "Loading dots"
  [:div.flex.gap-2
   (for [size (keys ui/size->loading-cls)]
     [::ui/loading {::ui/size size
                    ::ui/variant ::ui/dots}])])


(defscene loading-ring
  :title "Loading ring"
  [:div.flex.gap-2
   (for [size (keys ui/size->loading-cls)]
     [::ui/loading {::ui/size size
                    ::ui/variant ::ui/ring}])])


(defscene loading-ball
  :title "Loading ball"
  [:div.flex.gap-2
   (for [size (keys ui/size->loading-cls)]
     [::ui/loading {::ui/size size
                    ::ui/variant ::ui/ball}])])

(defscene loading-bars
  :title "Loading bars"
  [:div.flex.gap-2
   (for [size (keys ui/size->loading-cls)]
     [::ui/loading {::ui/size size
                    ::ui/variant ::ui/bars}])])

(defscene loading-infinity
  :title "Loading infinity"
  [:div.flex.gap-2
   (for [size (keys ui/size->loading-cls)]
     [::ui/loading {::ui/size size
                    ::ui/variant ::ui/infinity}])])


(defscene loading-colors
  :title "Loading colors"
  [:div.flex.gap-2
   (for [color [::ui/primary ::ui/secondary ::ui/neutral ::ui/accent ::ui/info ::ui/error ::ui/success ::ui/warning ::ui/ghost]]
     [::ui/loading {::ui/color color}])])
