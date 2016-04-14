(ns test-render.core
  (:require [clojure.java.io :as io])
  (:import [org.openqa.selenium WebDriver OutputType]
           [com.machinepublishers.jbrowserdriver Timezone JBrowserDriver Settings]))

(defn foo
  "I don't do a whole lot."
  [x]
  (let [settings (-> (Settings/builder)
                     (.timezone Timezone/AMERICA_NEWYORK)
                     (.build))

        driver   (JBrowserDriver. settings)

        dest-file "screenshot.png"]
    (.get driver "http://blog.shriphani.com")
    (let [f (.getScreenshotAs driver OutputType/FILE)]
      (io/copy f
               (io/file dest-file)))))
