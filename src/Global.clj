(ns Global._foreign)

(def nan Double/NaN)

(def infinity  Double/POSITIVE_INFINITY)

(defn isNaN [^double n]
  (Double/isNaN n))

(defn isFinite [^double n]
  (Double/isFinite n))

(defn readInt [^long radix]
  (fn [^String n]
    (Integer/parseInt n radix)))

(defn readFloat [^String f]
  (Double/parseDouble f))
