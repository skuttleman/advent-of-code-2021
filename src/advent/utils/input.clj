(ns advent.utils.input
  (:require
    [clojure.java.io :as io]
    [clojure.string :as string]))

(defn input [day]
  (string/split-lines (slurp (io/resource (format "fixtures/day-%d.txt" day)))))
