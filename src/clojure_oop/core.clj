(ns clojure-oop.core)

(defn invoke-fn [object]
  (fn [method & args]
    (apply method (cons object args))))

(defn new-account
  ([account-number]
   (new-account account-number 0))
  ([account-number balance]
   (invoke-fn (atom {:account-number account-number
                      :balance balance}))))

(defn get-balance [account]
  (:balance @account))

(defn set-balance [account amount]
  (swap! account assoc :balance amount))

(defn credit [account amount]
  (swap! account update :balance + amount))

(defn debit [account amount]
  (let [balance (:balance @account)]
    (if (< balance amount)
      (throw (IllegalStateException.
               "amount withdrawn exceeds the current balance!"))
      (swap! account update :balance - amount))))

(defn main [& args]
  (let [account (new-account 1234 99.99)]
    (account credit 10.001)
    (account debit 5)
    (println (account get-balance))
    (account set-balance 0)
    (println (account get-balance))))

(main)
