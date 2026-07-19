(ns aburi.host.kotoba-bridge
  "Babashka host adapter for the aburi → Kotoba HTTP boundary."
  (:require [aburi.methods.kotoba-bridge :as bridge]
            [babashka.http-client :as http]
            [cheshire.core :as json]))

(defn http-post
  "Encode, POST and decode one allowlisted Kotoba transaction request."
  [url body-map headers timeout-s]
  (let [response (http/post (str url) {:headers headers
                                       :body (json/generate-string body-map)
                                       :timeout (long (* 1000 (double timeout-s)))
                                       :throw false})
        status (:status response)]
    (if (<= 200 status 299)
      (json/parse-string (:body response) true)
      (throw (ex-info (str "kotoba transact HTTP " status ": "
                           (let [body (str (:body response))]
                             (subs body 0 (min 200 (count body)))))
                      {:aburi/kotoba-transact-http-error true :status status})))))

(defn push
  "Run bridge/push with this host's explicit HTTP capability."
  ([log-path] (push log-path {}))
  ([log-path options]
   (bridge/push log-path (assoc options :http-post http-post))))
