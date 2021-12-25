(ns advent.core
  (:require [advent.utils.input :as in]))

(defn -main [day part & _]
  (let [day (Long/parseLong day)
        sym (doto (symbol (str "advent.days.day-" day))
              require)
        ns (find-ns sym)
        f (var-get (ns-resolve ns (symbol (str "part-" part))))]
    (println "ADVENT OF CODE 2021 day" day "part" part)
    (println (f (in/input day)))))
