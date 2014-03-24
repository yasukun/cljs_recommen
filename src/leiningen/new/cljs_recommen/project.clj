(defproject {{sanitized}} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :uberjar-name "{{sanitized}}-standalone.jar"
  :aot :all
  :main {{sanitized}}.core
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/core.async "0.1.278.0-76b25b-alpha"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [org.clojure/tools.cli "0.3.1"]
                 [compojure "1.1.6"]
                 [enlive "1.1.5"]
                 [ring/ring-core "1.2.2"]
                 [org.clojure/data.json "0.2.4"]
                 [http-kit "2.1.16"]
                 [hiccup "1.0.5"]
                 [jayq "2.5.0"]
                 [ring "1.2.1"]]
  :plugins [[lein-cljsbuild "1.0.2"]
            [com.cemerick/austin "0.1.3"]
            [lein-ring "0.8.10"]]
  :hooks [leiningen.cljsbuild]
  :source-paths ["src/clj"]
  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                        :compiler {:output-to "public/js/app.js"
                                   :optimizations :simple
                                   :pretty-print true}
                        :jar true}]})
