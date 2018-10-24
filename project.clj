(defproject grete "0.1.0-SNAPSHOT"
  :description "Clojure wrapper for the Java Kafka Client"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.apache.kafka/kafka-clients "2.0.0"]
                 [prismatic/schema "1.1.9"]]
  :profiles {:system {:plugins [[jonase/eastwood "0.3.1"]
                                [lein-ancient "0.6.15"]
                                [lein-bikeshed "0.5.1"]
                                [lein-cljfmt "0.6.1"]
                                [lein-kibit "0.1.6"]]}})
