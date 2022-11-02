(ns advent.molecules.day-cell
  (:require [shadow.css :refer [css]]
            [re-frame.core :refer [dispatch subscribe]]
            ["@tabler/icons" :refer [IconPencil IconPlus]]
            [advent.events :as events]
            [advent.subs :as subs]))

(def $day
  (css {:height "130px"
        :width "180px"
        :min-width "180px"
        :max-width "180px"
        :vertical-align "top"
        :box-sizing "border-box"
        :border "1px solid rgba(140, 130, 115, 0.12)"}))

(def $date
  (css {:padding "0.5em 0 0 0.5em"
        :color "rgba(156, 156, 156, 0.8)"}))

(def $other-day
  (css {:background "#2a2d2f"}))

(def $advent-day
  (css {}
       [:hover
        {:background "#1d2021"}]
       ["&:focus-within"
        {:background "#1d2021"}]))

(def $day-detail
  (css {:display "flex"
        :flex-flow "row wrap"
        :height "100%"}))

(def $day-line
  (css {:margin "0.5em"
        :height "3em"
        :word-wrap "break-word"
        :overflow "hidden"
        :text-overflow "ellipsis"}))

(def $edit-button
  (css {:margin "auto 0.5em 0.5em auto"
        :align-self "flex-end"
        :width "2em"
        :height "2em"}))

(def $plus-button
  (css {:width "100%"
        :height "calc(100% - 1em)"
        :display "flex"
        :flex-flow "row no-wrap"
        :padding-bottom "0.75em"}
       [:focus
        {:outline "none"
         :border "none"}]))

(def $plus-icon
  (css {:margin "auto"}))

(defn day-cell
  [advent? n]
  [:td
   {:key (gensym)
    :class [$day (if advent?
                   $advent-day
                   $other-day)]}
   [:header
    {:class [$date]}
    (str n)]
   (when advent?
     (if-let [{:keys [title calendar-url :post-url]} @(subscribe [::subs/day n])]
       [:div
        {:class [$day-detail]}
        [:p
         {:class [$day-line]}
         (if post-url
           [:a
            {:href post-url}
            title]
           title)]
        (when calendar-url
          [:p
           {:class [$day-line]}
           [:a
            {:href calendar-url}
            "カレンダー"]])
        [:button
         {:class [$edit-button]
          :title "投稿予定を編集"
          :on-click #(dispatch [::events/dialog-show n])}
         [:> IconPencil
          {:size 32
           :stroke 2}]]]
       [:button
        {:class [$plus-button]
         :title "投稿予定を追加"
         :on-click #(dispatch [::events/dialog-show n])}
        [:> IconPlus
         {:class [$plus-icon]
          :size 32
          :stroke 3}]]))])
