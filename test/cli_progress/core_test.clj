(ns cli-progress.core-test
  (:require [clojure.test :refer :all]
            [cli-progress.core :refer :all]))

(deftest render-test
  (testing "Correctly creates, renders and increments multiple progress bars"
    (is (=
      (render
        (inc (bar 30 "test") 15)
        (inc (bar 50) 10))
      (str
        "test [=========================                         ] 50% (15/30)"
        \newline
        "progress [==========                                        ] 20% (10/50)")))))
