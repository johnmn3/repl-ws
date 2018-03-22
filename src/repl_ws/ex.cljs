(ns repl-ws.ex
  (:require [clojure.browser.ws :as ws]))

(when-not (ws/alive?)
  (ws/connect "ws://localhost:9001"))

(if (ws/alive?)
  (println "Loaded example"))

(ws/alive?)
