(ns clojure-oop.account)

(defn Account
  ([account-number]
   (Account account-number 0))
  ([account-number balance]
   (atom {:account-number account-number :balance balance})))

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
