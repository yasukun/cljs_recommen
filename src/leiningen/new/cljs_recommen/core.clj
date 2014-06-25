(ns {{name}}.core
  (use [clojure.tools.cli :only [cli]]
       [org.httpkit.server :only [run-server]]
       [{{name}}.routes]
       [{{name}}.config :only [app-configs cfg]])
  (:require [compojure.route :refer (resources)]
            [compojure.core :refer (GET defroutes)]
            [ring.util.response :as response])
  (:gen-class))

(defonce server (atom nil))

(defn- to-int [s] (Integer/parseInt s))

(defn stop-server []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))

(defn run
  ([] (run 3000))
  ([port]
     (reset! server (run-server (app) {:port port}))
     (println (str "sever running@localhost:" port))))

(defn -main [& args]
  (let [[options _ banner]
        (cli args
             ["-p" "--port" "Port to listen" :default 3000 :parse-fn to-int]
             ["--[no-]help" "Print this help"])]
    (when (:help options) (println banner) (System/exit 0))
    (swap! app-configs merge options)
    (reset! server (run-server (app) {:port (cfg :port)}))
    (println (str "sever running@localhost:" (cfg :port)))))
