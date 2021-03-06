(ns publicator.persistence.storage.post-mapper-test
  (:require
   [clojure.test :as t]
   [publicator.utils.test.instrument :as instrument]
   [publicator.use-cases.test.factories :as factories]
   [publicator.domain.test.fakes.password-hasher :as fakes.password-hasher]
   [publicator.domain.test.fakes.id-generator :as fakes.id-generator]
   [publicator.persistence.storage :as persistence.storage]
   [publicator.persistence.test.db :as db]
   [publicator.use-cases.abstractions.storage :as storage]
   [publicator.persistence.storage.post-mapper :as sut]))

(defn- setup [t]
  (with-bindings (merge
                  (fakes.password-hasher/binding-map)
                  (fakes.id-generator/binding-map)
                  (persistence.storage/binding-map db/*data-source* (sut/mapper)))
    (t)))

(t/use-fixtures :once
  instrument/fixture
  db/once-fixture)

(t/use-fixtures :each
  db/each-fixture
  setup)

(t/deftest create
  (let [entity (factories/create-post)]
    (t/is (some? entity))
    (t/is (= entity
             (storage/tx-get-one (:id entity))))))

(t/deftest change
  (let [entity (factories/create-post)
        title  "new title"
        _      (storage/tx-alter entity assoc :title title)
        entity (storage/tx-get-one (:id entity))]
    (t/is (= title (:title entity)))))
