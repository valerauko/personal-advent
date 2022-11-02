(ns advent.effects
  (:require [re-frame.core :as rf]))

(rf/reg-fx
 ::dialog
 (fn [[mode e]]
   (let [dialog (js/document.getElementById "dialog")]
     (case mode
       :show
       (.showModal dialog)

       :close
       (.close dialog)

       :reset
       (some-> e .-target .reset)

       ;; else
       (when-let [target (.-target e)]
         (if (= "DIALOG" (.-nodeName target))
           (.close dialog)
           (.stopPropagation e)))))))
