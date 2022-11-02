(ns advent.effects
  (:require [re-frame.core :as rf]
            [cognitect.transit :as t]))

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

(def local-storage-key
  "personal-advent-2022")

(def persist
  (rf/after
   (fn [{data :days}]
     (let [encoder (t/writer :json)]
       (->> data
            (t/write encoder)
            (js/localStorage.setItem local-storage-key))))))

(rf/reg-cofx
 ::persisted
 (fn [state _]
   (let [decoder (t/reader :json)
         data (some->> local-storage-key
                       (js/localStorage.getItem)
                       (t/read decoder))]
     (assoc state :persisted data))))
