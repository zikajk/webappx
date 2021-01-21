(ns webappx.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [muuntaja.middleware :refer [wrap-format]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.util.response :refer [response]]))

(def request-atom (atom nil))

(defn handler [request]
  (let [body (:body-params request)]
    (reset! request-atom request)
    (response {:response body})))

(def app
  (-> #'handler
      wrap-format
      wrap-reload))

(defonce server
  (run-jetty app {:port 3000 :join? false}))


