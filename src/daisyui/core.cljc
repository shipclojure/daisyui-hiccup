(ns daisyui.core
  (:require
   [daisyui.utils :refer [cn]]
   [replicant.alias :refer [defalias]]))

(def colors #{::primary ::secondary ::neutral ::accent ::info ::error ::success ::warning ::ghost})

(def color->text-color-cls
  {::primary :text-primary
   ::secondary :text-secondary
   ::neutral :text-neutral
   ::accent :text-accent
   ::info :text-info
   ::error :text-error
   ::success :text-success
   ::warning :text-warning
   ::ghost :text-ghost})

(def size->loading-cls
  {::xs :loading-xs
   ::sm :loading-sm
   ::md :loading-md
   ::lg :loading-lg})

(def loading-variant->cls
  {::spinner :loading-spinner
   ::dots :loading-dots
   ::ring :loading-ring
   ::ball :loading-ball
   ::bars :loading-bars
   ::infinity :loading-infinity})

(defalias loading
  [{::keys [size variant color]
    :as attrs
    :or {size ::md
         variant ::spinner}} _]
  (let [classes (cn :loading (:class attrs)
                    (size->loading-cls size)
                    (color->text-color-cls color)
                    (loading-variant->cls variant))]

    [:span (merge {:class classes}
                  (dissoc attrs ::size ::variant ::color))]))

;; Button

(def void-element-list #{:area :base :br :col :embed :hr
                         :img :input :link :keygen :meta :param :source
                         :track, :wbr})

(def btn-variant->cls
  {::outline :btn-outline
   ::link :btn-link
   ::soft :btn-soft
   ::dash :btn-dash
   ::active :btn-active})

(def btn-shape->cls
  {::circle :btn-circle
   ::square :btn-square})

(def btn-color->cls
  {::primary :btn-primary
   ::secondary :btn-secondary
   ::neutral :btn-neutral
   ::accent :btn-accent
   ::info :btn-info
   ::error :btn-error
   ::success :btn-success
   ::warning :btn-warning
   ::ghost :btn-ghost})

(def size->btn-cls
  {::xs :btn-xs
   ::sm :btn-sm
   ::md :btn-md
   ::lg :btn-lg})

(defn- btn-classes
  "Compute classes for button component based on props."
  [{::keys [shape size variant start-icon end-icon
            full-width? glass responsive? disabled? active?
            wide? loading? color]
    :as attrs}]
  (cn :btn (:class attrs)
      (size->btn-cls size)
      (btn-shape->cls shape)
      (btn-variant->cls variant)
      (btn-color->cls color)
      (when wide?
        :btn-wide)
      (when glass
        :glass)
      (when full-width?
        :btn-block)
      (when active?
        :btn-active)
      (when disabled?
        :btn-disabled)
      (when responsive?
        "btn-xs sm:btn-sm md:btn-md lg:btn-lg")
      (when (or (and start-icon (not loading?)) end-icon)
        :gap-2)))

(defalias btn
  [{::keys [loading? start-icon end-icon size] :as attrs} base-children]
  (let [rest (dissoc attrs :class ::shape ::size ::variant ::start-icon ::end-icon
                     ::full-width? ::glass ::responsive ::disabled? ::active?
                     ::wide? ::loading? ::color ::tag)
        tag (::tag attrs :button)
        classes (btn-classes attrs)
        void-element? (void-element-list tag)
        children (when-not void-element?
                   (->> (into [(when loading? [::loading (cond-> {}
                                                           size (assoc ::size size))])
                               (when (and start-icon (not loading?)) start-icon)]
                              (into base-children end-icon))
                        (remove nil?)))]
    (into [tag (assoc rest :class classes)]
          children)))

;; Input

(def input-color->cls
  {::neutral :input-neutral
   ::primary :input-primary
   ::secondary :input-secondary
   ::accent :input-accent
   ::info :input-info
   ::success :input-success
   ::warning :input-warning
   ::error :input-error})

(def input-variant->cls
  {::ghost :input-ghost})

(def input-size->cls
  {::xs :input-xs
   ::sm :input-sm
   ::md :input-md
   ::lg :input-lg
   ::xl :input-xl})

(defn- input-classes
  "Compute classes for input component based on props."
  [{::keys [size color variant] :as attrs}]
  (cn :input (:class attrs)
      (input-size->cls size)
      (input-color->cls color)
      (input-variant->cls variant)))

(defalias input
  [attrs _]
  (let [rest (dissoc attrs :class ::size ::color ::variant ::disabled? ::required?)
        classes (input-classes attrs)]
    [:input (cond-> (assoc rest :class classes)
              (::disabled? attrs) (assoc :disabled true))]))

