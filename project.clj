(defproject re-frame "0.7.0-alpha-2"
  :description  "A Clojurescript MVC-like Framework For Writing SPAs Using Reagent."
  :url          "https://github.com/Day8/re-frame.git"
  :license      {:name "MIT"}
  :dependencies [[org.clojure/clojure        "1.7.0"]
                 [org.clojure/clojurescript  "1.7.170"]
                 [reagent "0.6.0-alpha"]]

  :profiles {:debug {:debug true}
             :dev   {:dependencies [[karma-reporter "0.3.0"]]
                     :plugins      [[lein-cljsbuild "1.1.1"]
                                    [lein-npm "0.6.1"]
                                    [lein-figwheel "0.3.8"]]}}

  :clean-targets [:target-path
                  "run/compiled/demo"]

  :resource-paths ["run/resources"]
  :jvm-opts       ["-Xmx1g" "-XX:+UseConcMarkSweepGC"]
  :source-paths ["src"]
  :test-paths   ["test"]
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]

  :npm {:dependencies [[karma "https://github.com/danielcompton/karma/archive/v0.13.19.tar.gz"]
                       [karma-cljs-test "0.1.0"]
                       [karma-chrome-launcher "0.2.0"]
                       [karma-junit-reporter "0.3.8"]]}

  :cljsbuild {:builds [{:id           "test"
                        :source-paths ["test"]
                        :compiler     {:output-to     "run/compiled/test.js"
                                       :source-map    "run/compiled/test.js.map"
                                       :output-dir    "run/compiled/test"
                                       :optimizations :simple
                                       :pretty-print  true}}]}

  :aliases {"auto"        ["do" "clean," "cljsbuild" "auto" "test,"]
            "once"        ["do" "clean," "cljsbuild" "once" "test,"] })
