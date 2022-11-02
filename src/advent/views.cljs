(ns advent.views
  (:require [shadow.css :refer [css]]
            [advent.organisms.calendar :refer [calendar]]
            [advent.organisms.dialog :refer [dialog]]))

(def $main
  (css {:background "#181a1b"
        :color "#9c9c9c"
        :font "normal normal 16px/1.5em sans-serif"
        :height "100vh"
        :display "flex"
        :flex-flow "row no-wrap"
        :align-items "center"}))

(defn main
  []
  [:div
   {:class [$main]}
   [calendar]
   [dialog]])
