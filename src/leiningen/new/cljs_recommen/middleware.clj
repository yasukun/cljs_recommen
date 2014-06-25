(ns {{name}}.middleware
  (:use [compojure.core :only [GET POST DELETE PUT]]
        [clojure.tools.logging :only [debug error info]]
        [clojure.data.json :only [write-str]]))

(defn json-response [resp]
  (let [json-resp (if (and (map? resp) (contains? resp :body))
                    (update-in resp [:body] write-str)
                    {:body (write-str resp)})]
    (update-in (merge {:status 200} json-resp)
               [:headers] merge {"Content-Type"
                                 "application/json; charset=utf-8"})))

(defn wrap-json [handler] (fn [req] (json-response (handler req))))

(defmacro JGET [path args handler]
  `(GET ~path ~args (wrap-json ~handler)))
