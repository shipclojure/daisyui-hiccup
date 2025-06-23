(ns daisyui.portfolio
  (:require [portfolio.ui :as portfolio]))

(portfolio/start!
 {:config
  {:css-paths ["/compiled.css"]

   :background/default-option-id :light-mode}})
