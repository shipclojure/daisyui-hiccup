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
