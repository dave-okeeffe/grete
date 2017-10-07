(ns grete.config
  (:require [clojure.walk :as walk])
  (:import java.util.Properties))

(defn config->properties [config]
  (doto (Properties.)
    (.putAll (walk/stringify-keys config))))
