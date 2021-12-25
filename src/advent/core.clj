(ns advent.core
  (:require
    [advent.utils.input :as in]))

(defn ^:private run [day part]
  (let [sym (doto (symbol (str "advent.days.day-" day))
              require)
        ns (find-ns sym)
        f (var-get (ns-resolve ns (symbol (str "part-" part))))]
     (f (in/input day))))

(defn -main [day part & _]
  (println "ADVENT OF CODE 2021 day" day "part" part)
  (print (run (Long/parseLong day) (Long/parseLong part))))
