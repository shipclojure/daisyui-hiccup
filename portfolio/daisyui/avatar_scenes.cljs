(ns daisyui.avatar-scenes
  (:require
   [daisyui.core :as ui]
   [portfolio.replicant :as portfolio :refer-macros [defscene]]))

(portfolio/configure-scenes
 {:title "Avatar Component Scenes"})

(defn scene-container [& children]
  [:div.flex.flex-wrap.items-center.gap-3 children])

;; --------------------------
;; Basic Avatar Scenes
;; --------------------------

(defscene avatar-default
  :title "Default Avatar"
  [::ui/avatar
   {:src "https://img.daisyui.com/images/profile/demo/batperson@192.webp"
    :inner-class "w-24 rounded bg-base-300"}])

(defscene avatar-sizes
  :title "Avatar Sizes"
  (scene-container
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/superperson@192.webp"
     :inner-class "w-32 rounded bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/superperson@192.webp"
     :inner-class "w-20 rounded bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/superperson@192.webp"
     :inner-class "w-16 rounded bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/superperson@192.webp"
     :inner-class "w-8 rounded bg-base-300"}]))

(defscene avatar-predefined-sizes
  :title "Avatar Predefined Sizes"
  (scene-container
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/superperson@192.webp"
     ::ui/size ::ui/xl
     :inner-class "rounded bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/superperson@192.webp"
     ::ui/size ::ui/lg
     :inner-class "rounded bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/superperson@192.webp"
     ::ui/size ::ui/md
     :inner-class "rounded bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/superperson@192.webp"
     ::ui/size ::ui/sm
     :inner-class "rounded bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/superperson@192.webp"
     ::ui/size ::ui/xs
     :inner-class "rounded bg-base-300"}]))

;; --------------------------
;; Avatar Shapes
;; --------------------------

(defscene avatar-rounded
  :title "Avatar Rounded"
  (scene-container
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/yellingwoman@192.webp"
     :inner-class "w-24 rounded-xl bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/yellingcat@192.webp"
     :inner-class "w-24 rounded-full bg-base-300"}]))

(defscene avatar-with-mask
  :title "Avatar with Mask"
  (scene-container
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/distracted3@192.webp"
     :inner-class "w-24 mask mask-heart bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/distracted1@192.webp"
     :inner-class "w-24 mask mask-squircle bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/distracted2@192.webp"
     :inner-class "w-24 mask mask-hexagon-2 bg-base-300"}]))

;; --------------------------
;; Avatar Groups
;; --------------------------

(defscene avatar-group
  :title "Avatar Group"
  [:div.avatar-group.-space-x-6
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/batperson@192.webp"
     :inner-class "w-12 bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/spiderperson@192.webp"
     :inner-class "w-12 bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/averagebulk@192.webp"
     :inner-class "w-12 bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/wonderperson@192.webp"
     :inner-class "w-12 bg-base-300"}]])

(defscene avatar-group-with-counter
  :title "Avatar Group with Counter"
  [:div.avatar-group.-space-x-6
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/batperson@192.webp"
     :inner-class "w-12 bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/spiderperson@192.webp"
     :inner-class "w-12 bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/averagebulk@192.webp"
     :inner-class "w-12 bg-base-300"}]
   [::ui/avatar
    {:class "avatar-placeholder"
     :inner-class "w-12 bg-neutral text-neutral-content"}
    [:span "+99"]]])

;; --------------------------
;; Avatar with Ring
;; --------------------------

(defscene avatar-with-ring
  :title "Avatar with Ring"
  [::ui/avatar
   {:src "https://img.daisyui.com/images/profile/demo/spiderperson@192.webp"
    :inner-class "w-24 rounded-full ring-2 ring-primary ring-offset-base-100 ring-offset-2"}])

;; --------------------------
;; Avatar with Presence Indicator
;; --------------------------

(defscene avatar-presence-indicator
  :title "Avatar with Presence Indicator"
  (scene-container
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/gordon@192.webp"
     ::ui/status ::ui/online
     :inner-class "w-24 rounded-full bg-base-300"}]
   [::ui/avatar
    {:src "https://img.daisyui.com/images/profile/demo/idiotsandwich@192.webp"
     ::ui/status ::ui/offline
     :inner-class "w-24 rounded-full bg-base-300"}]))

;; --------------------------
;; Avatar Placeholder
;; --------------------------

(defscene avatar-placeholder
  :title "Avatar Placeholder"
  (scene-container
   [::ui/avatar
    {:class "avatar-placeholder"
     :inner-class "bg-neutral text-neutral-content rounded-full w-24"}
    [:span.text-3xl "D"]]
   [::ui/avatar
    {:avatar/online? true
     :class "avatar-placeholder"
     :inner-class "bg-neutral text-neutral-content rounded-full w-16"}
    [:span.text-xl "AI"]]
   [::ui/avatar
    {:class "avatar-placeholder"
     :inner-class "bg-neutral text-neutral-content rounded-full w-12"}
    [:span "SY"]]
   [::ui/avatar
    {:class "avatar-placeholder"
     :inner-class "bg-neutral text-neutral-content rounded-full w-8"}
    [:span.text-xs "UI"]]))
