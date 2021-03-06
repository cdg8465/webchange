(ns webchange.editor-v2.graph-builder.graph.data.home.source)

(def data {:assets        [{:url "/raw/img/casa/background.jpg", :size 10 :type "image"}
                           {:url "/raw/img/casa/door.png", :size 1, :type "image"}
                           {:url "/raw/audio/english/l1/a1/vaca.m4a", :size 2, :type "audio" :alias "vaca voice" :target "senora-vaca"}
                           {:url "/raw/audio/english/l1/a1/vera.mp3", :size 2, :type "audio" :alias "vera voice" :target "vera"}
                           {:url "/raw/audio/english/l1/a1/mari_ending.m4a", :size 2, :type "audio" :alias "mari ending" :target "mari"}
                           {:url "/raw/audio/ferris-wheel/fw-try-again.mp3", :size 2, :type "audio" :alias "try again" :target "senora-vaca"}],
           :objects       {:background   {:type "background", :src "/raw/img/casa/background.jpg"},
                           :vera         {:type  "animation" :x 1128 :y 960 :name "vera" :anim "idle" :speed 0.3
                                          :width 1800 :height 2558 :scale {:x 0.2 :y 0.2} :start true}
                           :senora-vaca  {:type    "animation" :x 655 :y 960 :name "senoravaca" :anim "idle" :speed 0.3 :skin "vaca"
                                          :width   351 :height 717 :scale {:x 1 :y 1} :start true
                                          :actions {:click {:type "action" :id "restart" :on "click"}}}

                           :mari         {:type    "animation" :scene-name "mari" :name "mari" :anim "idle"
                                          :start   true :speed 0.35 :transition "mari"
                                          :x       2200 :y 311 :width 473 :height 511 :anim-offset {:x 0 :y -150}
                                          :scale-y 0.5 :scale-x 0.5}

                           :door         {:type   "image" :x 1146 :y 42 :width 732 :height 810 :src "/raw/img/casa/door.png"
                                          :filter "brighten" :transition "door"}

                           :door-trigger {:type    "transparent" :x 1146 :y 42 :width 732 :height 810
                                          :actions {:click {:type "action", :id "exit", :on "click"}}}

                           :box1         {:type       "transparent"
                                          :x          505 :y 375
                                          :width      772 :height 1032
                                          :scale      {:x 0.3 :y 0.3}
                                          :origin     {:type "center-center"}
                                          :scene-name "box1"
                                          :transition "box1"
                                          :states     {:default {:type "transparent"}
                                                       :visible {:type  "animation" :name "boxes" :anim "come" :skin "qwestion"
                                                                 :speed 0.3 :loop false :start true}}
                                          :actions    {:click {:type "action" :id "click-on-box1" :on "click"}}}

                           :box2         {:type       "transparent"
                                          :x          955 :y 375
                                          :width      772 :height 1032
                                          :scale      {:x 0.3 :y 0.3}
                                          :origin     {:type "center-center"}
                                          :scene-name "box2" :transition "box2"
                                          :states     {:default {:type "transparent"}
                                                       :visible {:type  "animation" :name "boxes" :anim "come" :skin "qwestion"
                                                                 :speed 0.3 :loop false :start true}}
                                          :actions    {:click {:type "action" :id "click-on-box2" :on "click"}}}

                           :box3         {:type       "transparent"
                                          :x          1405 :y 375
                                          :width      772 :height 1032
                                          :scale      {:x 0.3 :y 0.3}
                                          :origin     {:type "center-center"}
                                          :scene-name "box3" :transition "box3"
                                          :states     {:default {:type "transparent"}
                                                       :visible {:type  "animation" :name "boxes" :anim "come" :skin "qwestion"
                                                                 :speed 0.3 :loop false :start true}}
                                          :actions    {:click {:type "action" :id "click-on-box3" :on "click"}}}},
           :templates     ["click-pointer"],
           :scene-objects [["background" "door"] ["vera" "senora-vaca" "mari"] ["door-trigger"] ["box1" "box2" "box3"]],
           :actions       {:senora-vaca-audio-1                {:type                          "animation-sequence",
                                                                :target                        "senoravaca",
                                                                :track                         1,
                                                                :offset                        3.347,
                                                                :audio                         "/raw/audio/english/l1/a1/vaca.m4a",
                                                                :data                          [{:start 3.436, :end 6.436, :duration 3, :anim "talk"}],
                                                                :start                         3.347,
                                                                :duration                      3.24
                                                                :phrase                        :intro
                                                                :phrase-description            "Introducir actividad"
                                                                :phrase-description-translated "Introduce activity"
                                                                :phrase-text                   "Vamos a aprender nuevas palabras."
                                                                :phrase-text-translated        "We are going to learn some new words."}

                           :senora-vaca-audio-2                {:type                          "animation-sequence",
                                                                :target                        "senoravaca",
                                                                :track                         1,
                                                                :offset                        7.027,
                                                                :audio                         "/raw/audio/english/l1/a1/vaca.m4a",
                                                                :data                          [{:start 7.183, :end 8.198, :duration 1.015, :anim "talk"}
                                                                                                {:start 8.754, :end 10.715, :duration 1.961, :anim "talk"}
                                                                                                {:start 11.519, :end 12.489, :duration 0.97, :anim "talk"}
                                                                                                {:start 13.68, :end 16.107, :duration 2.427, :anim "talk"}],
                                                                :start                         7.027,
                                                                :duration                      9.373
                                                                :phrase                        :touch-first-box
                                                                :phrase-description            "Toca el primer cuadro"
                                                                :phrase-description-translated "Touch the first box"
                                                                :phrase-text                   "Mira esto! Que podria estar dentro de las cajas? Vamos a ver adentro! Toca la primera caja par ver que hay adentro."
                                                                :phrase-text-translated        "Look at this! What could be inside the boxes? Let’s look inside them! Touch the first box to see what’s inside."}

                           :senora-vaca-audio-touch-second-box {:type                          "animation-sequence",
                                                                :target                        "senoravaca",
                                                                :track                         1,
                                                                :offset                        52.453,
                                                                :audio                         "/raw/audio/english/l1/a1/vaca.m4a",
                                                                :data                          [{:start 52.6, :end 53.467, :duration 0.867, :anim "talk"}
                                                                                                {:start 54.36, :end 56.307, :duration 1.947, :anim "talk"}
                                                                                                {:start 56.987, :end 59.173, :duration 2.186, :anim "talk"}],
                                                                :start                         52.453,
                                                                :duration                      6.987
                                                                :phrase                        :touch-second-box
                                                                :phrase-description            "Toca el segundo cuadro"
                                                                :phrase-description-translated "Touch the second box"
                                                                :phrase-text                   "Muy bien! Vamos a ver que hay dentro de la segunda caja. Toco la siguiente caja para ver que hay adentro."
                                                                :phrase-text-translated        "Very good! Let’s look inside the second box. Touch the next box to see what’s inside."}


                           :senora-vaca-audio-touch-third-box  {:type                          "animation-sequence",
                                                                :target                        "senoravaca",
                                                                :track                         1,
                                                                :offset                        94.107,
                                                                :audio                         "/raw/audio/english/l1/a1/vaca.m4a",
                                                                :data                          [{:start 94.227, :end 94.814, :duration 0.587, :anim "talk"}
                                                                                                {:start 95.68, :end 97.587, :duration 1.907, :anim "talk"}
                                                                                                {:start 98.64, :end 100.96, :duration 2.32, :anim "talk"}],
                                                                :start                         94.107,
                                                                :duration                      7.053
                                                                :phrase                        :touch-third-box
                                                                :phrase-description            "Toca el tercer cuadro"
                                                                :phrase-description-translated "Touch the third box"
                                                                :phrase-text                   "Muy bien! Ahora hay que ver dentro de la tercera caja. Toca la ultima caja para ver que hay adentro."
                                                                :phrase-text-translated        "Good job! Now we will look inside the third box. Touch the last box to see what’s inside."}

                           :show-boxes                         {:type "parallel"
                                                                :data [{:type "state" :target "box1" :id "visible"}
                                                                       {:type "state" :target "box2" :id "visible"}
                                                                       {:type "state" :target "box3" :id "visible"}]}

                           :switch-box-animations-idle         {:type "parallel"
                                                                :data [{:type "add-animation" :target "box1" :id "idle_fly1" :loop true}
                                                                       {:type "add-animation" :target "box2" :id "idle_fly2" :loop true}
                                                                       {:type "add-animation" :target "box3" :id "idle_fly3" :loop true}]}

                           :wait-for-box-animations            {:type "empty" :duration 500}

                           :intro                              {:type "sequence",
                                                                :data ["start-activity"
                                                                       "clear-instruction"
                                                                       "renew-words"
                                                                       "senora-vaca-audio-1"
                                                                       "show-boxes"
                                                                       "wait-for-box-animations"
                                                                       "switch-box-animations-idle"
                                                                       "senora-vaca-audio-2"
                                                                       "set-current-box1"
                                                                       "set-reminder-position-1"
                                                                       "set-reminder-on"]},

                           :set-current-box1                   {:type "parallel"
                                                                :data [{:type "set-variable" :var-name "current-box" :var-value "box1"}
                                                                       {:type "set-variable" :var-name "current-position-x" :var-value 400}]}
                           :set-current-box2                   {:type "parallel"
                                                                :data [{:type "set-variable" :var-name "current-box" :var-value "box2"}
                                                                       {:type "set-variable" :var-name "current-position-x" :var-value 850}]}
                           :set-current-box3                   {:type "parallel"
                                                                :data [{:type "set-variable" :var-name "current-box" :var-value "box3"}
                                                                       {:type "set-variable" :var-name "current-position-x" :var-value 1300}]}

                           :click-on-box1                      {:type     "test-var-scalar"
                                                                :var-name "current-box"
                                                                :value    "box1"
                                                                :success  "first-word"
                                                                :fail     "pick-wrong"}

                           :click-on-box2                      {:type     "test-var-scalar"
                                                                :var-name "current-box"
                                                                :value    "box2"
                                                                :success  "second-word"
                                                                :fail     "pick-wrong"}

                           :click-on-box3                      {:type     "test-var-scalar"
                                                                :var-name "current-box"
                                                                :value    "box3"
                                                                :success  "third-word"
                                                                :fail     "pick-wrong"}

                           :first-word                         {:type       "sequence"
                                                                :data       ["show-first-box-word"
                                                                             "set-reminder-off"
                                                                             "introduce-word"
                                                                             "bye-current-box"
                                                                             "set-current-box2"
                                                                             "senora-vaca-audio-touch-second-box"
                                                                             "set-reminder-position-2"
                                                                             "set-reminder-on"]
                                                                :unique-tag "box"}

                           :second-word                        {:type       "sequence"
                                                                :data       ["set-reminder-off"
                                                                             "show-second-box-word"
                                                                             "introduce-word"
                                                                             "bye-current-box"
                                                                             "set-current-box3"
                                                                             "senora-vaca-audio-touch-third-box"
                                                                             "set-reminder-position-3"
                                                                             "set-reminder-on"]
                                                                :unique-tag "box"}

                           :third-word                         {:type       "sequence"
                                                                :data       ["set-reminder-off"
                                                                             "show-third-box-word"
                                                                             "introduce-word"
                                                                             "bye-current-box"
                                                                             "finish-activity"
                                                                             "mari-finish"]
                                                                :unique-tag "box"}

                           :set-reminder-position-1            {:type "sequence-data"
                                                                :data [{:type "set-variable" :var-name "reminder-position-x" :var-value 400}
                                                                       {:type "set-variable" :var-name "reminder-position-y" :var-value 190}]}

                           :set-reminder-position-2            {:type "sequence-data"
                                                                :data [{:type "set-variable" :var-name "reminder-position-x" :var-value 850}
                                                                       {:type "set-variable" :var-name "reminder-position-y" :var-value 190}]}

                           :set-reminder-position-3            {:type "sequence-data"
                                                                :data [{:type "set-variable" :var-name "reminder-position-x" :var-value 1300}
                                                                       {:type "set-variable" :var-name "reminder-position-y" :var-value 190}]}

                           :show-first-box-word                {:type "parallel"
                                                                :data [{:type "animation" :target "box1" :id "wood" :loop false}
                                                                       {:type     "set-skin" :target "box1"
                                                                        :from-var [{:var-name "item-1" :action-property "skin" :var-property "skin"}]}
                                                                       {:type "copy-variable" :var-name "current-word" :from "item-1"}
                                                                       {:type "add-animation" :target "box1" :id "idle_fly1" :loop true}]}

                           :show-second-box-word               {:type "parallel"
                                                                :data [{:type "animation" :target "box2" :id "wood" :loop false}
                                                                       {:type     "set-skin" :target "box2"
                                                                        :from-var [{:var-name "item-2" :action-property "skin" :var-property "skin"}]}
                                                                       {:type "copy-variable" :var-name "current-word" :from "item-2"}
                                                                       {:type "add-animation" :target "box2" :id "idle_fly2" :loop true}]}

                           :show-third-box-word                {:type "parallel"
                                                                :data [{:type "animation" :target "box3" :id "wood" :loop false}
                                                                       {:type     "set-skin" :target "box3"
                                                                        :from-var [{:var-name "item-3" :action-property "skin" :var-property "skin"}]}
                                                                       {:type "copy-variable" :var-name "current-word" :from "item-3"}
                                                                       {:type "add-animation" :target "box3" :id "idle_fly3" :loop true}]}

                           :bye-current-box                    {:type "sequence"
                                                                :data ["bye-current-box-pt1"
                                                                       "bye-current-box-pt2"
                                                                       "bye-current-box-pt3"]}
                           :bye-current-box-pt1                {:type     "animation" :id "jump"
                                                                :from-var [{:var-name "current-box" :action-property "target"}]}
                           :bye-current-box-pt2                {:type     "transition" :to {:y -100 :duration 2}
                                                                :from-var [{:var-name "current-box" :action-property "transition-id"}
                                                                           {:var-name "current-position-x" :action-property "to.x"}]}
                           :bye-current-box-pt3                {:type     "state" :id "default"
                                                                :from-var [{:var-name "current-box" :action-property "target"}]}

                           :vaca-this-is-var                   {:type "action" :from-var [{:var-name "current-word" :var-property "home-vaca-this-is-action"}]}

                           :vaca-can-you-say                   {:type                   "animation-sequence",
                                                                :target                 "senoravaca",
                                                                :track                  1,
                                                                :offset                 20.28,
                                                                :audio                  "/raw/audio/english/l1/a1/vaca.m4a",
                                                                :data                   [{:start 20.363, :end 20.98, :duration 0.617, :anim "talk"}],
                                                                :start                  20.28,
                                                                :duration               0.813
                                                                :phrase-text            "Puedes deciry"
                                                                :phrase-text-translated "Can you say"}


                           :vaca-question-var                  {:type "action" :from-var [{:var-name "current-word" :var-property "home-vaca-question-action"}]}

                           :vaca-word-var                      {:type "action" :from-var [{:var-name "current-word" :var-property "home-vaca-word-action"}]}

                           :group-word-var                     {:type "action" :from-var [{:var-name "current-word" :var-property "home-group-word-action"}]}

                           :vaca-say-3-times                   {:type                   "animation-sequence",
                                                                :target                 "senoravaca",
                                                                :track                  1,
                                                                :offset                 27.493,
                                                                :audio                  "/raw/audio/english/l1/a1/vaca.m4a",
                                                                :data
                                                                                        [{:start 27.605, :end 27.966, :duration 0.361, :anim "talk"}
                                                                                         {:start 28.24, :end 30.507, :duration 2.267, :anim "talk"}],
                                                                :start                  27.493,
                                                                :duration               3.24
                                                                :phrase-text            "Bueno. Digalo tres veces"
                                                                :phrase-text-translated "Good! Let’s say it 3 times, like this:"}

                           :vaca-3-times-var                   {:type "action" :from-var [{:var-name "current-word" :var-property "home-vaca-3-times-action"}]}

                           :group-3-times-var                  {:type "action" :from-var [{:var-name "current-word" :var-property "home-group-3-times-action"}]}

                           :vaca-once-more                     {:type                   "animation-sequence",
                                                                :target                 "senoravaca",
                                                                :track                  1,
                                                                :offset                 41.747,
                                                                :audio                  "/raw/audio/english/l1/a1/vaca.m4a",
                                                                :data                   [{:start 41.893, :end 42.573, :duration 0.68, :anim "talk"}],
                                                                :start                  41.747,
                                                                :duration               0.973
                                                                :phrase-text            "Una vez mas!"
                                                                :phrase-text-translated "Once more!"}

                           :vaca-goodbye-var                   {:type                          "action"
                                                                :from-var                      [{:var-name "current-word" :var-property "home-vaca-goodbye-action"}]
                                                                :phrase                        :concept-goodbye
                                                                :phrase-description            "Adios concepto"
                                                                :phrase-description-translated "Goodbye concept"}

                           :introduce-word                     {:type "sequence"
                                                                :data ["empty-big"
                                                                       "concept-intro"
                                                                       "empty-big"
                                                                       "concept-chant"
                                                                       "empty-small"
                                                                       "vaca-goodbye-var"
                                                                       "empty-big"]}

                           :concept-intro                      {:type                          "sequence"
                                                                :data                          ["vaca-this-is-var"
                                                                                                "empty-small"
                                                                                                "vaca-can-you-say"
                                                                                                "vaca-question-var"
                                                                                                "empty-small"
                                                                                                "vaca-word-var"
                                                                                                "empty-small-1"
                                                                                                "group-word-var"]
                                                                :phrase                        :this-is-concept
                                                                :phrase-description            "Introducir concepto"
                                                                :phrase-description-translated "Introduce concept"}

                           :concept-chant                      {:type                          "sequence"
                                                                :data                          ["empty-small"
                                                                                                "vaca-say-3-times"
                                                                                                "vaca-3-times-var"
                                                                                                "empty-big"
                                                                                                "group-3-times-var"
                                                                                                "empty-small-2"
                                                                                                "vaca-once-more"
                                                                                                "empty-small"
                                                                                                "group-3-times-var"]
                                                                :phrase                        :concept-chant
                                                                :phrase-description            "Concepto de canto"
                                                                :phrase-description-translated "Chant concept"}

                           :senora-vaca-anim-idle              {:type "animation" :target "senoravaca" :id "idle"}
                           :senora-vaca-anim-clapping-start    {:type "animation" :target "senoravaca" :id "clapping_start" :loop false}
                           :senora-vaca-anim-clapping-finish   {:type "animation" :target "senoravaca" :id "clapping_finish" :loop false}
                           :vera-anim-idle                     {:type "animation" :target "vera" :id "idle"}
                           :vera-anim-clapping-start           {:type "animation" :target "vera" :id "clapping_start" :loop false}
                           :vera-anim-clapping-finish          {:type "animation" :target "vera" :id "clapping_finish" :loop false}


                           :pick-wrong                         {:type                          "sequence"
                                                                :data                          ["audio-wrong"]
                                                                :phrase                        :wrong-click
                                                                :phrase-description            "Respuesta incorrecta"
                                                                :phrase-description-translated "Wrong answer"}

                           :audio-wrong                        {:type                   "audio"
                                                                :id                     "fw-try-again"
                                                                :start                  0.892
                                                                :duration               1.869
                                                                :offset                 0.2
                                                                :target                 "mari"
                                                                :phrase-text            "Intenta de nuevo!"
                                                                :phrase-text-translated "Try again"}

                           :renew-words                        {:type        "lesson-var-provider"
                                                                :provider-id "words-set"
                                                                :variables   ["item-1" "item-2" "item-3"]
                                                                :from        "concepts"}

                           :mari-finish                        {:type                          "sequence-data",
                                                                :data                          [{:type          "transition",
                                                                                                 :transition-id "mari",
                                                                                                 :to            {:x 1403, :y 657, :duration 1.3}}
                                                                                                {:type                   "animation-sequence",
                                                                                                 :target                 "mari",
                                                                                                 :track                  1,
                                                                                                 :offset                 0.825,
                                                                                                 :audio                  "/raw/audio/english/l1/a1/mari_ending.m4a",
                                                                                                 :data
                                                                                                                         [{:start 0.986, :end 2.586, :duration 1.6, :anim "talk"}
                                                                                                                          {:start 3.226, :end 6.039, :duration 2.813, :anim "talk"}
                                                                                                                          {:start 6.825, :end 9.412, :duration 2.587, :anim "talk"}
                                                                                                                          {:start 9.985, :end 15.117, :duration 5.132, :anim "talk"}
                                                                                                                          {:start 15.877, :end 16.77, :duration 0.893, :anim "talk"}
                                                                                                                          {:start 17.117, :end 20.356, :duration 3.239, :anim "talk"}],
                                                                                                 :start                  0.825,
                                                                                                 :duration               19.811
                                                                                                 :phrase-text            "Tremendo trabajo pequeno genio! Quieres ver que hay dentro de la cajas otra vez? Toca a la Senora Vaca para poder ver adentro. Si no, toca a la puerta para ir al parque a tu proxima actividad."
                                                                                                 :phrase-text-translated "Great job little genius! Do you want to see what’s inside the boxes again? Touch Senora Vaca to look inside again. Otherwise, touch the door to go to the park for your next activity"}
                                                                                                {:type "set-variable", :var-name "restart", :var-value true}]
                                                                :phrase                        :finish-activity
                                                                :phrase-description            "Repite o pasa a la siguiente actividad"
                                                                :phrase-description-translated "Repeat or go to the next activity"}

                           :restart                            {:type     "test-value"
                                                                :value1   true
                                                                :from-var [{:var-name "restart" :action-property "value2"}]
                                                                :success  {:type "sequence-data"
                                                                           :data [{:type "set-variable" :var-name "restart" :var-value false}
                                                                                  {:type          "transition",
                                                                                   :transition-id "mari",
                                                                                   :to            {:x 2200 :y 311, :duration 1.3}}
                                                                                  {:type "clear-vars"}
                                                                                  {:type "parallel"
                                                                                   :data [{:type "state" :target "box1" :id "default"}
                                                                                          {:type "state" :target "box2" :id "default"}
                                                                                          {:type "state" :target "box3" :id "default"}]}
                                                                                  {:type "action" :id "intro"}]}}

                           :empty-small                        {:type "empty" :duration 500}
                           ;; ToDo: eliminate when graph normalizer is fixed
                           :empty-small-1                      {:type "empty" :duration 500}
                           :empty-small-2                      {:type "empty" :duration 500}

                           :empty-big                          {:type "empty" :duration 1000}
                           :clear-instruction                  {:type "remove-flows" :flow-tag "instruction"}
                           :start-background-music             {:type "audio" :id "background" :loop true :unique-tag "music"}
                           :start-activity                     {:type "start-activity" :id "home"}
                           :finish-activity                    {:type "finish-activity" :id "home"}
                           :stop-activity                      {:type "stop-activity" :id "home"}
                           :exit                               {:type "sequence-data"
                                                                :data [{:type "action" :id "stop-activity"}
                                                                       {:type "scene" :scene-id "map"}]}
                           }
           :audio         {:background   "/raw/audio/background/POL-daily-special-short.mp3"
                           :fw-try-again "/raw/audio/ferris-wheel/fw-try-again.mp3"},
           :triggers      {:music {:on "start" :action "start-background-music"}
                           :start {:on "start" :action "intro"}
                           :back  {:on "back" :action "stop-activity"}}
           :metadata      {:autostart true
                           :prev      "map"}}
  )
