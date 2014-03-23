(ns {{name}}.core
  (use [clojure.tools.cli :only [cli]]
       [org.httpkit.server :only [run-server]]
       [{{name}}.routes])
  (:require [compojure.route :refer (resources)]
            [compojure.core :refer (GET defroutes)]
            [ring.util.response :as response])
  (:gen-class))

(defonce server (atom nil))

(defn stop-server []
  (when-not (nil? @server)
    ;; graceful shutdown: wait 100ms for existing requests to be finished
    ;; :timeout is optional, when no timeout, stop immediately
    (@server :timeout 100)
    (reset! server nil)))

(defn run
  ([] (run 3000))
  ([port]
     (reset! server (run-server (app) {:port port}))
     (println (str "sever running@localhos:" port))))

(defn -main [& args]
  ;; The #' is useful, when you want to hot-reload code
  ;; You may want to take a look: https://github.com/clojure/tools.namespace
  ;; and http://http-kit.org/migration.html#reload
  (reset! server (run-server (app) {:port 3000})))
