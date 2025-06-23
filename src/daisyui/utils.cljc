(ns daisyui.utils
  (:require
   [clojure.string :as str]
   [twmerge.core :refer [tw-merge]]))

(defn- process-kw-class
  [kw]
  (str/split (name kw) #"\."))

(defn- process-str-class
  [str]
  (str/split str #"\s+")) ;; handle multiple spaces

(defn- process-map-class
  [m]
  (for [[k v] m :when v]
    (if (keyword? k) (name k) (str k))))

(process-map-class {"hello world" true "world" false "disabled" true})

(defn- process-class
  [class]
  (cond
    (keyword? class) (process-kw-class class)
    (string? class) (process-str-class class)
    (map? class) (process-map-class class)
    (seq class) (mapcat process-class class)
    :else []))

(defn- clsx
  "Takes an array of classes in the form of keywords or strings and
  returns the joined classes with no duplicates"
  [& classes]
  (str/split (->> classes
                  (transduce
                   (comp (mapcat process-class)
                         (remove #(or (nil? %) (empty? %)))
                         (distinct))
                   conj)
                  (str/join " ")
                  tw-merge)
             #"\s"))

(comment
  (clsx [:hello :world] #{"Hello"})
  (clsx :hello.world :world :yagg nil "world hello" " yagg " "yag" "hello again" "YUooooo" "yohoo" {"yohoo" true})

  (clsx :w-full "w-[100px]" :w-5)
  ;; => "hello world yagg yag again YUooooo"
  (cn :text.red.bg-blue :text.green.bg-yellow :text.red.bg-blue
      "bg-blue text-red" "bg-blue text-red" "bg-blue text-red" "bg-blue text-red")
  ;; => "text red bg-blue green bg-yellow text-red"

  :rfc)

(def cn
  "Takes an array of classes and returns the joined classes with no duplicates. Memoizes result"
  (memoize clsx))
