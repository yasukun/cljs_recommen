(defproject {{sanitized}} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :uberjar-name "{{sanitized}}-standalone.jar"
  :main {{sanitized}}.core
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/core.async "0.1.303.0-886421-alpha"]
                 [ring "1.3.0"]
                 [ring/ring-core "1.3.0"]
                 [ring.middleware.jsonp "0.1.4"]
                 [org.clojure/clojurescript "0.0-2268"]
                 [org.clojure/tools.cli "0.3.1"]
                 [compojure "1.1.8"]
                 [enlive "1.1.5"]
                 [org.clojure/data.json "0.2.4"]
                 [http-kit "2.1.16"]
                 [hiccup "1.0.5"]
                 [domina "1.0.2"]
                 [jayq "2.5.0"]]
  :plugins [[lein-cljsbuild "1.0.3"]
            [com.cemerick/austin "0.1.4"]
            [lein-ring "0.8.11"]]
  :source-paths ["src/clj"]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {:builds
              {:main {:source-paths ["src/cljs"]
                      :compiler {:output-to "resources/public/js/app.js"
                                 :optimizations :simple
                                 :pretty-print true}
                      :jar true}}})
