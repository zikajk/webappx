(ns webappx.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.util.response :refer [response]]))

(defn handler [request]
  (let [body (:body request)]  
    (response {:response body})))

(def app
  (-> #'handler
      wrap-json-response
      wrap-json-body
      wrap-reload))

(defonce server
  (run-jetty app {:port 3000 :join? false}))

