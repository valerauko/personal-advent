(ns advent.dev
  (:require [shadow.cljs.devtools.api :as shadow]
            [advent.css :as css]))

(defn watch
  {:shadow/requires-server true}
  [& _]
  (shadow/watch :app)
  (css/watch)
  (shadow/watch :karma-test)
  (shadow/watch :browser-test))
