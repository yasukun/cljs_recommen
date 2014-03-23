(ns {{name}}.core
  (:require [clojure.browser.repl]))

(defn foo []
  (js/alert "foo"))

(defn ^:export init []
  (foo))