(ns clojure-oop.core
  (:require [clojure-oop.oop.util :refer [create]]
            [clojure-oop.account :refer
             [Account credit debit get-balance set-balance]]))

(defn -main [& args]
  (let [a1 (create Account 1234 99.99)]
    (a1 credit 10.001)
    (a1 debit 5)
    (println (a1 get-balance))
    (a1 set-balance 0)
    (println (a1 get-balance))))
