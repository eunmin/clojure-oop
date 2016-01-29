(ns clojure-oop.oop.util)

(defn- invoke-fn [object]
  (fn [method & args]
    (apply method (cons object args))))

(defn create [initializer & args]
  (invoke-fn (atom (apply initializer args))))


