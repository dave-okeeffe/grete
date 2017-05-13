(ns grete.config-test
  (:require [grete.config :as sut]
            [clojure.test :as t]))

(t/deftest map->properties-test
  (t/is (= {"a" 1 "b" "abc"}
           (sut/config->properties {:a 1 :b "abc"}))))
