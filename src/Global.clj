(ns Global._foreign
  (:require [clojure.string :as s]))

(def nan Double/NaN)

(def infinity Double/POSITIVE_INFINITY)

(defn isNaN [^double n]
  (Double/isNaN n))

(defn isFinite [^double n]
  (Double/isFinite n))

(defn readInt [^long radix]
  (fn [^String n]
    (-> (s/replace n #"(?i:0x|\..*)" "")
        (Long/parseLong radix)
        (double))))

(defn readFloat [^String f]
  (Double/parseDouble f))
