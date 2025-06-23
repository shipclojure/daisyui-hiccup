(ns daisyui.badge-scenes
  (:require
   [daisyui.core :as ui]
   [portfolio.replicant :as portfolio :refer-macros [defscene]]))

(portfolio/configure-scenes
  {:title "Badge Component Scenes"})

(defn scene-container [& children]
  [:div.flex.flex-wrap.items-center.gap-3 children])

;; --------------------------
;; Basic Badge Scenes
;; --------------------------

(defscene badge-default
  :title "Default Badge"
  [::ui/badge "Badge"])

(defscene badge-sizes
  :title "Badge Sizes"
  (scene-container
    [::ui/badge {::ui/size ::ui/xs} "XS"]
    [::ui/badge {::ui/size ::ui/sm} "Small"]
    [::ui/badge {::ui/size ::ui/md} "Medium"]
    [::ui/badge {::ui/size ::ui/lg} "Large"]
    [::ui/badge {::ui/size ::ui/xl} "XLarge"]))

;; --------------------------
;; Badge Colors
;; --------------------------

(defscene badge-colors
  :title "Badge Colors"
  (scene-container
    [::ui/badge {::ui/color ::ui/primary} "Primary"]
    [::ui/badge {::ui/color ::ui/secondary} "Secondary"]
    [::ui/badge {::ui/color ::ui/accent} "Accent"]
    [::ui/badge {::ui/color ::ui/neutral} "Neutral"]
    [::ui/badge {::ui/color ::ui/info} "Info"]
    [::ui/badge {::ui/color ::ui/success} "Success"]
    [::ui/badge {::ui/color ::ui/warning} "Warning"]
    [::ui/badge {::ui/color ::ui/error} "Error"]))

;; --------------------------
;; Badge Variants
;; --------------------------

(defscene badge-soft-style
  :title "Badge Soft Style"
  (scene-container
    [::ui/badge {::ui/variant ::ui/soft ::ui/color ::ui/primary} "Primary"]
    [::ui/badge {::ui/variant ::ui/soft ::ui/color ::ui/secondary} "Secondary"]
    [::ui/badge {::ui/variant ::ui/soft ::ui/color ::ui/accent} "Accent"]
    [::ui/badge {::ui/variant ::ui/soft ::ui/color ::ui/info} "Info"]
    [::ui/badge {::ui/variant ::ui/soft ::ui/color ::ui/success} "Success"]
    [::ui/badge {::ui/variant ::ui/soft ::ui/color ::ui/warning} "Warning"]
    [::ui/badge {::ui/variant ::ui/soft ::ui/color ::ui/error} "Error"]))

(defscene badge-outline-style
  :title "Badge Outline Style"
  (scene-container
    [::ui/badge {::ui/variant ::ui/outline ::ui/color ::ui/primary} "Primary"]
    [::ui/badge {::ui/variant ::ui/outline ::ui/color ::ui/secondary} "Secondary"]
    [::ui/badge {::ui/variant ::ui/outline ::ui/color ::ui/accent} "Accent"]
    [::ui/badge {::ui/variant ::ui/outline ::ui/color ::ui/info} "Info"]
    [::ui/badge {::ui/variant ::ui/outline ::ui/color ::ui/success} "Success"]
    [::ui/badge {::ui/variant ::ui/outline ::ui/color ::ui/warning} "Warning"]
    [::ui/badge {::ui/variant ::ui/outline ::ui/color ::ui/error} "Error"]))

(defscene badge-dash-style
  :title "Badge Dash Style"
  (scene-container
    [::ui/badge {::ui/variant ::ui/dash ::ui/color ::ui/primary} "Primary"]
    [::ui/badge {::ui/variant ::ui/dash ::ui/color ::ui/secondary} "Secondary"]
    [::ui/badge {::ui/variant ::ui/dash ::ui/color ::ui/accent} "Accent"]
    [::ui/badge {::ui/variant ::ui/dash ::ui/color ::ui/info} "Info"]
    [::ui/badge {::ui/variant ::ui/dash ::ui/color ::ui/success} "Success"]
    [::ui/badge {::ui/variant ::ui/dash ::ui/color ::ui/warning} "Warning"]
    [::ui/badge {::ui/variant ::ui/dash ::ui/color ::ui/error} "Error"]))

