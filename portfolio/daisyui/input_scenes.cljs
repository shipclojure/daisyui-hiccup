(ns daisyui.input-scenes
  (:require
   [daisyui.core :as ui]
   [portfolio.replicant :as portfolio :refer [defscene]]))

(portfolio/configure-scenes
 {:title "Input Scenes"})

(defn scene-container [& children]
  [:div.flex.flex-col.gap-4.w-xs children])

(def search-icon
  [:svg {:class "h-[1em] opacity-50" :xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 24 24"}
   [:g {:stroke-linejoin "round" :stroke-linecap "round" :stroke-width "2.5" :fill "none" :stroke "currentColor"}
    [:circle {:cx "11" :cy "11" :r "8"}]
    [:path {:d "m21 21-4.3-4.3"}]]])

(def file-icon
  [:svg {:class "h-[1em] opacity-50" :xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 24 24"}
   [:g {:stroke-linejoin "round" :stroke-linecap "round" :stroke-width "2.5" :fill "none" :stroke "currentColor"}
    [:path {:d "M15 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7Z"}]
    [:path {:d "M14 2v4a2 2 0 0 0 2 2h4"}]]])

(def email-icon
  [:svg {:class "h-[1em] opacity-50" :xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 24 24"}
   [:g {:stroke-linejoin "round" :stroke-linecap "round" :stroke-width "2.5" :fill "none" :stroke "currentColor"}
    [:rect {:width "20" :height "16" :x "2" :y "4" :rx "2"}]
    [:path {:d "m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7"}]]])

(def user-icon
  [:svg {:class "h-[1em] opacity-50" :xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 24 24"}
   [:g {:stroke-linejoin "round" :stroke-linecap "round" :stroke-width "2.5" :fill "none" :stroke "currentColor"}
    [:path {:d "M19 21v-2a4 4 0 0 0-4-4H9a4 4 0 0 0-4 4v2"}]
    [:circle {:cx "12" :cy "7" :r "4"}]]])

(def key-icon
  [:svg {:class "h-[1em] opacity-50" :xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 24 24"}
   [:g {:stroke-linejoin "round" :stroke-linecap "round" :stroke-width "2.5" :fill "none" :stroke "currentColor"}
    [:path {:d "M2.586 17.414A2 2 0 0 0 2 18.828V21a1 1 0 0 0 1 1h3a1 1 0 0 0 1-1v-1a1 1 0 0 1 1-1h1a1 1 0 0 0 1-1v-1a1 1 0 0 1 1-1h.172a2 2 0 0 0 1.414-.586l.814-.814a6.5 6.5 0 1 0-4-4z"}]
    [:circle {:cx "16.5" :cy "7.5" :r ".5" :fill "currentColor"}]]])

(def phone-icon
  [:svg {:class "h-[1em] opacity-50" :xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 16 16"}
   [:g {:fill "none"}
    [:path {:d "M7.25 11.5C6.83579 11.5 6.5 11.8358 6.5 12.25C6.5 12.6642 6.83579 13 7.25 13H8.75C9.16421 13 9.5 12.6642 9.5 12.25C9.5 11.8358 9.16421 11.5 8.75 11.5H7.25Z" :fill "currentColor"}]
    [:path {:fill-rule "evenodd" :clip-rule "evenodd" :d "M6 1C4.61929 1 3.5 2.11929 3.5 3.5V12.5C3.5 13.8807 4.61929 15 6 15H10C11.3807 15 12.5 13.8807 12.5 12.5V3.5C12.5 2.11929 11.3807 1 10 1H6ZM10 2.5H9.5V3C9.5 3.27614 9.27614 3.5 9 3.5H7C6.72386 3.5 6.5 3.27614 6.5 3V2.5H6C5.44771 2.5 5 2.94772 5 3.5V12.5C5 13.0523 5.44772 13.5 6 13.5H10C10.5523 13.5 11 13.0523 11 12.5V3.5C11 2.94772 10.5523 2.5 10 2.5Z" :fill "currentColor"}]]])

(def link-icon
  [:svg {:class "h-[1em] opacity-50" :xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 24 24"}
   [:g {:stroke-linejoin "round" :stroke-linecap "round" :stroke-width "2.5" :fill "none" :stroke "currentColor"}
    [:path {:d "M10 13a5 5 0 0 0 7.54.54l3-3a5 5 0 0 0-7.07-7.07l-1.72 1.71"}]
    [:path {:d "M14 11a5 5 0 0 0-7.54-.54l-3 3a5 5 0 0 0 7.07 7.07l1.71-1.71"}]]])

(defscene input-default
  :title "Default Input"
  [::ui/input {:placeholder "Type here"}])


(defscene input-ghost
  :title "Ghost Style"
  [::ui/input {:placeholder "Type here" ::ui/variant ::ui/ghost}])

(defscene input-colors
  :title "Input Colors"
  (scene-container
   [::ui/input {:placeholder "Neutral" ::ui/color ::ui/neutral}]
   [::ui/input {:placeholder "Primary" ::ui/color ::ui/primary}]
   [::ui/input {:placeholder "Secondary" ::ui/color ::ui/secondary}]
   [::ui/input {:placeholder "Accent" ::ui/color ::ui/accent}]
   [::ui/input {:placeholder "Info" ::ui/color ::ui/info}]
   [::ui/input {:placeholder "Success" ::ui/color ::ui/success}]
   [::ui/input {:placeholder "Warning" ::ui/color ::ui/warning}]
   [::ui/input {:placeholder "Error" ::ui/color ::ui/error}]))

(defscene input-sizes
  :title "Input Sizes"
  (scene-container
   [::ui/input {:placeholder "Extra small" ::ui/size ::ui/xs}]
   [::ui/input {:placeholder "Small" ::ui/size ::ui/sm}]
   [::ui/input {:placeholder "Medium" ::ui/size ::ui/md}]
   [::ui/input {:placeholder "Large" ::ui/size ::ui/lg}]
   [::ui/input {:placeholder "Extra large" ::ui/size ::ui/xl}]))

(defscene input-disabled
  :title "Disabled Input"
  [::ui/input {:placeholder "You can't touch this" ::ui/disabled? true}])

(defscene input-with-fieldset
  :title "With Fieldset"
  [:fieldset.fieldset.w-xs
   [:legend.fieldset-legend "What is your name?"]
   [::ui/input {:type "text" :placeholder "Type here"}]
   [:p.label "Optional"]])

(defscene input-different-types
  :title "Different Input Types"
  (scene-container
   [::ui/input {:type "text" :placeholder "Text input"}]
   [::ui/input {:type "password" :placeholder "Password"}]
   [::ui/input {:type "email" :placeholder "Email"}]
   [::ui/input {:type "number" :placeholder "Number"}]
   [::ui/input {:type "date"}]
   [::ui/input {:type "time"}]
   [::ui/input {:type "datetime-local"}]
   [::ui/input {:type "tel" :placeholder "Phone"}]
   [::ui/input {:type "url" :placeholder "https://"}]
   [::ui/input {:type "search" :placeholder "Search"}]))

(defscene input-with-datalist
  :title "Input with Data List"
  [:div.w-xs
   [::ui/input {:type "text" :placeholder "Which browser do you use" :list "browsers"}]
   [:datalist {:id "browsers"}
    [:option {:value "Chrome"}]
    [:option {:value "Firefox"}]
    [:option {:value "Safari"}]
    [:option {:value "Opera"}]
    [:option {:value "Edge"}]]])

(defscene input-number-with-validation
  :title "Number Input with Validation"
  [:form.w-full.max-w-xs
   [::ui/input {:type "number"
                :class "validator"
                ::ui/required? true
                :placeholder "Type a number between 1 to 10"
                :min "1"
                :max "10"
                :title "Must be between be 1 to 10"}]
   [:p.validator-hint "Must be between be 1 to 10"]])

(defscene input-phone-with-validation
  :title "Phone Input with Validation"
  [:form.w-full.max-w-xs
   [:label.input.validator
    phone-icon
    [::ui/input {:type "tel"
                 :class "tabular-nums"
                 ::ui/required? true
                 :placeholder "Phone"
                 :pattern "[0-9]*"
                 :minlength "10"
                 :maxlength "10"
                 :title "Must be 10 digits"}]]
   [:p.validator-hint "Must be 10 digits"]])
