(ns daisyui.portfolio
  (:require [daisyui.button-scenes]
            [daisyui.core]
            [daisyui.dropdown-scenes]
            [daisyui.input-scenes]
            [daisyui.loading-scenes]
            [portfolio.ui :as portfolio]))

(portfolio/start!
 {:config
  {:css-paths ["/compiled.css"]

   :background/default-option-id :light-mode}})
