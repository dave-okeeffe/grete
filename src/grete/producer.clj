(ns grete.producer
  (:require [grete.config :as config]
            [schema.core :as s])
  (:import [org.apache.kafka.clients.producer
            KafkaProducer Producer ProducerRecord]
           org.apache.kafka.common.serialization.Serializer))

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

(defn ptns-for [^Producer producer topic]
  (.ptnsFor producer topic))

(defn message->record
  "Converts a message to a ProducerRecord to be sent using a producer"
  ([topic message]
   (ProducerRecord. topic message))
  ([topic k message]
   (ProducerRecord. topic k message))
  ([topic ptn k message]
   (ProducerRecord. topic ptn k message)))

(defn send!
  ([^Producer producer topic message]
   (.send producer (message->record topic message)))
  ([^Producer producer topic k message]
   (.send producer (message->record topic k message)))
  ([^Producer producer topic ptn k message]
   (.send producer (message->record topic ptn k message))))