;; Dropdown

(def dropdown-position->cls
  {::top :dropdown-top
   ::bottom :dropdown-bottom
   ::left :dropdown-left
   ::right :dropdown-right
   ::start :dropdown-start
   ::end :dropdown-end
   ::center :dropdown-center})

(defalias dropdown
  "Dropdown container that can open a menu or any other element when clicked.
   Three methods available:
   1. details/summary (use dropdown-details)
   2. popover API (use with popover props)
   3. CSS focus (default)

   See https://daisyui.com/components/dropdown/"
  [{::keys [position alignment hover? open?] :as attr} children]
  (let [dropdown-class (cn :dropdown (:class attr)
                           (dropdown-position->cls position)
                           (dropdown-position->cls alignment)
                           (when hover? :dropdown-hover)
                           (when open? :dropdown-open))]

    [:div (-> (dissoc attr ::position ::alignment ::hover? ::open?)
              (assoc :class dropdown-class))
     children]))

(defalias dropdown-trigger
  "Trigger element for dropdown. Can be a button or any other element.
   Uses tabindex and role=button for accessibility."
  [attr children]
  [:div (merge {:tabIndex 0
                :role "button"}
               attr)
   children])

(defn render-ui-dropdown-content
  [attr children]
  [:ul (-> {:tabIndex 0}
           (merge attr)
           (assoc :class (cn "dropdown-content z-1" (:class attr))))
   children])

(defalias dropdown-content
  "Content container for dropdown items.
   Can contain menu items, cards, or any other content."
  [attr children]
  (render-ui-dropdown-content attr children))

(defalias dropdown-menu
  "Menu-styled dropdown content container."
  [{:keys [class]} children]
  (render-ui-dropdown-content
   {:class (cn "menu p-2 shadow-lg bg-base-100 rounded-box" class)
    :role "menu"}
   children))

(defalias dropdown-item
  "Individual item in a dropdown menu."
  [{::keys [active? disabled?] :as attr} children]
  [:li (-> (dissoc attr :class ::active? ::disabled?)
           (assoc :class (cn (:class attr)
                             (when active? "active")
                             (when disabled? "disabled"))))
   children])

;; Alternative implementation using details/summary
(defalias dropdown-details
  "Alternative dropdown implementation using HTML details/summary elements.
   Provides native open/close functionality."
  [{::keys [position alignment open?] :as attrs} children]
  (let [details-class (cn :dropdown (:class attrs)
                          (dropdown-position->cls position)
                          (dropdown-position->cls alignment))]

    [:details (-> (dissoc attrs ::alignment ::position ::open?)
                  {:class details-class
                   :open open?})
     children]))

(defalias dropdown-summary
  "Summary element for dropdown-details. Acts as the trigger."
  [props children]
  [:summary props
   children])

;; Mask

(def mask-shape->cls
  {::squircle :mask-squircle
   ::heart :mask-heart
   ::hexagon :mask-hexagon
   ::hexagon-2 :mask-hexagon-2
   ::decagon :mask-decagon
   ::pentagon :mask-pentagon
   ::diamond :mask-diamond
   ::square :mask-square
   ::circle :mask-circle
   ::star :mask-star
   ::star-2 :mask-star-2
   ::triangle :mask-triangle
   ::triangle-2 :mask-triangle-2
   ::triangle-3 :mask-triangle-3
   ::triangle-4 :mask-triangle-4})

(def mask-half->cls
  {::half-1 :mask-half-1
   ::half-2 :mask-half-2})

(defn mask-class
  "Generate mask classes for an element with given shape and optional half modifier."
  [{::keys [shape half] :as attrs}]
  (cn :mask (:class attrs)
      (mask-shape->cls shape)
      (mask-half->cls half)))

;; Avatar

(def avatar-size->cls
  {::xs "w-6"
   ::sm "w-8"
   ::md "w-12"
   ::lg "w-16"
   ::xl "w-20"})

(def avatar-status->cls
  {::online :avatar-online
   ::offline :avatar-offline})

(defalias avatar
  "Avatar component for displaying user profile images.
   See https://daisyui.com/components/avatar/"
  [{::keys [size status]
    :keys [src alt inner-class class]:as props} children]
  (let [avatar-class (cn :avatar class props
                         (avatar-status->cls status))
        img-class (cn (avatar-size->cls size) inner-class)]

    [:div (-> (dissoc props :src :alt ::size :inner-class :class ::status)
              (assoc :class avatar-class))
     (if children
       children
       (when src
         [:div {:class img-class}
          [:img {:src src
                 :alt (or alt "Avatar")}]]))]))
