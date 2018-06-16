(ns publicator.crypto.password-hasher-test
  (:require
   [clojure.test :as t]
   [publicator.utils.test.instrument :as instrument]
   [publicator.crypto.password-hasher :as sut]
   [publicator.domain.abstractions.password-hasher :as password-hasher]))

(defn- setup [t]
  (with-bindings (sut/binding-map)
    (t)))

(t/use-fixtures :once
  instrument/fixture)

(t/use-fixtures :each
  setup)

(t/deftest ok
  (let [pass   "strong password"
        digest (password-hasher/derive pass)]
    (t/is (password-hasher/check pass digest))))
