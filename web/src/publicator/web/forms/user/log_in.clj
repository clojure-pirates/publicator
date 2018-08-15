(ns publicator.web.forms.user.log-in
  (:require
   [publicator.web.routing :as routing]))

(defn description []
  {:widget :submit, :name "Войти",
   :url (routing/path-for :user.log-in/process), :method :post, :nested
   {:widget :group, :nested
    [:login {:widget :input, :label "Логин"}
     :password {:widget :input, :label "Пароль", :type "password"}]}})

(defn build [initial-params]
  {:initial-data initial-params
   :errors       {}
   :description  (description)})

(defn authentication-failed-error []
  {:form-ujs/error "Неверный логин или пароль"})
