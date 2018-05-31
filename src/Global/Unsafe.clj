(ns Global.Unsafe._foreign
  (:import [javax.script ScriptEngine ScriptEngineManager]))

(def ^{:private true, :tag ScriptEngine} engine
  (let [manager (ScriptEngineManager.)]
    (.getEngineByName manager "javascript")))

(defn- run-js [^String js]
  (.eval engine js))

(def unsafeStringify pr-str)

(defn unsafeToFixed ^String [^long digits]
  (fn [^double n]
    (run-js (format "var x = %s; x.toFixed(%s);" n digits))))

(defn unsafeToExponential ^String [^long digits]
  (fn [^double n]
    (run-js (format "var x = %s; x.toExponential(%s);" n digits))))

(defn unsafeToPrecision ^String [^long digits]
  (fn [^double n]
    (run-js (format "var x = %s; x.toPrecision(%s);" n digits))))

(defn unsafeDecodeURI [s]
  (run-js (format "decodeURI(%s);" (pr-str s))))

(defn unsafeEncodeURI [s]
  (run-js (format "encodeURI(%s);" (pr-str s))))

(defn unsafeDecodeURIComponent [s]
  (run-js (format "decodeURIComponent(%s);" (pr-str s))))

(defn unsafeEncodeURIComponent [s]
  (run-js (format "encodeURIComponent(%s);" (pr-str s))))