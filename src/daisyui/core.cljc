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
  (let [classes (cn "loading" (:class attrs)
                    (size->loading-cls size)
                    (color->text-color-cls color)
                    (loading-variant->cls variant))]

    [:span (merge {:class classes}
                  (dissoc attrs ::size ::variant ::color))]))
