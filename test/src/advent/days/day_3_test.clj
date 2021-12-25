(ns advent.days.day-3-test
  (:require
    [advent.days.day-3 :as day-3]
    [advent.utils.input :as in]
    [clojure.test :refer [are deftest is testing]]))

(deftest part-1-test
  (testing "solves the puzzle"
    (is (= 198 (day-3/part-1 (in/input 3))))))

(deftest part-2-test
  (testing "solves the puzzle"
    (is (= 230 (day-3/part-2 (in/input 3))))))
