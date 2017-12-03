(ns publicator.core
  (:require
   [publicator.init]
   [com.stuartsierra.component :as component]
   [publicator.systems.impl :as systems.impl]))

(defn data-source-opts []
  (let [database-url                   (System/getenv "DATABASE_URL")
        pattern                        #"postgres://(\S+):(\S+)@(\S+):(\S+)/(\S+)"
        [_ user password host port db] (re-matches pattern  database-url)]
    {:jdbc-url (str "jdbc:postgresql://" host ":" port "/" db "?sslmode=require")
     :user     user
     :password password}))

(defn http-opts []
  {:host "0.0.0.0"
   :port (bigint (System/getenv "PORT"))})

;; todo: stop
;; https://github.com/pyr/signal
(defn -main [& _]
  (let [system (systems.impl/build
                {:http-opts (http-opts)
                 :data-source-opts (data-source-opts)})]
    (component/start system)))
