(ns grete.consumer
  (:require [grete.config :as config]
            [schema.core :as s])
  (:import java.util.concurrent.TimeUnit
           [org.apache.kafka.clients.consumer Consumer KafkaConsumer]
           org.apache.kafka.common.serialization.Deserializer))

(set! *warn-on-reflection* true)

(s/defschema ConsumerSchema
  {:bootstrap.servers s/Str
   :value.deserializer s/Str
   :key.deserializer s/Str})

(defn consumer
  ([config] (KafkaConsumer.
             (config/config->properties
              (s/validate ConsumerSchema config))))
  ([config ^Deserializer key-deserializer ^Deserializer value-deserializer]
   (KafkaConsumer.
    (config/config->properties
     (s/validate ConsumerSchema config))
    key-deserializer
    value-deserializer)))

;; TODO partitions format - String topic, int partition
(defn assign [^Consumer consumer partitions]
  (.assign consumer partition))

(defn assignment [^Consumer consumer]
  (.assignment consumer))

;; TODO partitions
(defn beginning-offsets [^Consumer consumer partitions]
  (.beginningOffsets consumer partitions))

(defn close!
  ([^Consumer consumer] (.close consumer))
  ([^Consumer consumer timeout] (.close consumer timeout TimeUnit/SECONDS)))

;; TODO offsets format
(defn commit-async!
  ([^Consumer consumer] (.commitAsync consumer))
  ([^Consumer consumer offsets callback] (.commitAsync consumer offsets callback)))

;; TODO offsets format
(defn commit-sync!
  ([^Consumer consumer] (.commitSync consumer))
  ([^Consumer consumer offsets] (.commitSync consumer offsets)))

;; TODO partition format
(defn committed [^Consumer consumer partition]
  (.committed consumer partition))

;; TODO partitions format
(defn endOffsets [^Consumer consumer partitions]
  (.endOffsets consumer partitions))

(defn list-topics [^Consumer consumer]
  (.listTopics consumer))

(defn metrics [^Consumer consumer]
  (.metrics consumer))

;; TODO partition-timestamps
(defn offsets-for-times [^Consumer consumer partition-timestamps]
  (.offsetsForTimes consumer partition-timestamps))

(defn partitions-for [^Consumer consumer topic]
  (.partitionsFor topic))

(defn paused [^Consumer consumer]
  (.paused consumer))

(defn poll! [^Consumer consumer timeout]
  (.poll consumer timeout))

;; TODO partition
(defn position [^Consumer consumer partition]
  (.position consumer partition))

;; TODO partitions
(defn resume! [^Consumer consumer partitions]
  (.resume consumer partitions))

;; TODO partition
(defn seek! [^Consumer consumer partition offset]
  (.seek consumer partition offset))

;; TODO partitions
(defn seek-to-beginning! [^Consumer consumer partitions]
  (.seekToBeginning consumer partitions))

;; TODO partitions
(defn seek-to-end! [^Consumer consumer partitions]
  (.seekToEnd consumer partitions))

;; TODO listener
;; TODO regex pattern
(defn subscribe!
  ([^Consumer consumer topics] (.subscribe consumer topics))
  ([^Consumer consumer topics listener] (.subscribe consumer topics listener)))

(defn subscription [^Consumer consumer]
  (.subscription consumer))

(defn unsubscribe! [^Consumer consumer]
  (.unsubscribe consumer))

(defn wakeup! [^Consumer consumer]
  (.wakeup consumer))
