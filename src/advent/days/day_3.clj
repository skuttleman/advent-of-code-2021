(ns advent.days.day-3
  (:require [advent.utils.input :as in]))

(defn ^:private digits [s]
  (mapv #(- (int %) 48) s))

(defn ^:private reduce-counts [xs]
  (let [init (mapv (constantly [0 0]) (first xs))]
    (reduce (fn [pairs bin]
              (mapv (fn [[zeros ones] digit]
                      [(cond-> zeros
                         (zero? digit) inc)
                       (cond-> ones
                         (not (zero? digit)) inc)])
                    pairs
                    bin))
            init
            xs)))

(defn ^:private pairs->digits [f pairs]
  (mapv (fn [[zeros ones]]
          (if (f zeros ones)
            0
            1))
        pairs))

(defn ^:private digits->num [pow num digits]
  (if-let [digit (peek digits)]
    (recur (inc pow) (+ num (int (* digit (Math/pow 2 pow)))) (pop digits))
    num))

(defn ^:private find-pred [pred idx digits]
  (if (= 1 (count digits))
    (first digits)
    (let [[zeros ones] (nth (reduce-counts digits) idx)]
      (recur pred
             (inc idx)
             (filter (comp (partial pred zeros ones) #(nth % idx))
                     digits)))))

(defn ^:private oxygen? [zeros ones digit]
  (if (> zeros ones)
    (= 0 digit)
    (= 1 digit)))

(defn ^:private co2? [zeros ones digit]
  (if (< ones zeros)
    (= 1 digit)
    (= 0 digit)))

(defn part-1 [input]
  (let [counts (->> input
                    (map digits)
                    reduce-counts)
        gamma (->> counts (pairs->digits >) (digits->num 0 0))
        epsilon (->> counts (pairs->digits <) (digits->num 0 0))]
    (* gamma epsilon)))

(defn part-2 [input]
  (let [digits (map digits input)
        oxygen (find-pred oxygen? 0 digits)
        co2 (find-pred co2? 0 digits)]
    (* (->> oxygen (digits->num 0 0))
       (->> co2 (digits->num 0 0)))))
