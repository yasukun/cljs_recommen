(ns {{name}}.handlers.app
  (:use [hiccup core page]))

(defn base-page []
  (html
   (html5
    [:head
     [:meta {:charset "utf-8"}]
     (include-css "static/css/page.css")
     (include-js "static/js/app.js")]
    [:body
     [:div {:id "spa"}
      [:div {:class "spa-shell-head"}
       [:div {:class "spa-shell-head-logo"}]
       [:div {:class "spa-shell-head-acct"}]
       [:div {:class "spa-shell-head-search"}]]
      [:div {:class "spa-shell-main"}
       [:div {:class "spa-shell-main-nav"}]
       [:div {:class "spa-shell-main-content" :id "control"}]]
      [:div {:class "spa-shell-foot"}
       [:div {:class "spa-shell-chat"}]
       [:div {:class "spa-shell-modal"}]]]
     [:script "{{name}}.core.init();"]])))

