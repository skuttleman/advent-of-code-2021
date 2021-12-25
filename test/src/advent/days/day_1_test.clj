(ns advent.days.day-1-test
  (:require
    [advent.days.day-1 :as day-1]
    [advent.utils.input :as in]
    [clojure.test :refer [are deftest is testing]]))

(deftest diffs-test
  (testing "calculates diffs between sequences"
    (are [input expected] (= expected (seq (day-1/diffs input)))
      [] nil
      [1] nil
      [1 2 3 4] [1 1 1]
      [4 3 2 1] [-1 -1 -1])))

(deftest window-test
  (testing "windows the input"
    (are [xs n expected] (= expected (seq (day-1/window n xs)))
      [] 1 nil
      [1 2 3] 4 nil
      [1 2 3] 3 [6]
      [1 2 3 4 5 6] 2 [3 5 7 9 11])))

(deftest part-1-test
  (testing "solves the puzzle"
    (is (= 7 (day-1/part-1 (in/input 1))))))

(deftest part-2-test
  (testing "solves the puzzle"
    (is (= 5 (day-1/part-2 (in/input 1))))))
