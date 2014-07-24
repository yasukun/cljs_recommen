(ns {{name}}.routes
    (:use [compojure.core :only [defroutes
                                 GET POST DELETE ANY context]]
          (ring.middleware [keyword-params :only
                            [wrap-keyword-params]]
                           [params :only [wrap-params]]
                           [session :only [wrap-session]]
                           [jsonp :only [wrap-json-with-padding]])
          [{{name}} .middleware :only [JGET]])
    (:require
     [cemerick.austin.repls :refer (browser-connected-repl-js)]
     [net.cgrand.enlive-html :as enlive]
     [{{name}}.handlers.api :as api]
     [{{name}}.handlers.app :as app]
     [compojure.route :as route]))

(enlive/deftemplate show-landing
  (java.io.StringReader. (str (app/base-page)))
  []
  [:body] (enlive/append
            (enlive/html [:script (browser-connected-repl-js)])))

;; define mapping here
(defroutes server-routes*
  (GET "/" [] (show-landing))
  (context "/api" []
           ;; JGET returns json encoding of the response
           (GET "/time" [] api/get-time))
  ;; static files under ./public folder, prefix /static
  ;; like /static/css/style.css
  (route/resources "/static")
  ;; 404, modify for a better 404 page
  (route/not-found "<p>Page not found.</p>" ))

(defn app [] (-> #'server-routes*
                 wrap-session
                 wrap-keyword-params
                 wrap-params))
