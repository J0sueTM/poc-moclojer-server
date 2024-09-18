(ns core
  (:require
   [com.moclojer.adapters :as moclojer.adpt]
   [com.moclojer.io-utils :as moclojer.io]
   [com.moclojer.server :as moclojer.srv]))

(defn -main
  [& [config-path]]
  (let [router (moclojer.adpt/generate-routes
                (moclojer.io/open-file config-path))]
    (moclojer.srv/create-watcher router {:config-path config-path})
    (moclojer.srv/start-server! router {:join? true})))
