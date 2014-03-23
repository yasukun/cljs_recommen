(ns leiningen.new.cljs-recommen
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "cljs-recommen"))

(defn cljs-recommen
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             [".gitignore" (render "gitignore")]
             ["project.clj" (render "project.clj" data)]
             ["src/clj/{{sanitized}}/handlers/app.clj" (render "handlers/app.clj" data)]
             ["src/clj/{{sanitized}}/handlers/api.clj" (render "handlers/api.clj" data)]
             ["src/clj/{{sanitized}}/routes.clj" (render "routes.clj" data)]             
             ["src/clj/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)]             
             ["public/css/page.css" (render "public/css/page.css")]
             "public/js/"
             "public/imgs/"
             )))
