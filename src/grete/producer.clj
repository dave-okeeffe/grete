(ns grete.producer
  (:require [grete.config :as config]
            [schema.core :as s])
  (:import org.apache.kafka.common.serialization.Serializer
           [org.apache.kafka.clients.producer KafkaProducer Producer]))

(set! *warn-on-reflection* true)

(defn producer
  ([config] (KafkaProducer.
             (config/config->properties config)))
  ([config ^Serializer key-serializer ^Serializer value-serializer]
   (KafkaProducer.
    (config/config->properties config)
    key-serializer
    value-serializer)))

(defn close! [^Producer producer]
  (.close producer))

(defn flush! [^Producer producer]
  (.flush producer))

(defn metrics [^Producer producer]
  (.metrics producer))

(defn partitions-for [^Producer producer topic]
  (.partitionsFor producer topic))

(defn send!
  ([^Producer producer record] (.send producer record))
  ([^Producer producer record callback] (.send producer record callback)))