(defscene badge-ghost-style
  :title "Badge Ghost Style"
  [::ui/badge {::ui/variant ::ui/ghost} "Ghost"])

;; --------------------------
;; Special Badge Cases
;; --------------------------

(defscene badge-empty
  :title "Empty Badges"
  (scene-container
    [::ui/badge {::ui/color ::ui/primary ::ui/size ::ui/lg} "lg"]
    [::ui/badge {::ui/color ::ui/primary ::ui/size ::ui/md} "md"]
    [::ui/badge {::ui/color ::ui/primary ::ui/size ::ui/sm} "sm"]
    [::ui/badge {::ui/color ::ui/primary ::ui/size ::ui/xs} "xs"]))

(defscene badge-with-icons
  :title "Badge with Icons"
  (scene-container
    [::ui/badge {::ui/color ::ui/info}
     [::ui/icon {:icon/name :circle-check :class "size-[1em]"}]
     " Info"]
    [::ui/badge {::ui/color ::ui/success}
     [::ui/icon {:icon/name :check :class "size-[1em]"}]
     " Success"]
    [::ui/badge {::ui/color ::ui/warning}
     [::ui/icon {:icon/name :circle-x :class "size-[1em]"}]
     " Warning"]
    [::ui/badge {::ui/color ::ui/error}
     [::ui/icon {:icon/name :x :class "size-[1em]"}]
     " Error"]))

;; --------------------------
;; Badge in Context
;; --------------------------

(defscene badge-in-text
  :title "Badge in Text"
  [:div.grid.gap-2
   [:span.text-xl.font-semibold
    "Heading 1 "
    [::ui/badge {::ui/size ::ui/xl} "Badge"]]
   [:span.text-lg.font-semibold
    "Heading 2 "
    [::ui/badge {::ui/size ::ui/lg} "Badge"]]
   [:span.text-base.font-semibold
    "Heading 3 "
    [::ui/badge {::ui/size ::ui/md} "Badge"]]
   [:span.text-sm.font-semibold
    "Heading 4 "
    [::ui/badge {::ui/size ::ui/sm} "Badge"]]
   [:span.text-xs.font-semibold
    "Heading 5 "
    [::ui/badge {::ui/size ::ui/xs} "Badge"]]
   [:p.text-xs
    "Paragraph "
    [::ui/badge {::ui/size ::ui/xs} "Badge"]]])

(defscene badge-in-button
  :title "Badge in Button"
  (scene-container
    [::ui/button
     "Inbox "
     [::ui/badge {::ui/size ::ui/sm} "+99"]]
    [::ui/button
     "Inbox "
     [::ui/badge {::ui/size ::ui/sm ::ui/color ::ui/secondary} "+99"]]))

;; --------------------------
;; Badge Combinations
;; --------------------------

(defscene badge-showcase
  :title "Badge Showcase"
  [:div.space-y-4
   [:div
    [:h3.text-lg.font-semibold.mb-2 "Status Badges"]
    (scene-container
      [::ui/badge {::ui/color ::ui/success ::ui/variant ::ui/soft} "Active"]
      [::ui/badge {::ui/color ::ui/warning ::ui/variant ::ui/soft} "Pending"]
      [::ui/badge {::ui/color ::ui/error ::ui/variant ::ui/soft} "Inactive"]
      [::ui/badge {::ui/color ::ui/info ::ui/variant ::ui/soft} "Draft"])]

   [:div
    [:h3.text-lg.font-semibold.mb-2 "Priority Badges"]
    (scene-container
      [::ui/badge {::ui/color ::ui/error} "High"]
      [::ui/badge {::ui/color ::ui/warning} "Medium"]
      [::ui/badge {::ui/color ::ui/success} "Low"])]

   [:div
    [:h3.text-lg.font-semibold.mb-2 "Category Badges"]
    (scene-container
      [::ui/badge {::ui/variant ::ui/outline ::ui/color ::ui/primary} "Frontend"]
      [::ui/badge {::ui/variant ::ui/outline ::ui/color ::ui/secondary} "Backend"]
      [::ui/badge {::ui/variant ::ui/outline ::ui/color ::ui/accent} "Design"]
      [::ui/badge {::ui/variant ::ui/outline ::ui/color ::ui/info} "DevOps"])]])
