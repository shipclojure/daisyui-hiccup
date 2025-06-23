(ns daisyui.portfolio
  (:require [daisyui.avatar-scenes]
            [daisyui.button-scenes]
            [daisyui.core]
            [daisyui.dropdown-scenes]
            [daisyui.input-scenes]
            [daisyui.loading-scenes]
            [daisyui.mask-scenes]
            [portfolio.ui :as portfolio]))

(portfolio/start!
 {:config
  {:css-paths ["/compiled.css"]

   :background/default-option-id :light-mode}})
