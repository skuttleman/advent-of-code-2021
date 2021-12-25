(ns advent.days.day-2)

(defn ^:private parse [line]
  (let [[_ direction amt] (re-matches #"(\w+) (\d+)" line)]
    [(keyword direction) (Long/parseLong amt)]))

(defn ^:private move-dispatch [_ [direction]]
  direction)

(defmulti move-1 move-dispatch)

(defmulti move-2 move-dispatch)

(defmethod move-1 :forward
  [[depth position] [_ amt]]
  [depth (+ position amt)])

(defmethod move-1 :down
  [[depth position] [_ amt]]
  [(+ depth amt) position])

(defmethod move-1 :up
  [[depth position] [_ amt]]
  [(- depth amt) position])

(defmethod move-2 :forward
  [[depth position aim] [_ amt]]
  [(+ depth (* aim amt)) (+ position amt) aim])

(defmethod move-2 :down
  [[depth position aim] [_ amt]]
  [depth position (+ aim amt)])

(defmethod move-2 :up
  [[depth position aim] [_ amt]]
  [depth position (- aim amt)])

(defn ^:private solve* [[depth position]]
  (* depth position))

(defn ^:private solve [f init input]
  (->> input
       (map parse)
       (reduce f init)
       solve*))

(defn part-1 [input]
  (solve move-1 [0 0] input))

(defn part-2 [input]
  (solve move-2 [0 0 0] input))
