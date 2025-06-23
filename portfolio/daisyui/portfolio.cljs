(ns daisyui.portfolio
  (:require [daisyui.core]
            [daisyui.loading-scenes]
            [portfolio.ui :as portfolio]))

(portfolio/start!
 {:config
  {:css-paths ["/compiled.css"]

   :background/default-option-id :light-mode}})
