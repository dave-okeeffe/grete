(ns grete.config
  (:require [clojure.walk :as walk])
  (:import java.util.Properties))

;; TODO replace bootstrap.servers with bootstrap-servers?
(defn config->properties [config]
  (doto (Properties.)
    (.putAll (walk/stringify-keys config))))
