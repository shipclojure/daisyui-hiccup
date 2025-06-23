(ns  daisyui.dropdown-scenes
  (:require
   [daisyui.core :as ui]
   [portfolio.replicant :as portfolio :refer-macros [defscene]]))

(portfolio/configure-scenes
 {:title "Dropdown Scenes"})

(defn scene-container [& children]
  [:div {:class "h-[200px]"} children])

;; Basic dropdown using details/summary
(defscene dropdown-basic
  :title "Basic dropdown (details/summary)"
  (scene-container
   [::ui/dropdown-details
    [::ui/dropdown-summary.btn.m-1 "Open or close"]
    [::ui/dropdown-menu
     [::ui/dropdown-item [:a "Item 1"]]
     [::ui/dropdown-item [:a "Item 2"]]]]))

;; CSS focus dropdown
(defscene dropdown-css-focus
  :title "Dropdown using CSS focus"
  (scene-container
   [::ui/dropdown
    [::ui/dropdown-trigger.btn.m-1 "Click to open"]
    [::ui/dropdown-menu
     [::ui/dropdown-item [:a "Item 1"]]
     [::ui/dropdown-item [:a "Item 2"]]]]))

;; Alignment examples
(defscene dropdown-alignments
  :title "Dropdown alignments"
  (scene-container
   ;; Start alignment
   [:div.flex.gap-4
    [::ui/dropdown {::ui/alignment ::ui/start}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬇️ (start)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]
    ;; Center alignment
    [::ui/dropdown {::ui/alignment ::ui/center}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬇️ (center)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]
    ;; End alignment
    [::ui/dropdown {::ui/alignment ::ui/end}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬇️ (end)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]]))

;; Position examples
(defscene dropdown-positions
  :title "Dropdown positions"
  (scene-container
   [:div.my-16
    ;; Top position

    [::ui/dropdown {::ui/position ::ui/top}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬆️ (top)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]
    ;; Top + center
    [::ui/dropdown {::ui/position ::ui/top ::ui/alignment
                    ::ui/center}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬆️ (top+center)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]
    ;; Top + end
    [::ui/dropdown {::ui/position ::ui/top
                    ::ui/alignment ::ui/end}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬆️ (top+end)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]

    [::ui/dropdown {::ui/position ::ui/bottom}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬇️ (bottom)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]
    ;; Bottom + center
    [::ui/dropdown {::ui/position ::ui/bottom
                    ::ui/alignment ::ui/center}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬇️ (bottom+center)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]
    ;; Bottom + end
    [::ui/dropdown {::ui/position ::ui/bottom
                    ::ui/alignment ::ui/end}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬇️ (bottom+end)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]

    [::ui/dropdown {::ui/position ::ui/left}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬅️ (left)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]
    ;; Left + center
    [::ui/dropdown {::ui/position ::ui/left
                    ::ui/alignment ::ui/center}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬅️ (left+center)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]
    ;; Left + end
    [::ui/dropdown {::ui/position ::ui/left
                    ::ui/alignment ::ui/end}
     [::ui/dropdown-trigger.btn.m-1 "Click ⬅️ (left+end)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]

    [::ui/dropdown {::ui/position ::ui/right}
     [::ui/dropdown-trigger.btn.m-1 "Click ➡️ (right)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]
    ;; Right + end
    [::ui/dropdown {::ui/position ::ui/right
                    ::ui/alignment ::ui/end}
     [::ui/dropdown-trigger.btn.m-1 "Click ➡️ (right+end)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]
    ;; Right + center
    [::ui/dropdown {::ui/position ::ui/right
                    ::ui/alignment ::ui/center}
     [::ui/dropdown-trigger.btn.m-1 "Click ➡️ (right+center)"]
     [::ui/dropdown-menu
      [::ui/dropdown-item [:a "Item 1"]]
      [::ui/dropdown-item [:a "Item 2"]]]]]))

;; Modifiers
(defscene dropdown-modifiers
  :title "Dropdown modifiers"
  [:div {:class "h-[600px]"}
   [::ui/dropdown {::ui/hover? true}
    [::ui/dropdown-trigger.btn.m-1 "Hover me"]
    [::ui/dropdown-menu
     [::ui/dropdown-item [:a "Item 1"]]
     [::ui/dropdown-item [:a "Item 2"]]]]])

;; Advanced examples
(defscene dropdown-card
  :title "Card as dropdown content"
  (scene-container
   [::ui/dropdown
    [::ui/dropdown-trigger.btn.m-1 "Click for card"]
    [:div.card.card-compact.w-64.shadow-md.bg-base-100.dropdown-content {:class "z-[1]"}
     [:div {:class "card-body"}
      [:h2 {:class "card-title"} "Card in dropdown"]
      [:p "This is a card. You can use any element as a dropdown content."]]]]))

(defscene dropdown-navbar
  :title "Dropdown in navbar"
  [:div.navbar.bg-base-200.mb-40.w-full
   [:div {:class "ps-4"}
    [:button.text-lg.font-bold "daisyUI"]]
   [:div.flex.grow.justify-end.px-2
    [:div.flex.items-stretch
     [:button.btn.btn-ghost.rounded-field "Button"]
     [::ui/dropdown {::ui/alignment :end
                     ::ui/hover? true}
      [::ui/dropdown-trigger.btn.btn-ghost.rounded-field "Dropdown"]
      [::ui/dropdown-menu.mt-4.bg-base-200
       [::ui/dropdown-item [:a "Item 1"]]
       [::ui/dropdown-item [:a "Item 2"]]]]]]])

(defscene dropdown-helper
  :title "Helper dropdown"
  [:div.flex.items-center.gap-1.mb-28.mt-6
   "A normal text and a helper dropdown"
   [::ui/dropdown {::ui/alignment ::ui/end}
    [::ui/dropdown-trigger.btn.btn-circle.btn-xs.text-info
     [:svg.w-4.h-4.stroke-current
      {:xmlns "http://www.w3.org/2000/svg"
       :fill "none"
       :viewBox "0 0 24 24"}
      [:path
       {:stroke-linecap "round"
        :stroke-linejoin "round"
        :stroke-width "2"
        :d "M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"}]]]
    [:div.card.card-compact.w-64.shadow-sm.bg-base-100.rounded-box.dropdown-content {:class "z-[1]"}
     [:div {:class "card-body"}
      [:h2 {:class "card-title"} "You needed more info?"]
      [:p "Here is a description!"]]]]])
