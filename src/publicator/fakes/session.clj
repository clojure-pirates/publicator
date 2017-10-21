(ns publicator.fakes.session
  (:require
   [publicator.interactors.abstractions.session :as session]))

(deftype FakeSession [storage]
  session/Session
  (-get [_ k] (get @storage k))
  (-set! [_ k v] (swap! storage assoc k v)))

(defn build []
  (FakeSession. (atom {})))

(defn binding-map []
  {#'session/*session* (build)})
