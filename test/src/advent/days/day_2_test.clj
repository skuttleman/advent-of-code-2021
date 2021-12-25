(ns advent.days.day-2-test
  (:require
    [advent.days.day-2 :as day-2]
    [advent.utils.input :as in]
    [clojure.test :refer [are deftest is testing]]))

(deftest move-1-test
  (testing "moves forward"
    (is (= [1 9] (day-2/move-1 [1 2] [:forward 7]))))

  (testing "moves up"
    (is (= [-6 2] (day-2/move-1 [1 2] [:up 7]))))

  (testing "moves down"
    (is (= [8 2] (day-2/move-1 [1 2] [:down 7])))))

(deftest move-2-test
  (testing "moves forward"
    (is (= [22 9 3] (day-2/move-2 [1 2 3] [:forward 7]))))

  (testing "moves up"
    (is (= [1 2 -4] (day-2/move-2 [1 2 3] [:up 7]))))

  (testing "moves down"
    (is (= [1 2 10] (day-2/move-2 [1 2 3] [:down 7])))))

(deftest part-1-test
  (testing "solves the puzzle"
    (is (= 150 (day-2/part-1 (in/input 2))))))

(deftest part-2-test
  (testing "solves the puzzle"
    (is (= 900 (day-2/part-2 (in/input 2))))))
