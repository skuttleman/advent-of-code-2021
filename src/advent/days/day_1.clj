(ns advent.days.day-1
  (:require
    [advent.utils.input :as in]))

(defn diffs [xs]
  (loop [[x y :as xs] xs
         result []]
    (if (seq (rest xs))
      (recur (rest xs) (conj result (- y x)))
      result)))

(defn window [n xs]
  (loop [xs xs
         remaining (count xs)
         result []]
    (if (>= remaining n)
      (recur (rest xs) (dec remaining) (conj result (reduce + 0 (take n xs))))
      result)))

(defn count-diffs [xs]
  (->> xs
       diffs
       (filter pos?)
       count))

(defn part-1 [input]
  (->> input
       in/parse-ints
       count-diffs))

(defn part-2 [input]
  (->> input
       in/parse-ints
       (window 3)
       count-diffs))
