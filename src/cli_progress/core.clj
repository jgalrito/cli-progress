(ns cli-progress.core
  (:require
    [clojure.string :refer :all]
    [clojure.core :as core]))

(def ^:private bar-length 50)

(defn- move-up
  ([] (move-up 1))
  ([n] (core/print (str (char 27) "[" n "A"))))

(defn- move-down
  ([] (move-down 1))
  ([n] (core/print (str (char 27) "[" n "B"))))

(defn- move-start []
  (core/print "\r"))

(defn- clear []
  (core/print (str (char 27) "[2K")))

(defn- render-bar [{:keys [current max name] :or {name "progress"}}]
  (let [progress (float (/ current max))
        filled (Math/round (* progress bar-length))
        empty (- bar-length filled)]
    (str
      name
      " [" (join (take filled (repeat "="))) (join (take empty (repeat " "))) "] "
      (Math/round (* 100 progress)) "% (" current "/" max ")")))

(defn render [& bars]
  (join \newline (map render-bar bars)))

(defn print [& bars]
  (move-start)
  (core/print (apply render bars))
  (flush)
  (move-up (- (count bars) 1)))

(defn stop [& bars]
  (move-down (count bars))
  (core/print \newline))

(defn inc
  ([bar] (inc bar 1))
  ([bar n] (assoc bar :current (+ n (:current bar)))))

(defn bar
  ([max] {:max max :current 0})
  ([max name] (assoc (bar max) :name name)))