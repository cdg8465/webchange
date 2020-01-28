(ns webchange.resources.core
  (:require
    [clojure.string :refer [starts-with? index-of]]
    [clojure.tools.logging :as log]
    [webchange.course.core :as course]
    [webchange.dataset.core :as dataset]
    [webchange.interpreter.defaults :as defaults]
    [clojure.java.io :as io]))

(def prefix "resources/")
(def public-fold "public/")
(def js-fold (str public-fold "js/compiled/"))
(def css-fold (str public-fold "css/"))
(def img-fold (str public-fold "images/"))

(defn- remove-prefix
  [s]
  (let [value (str prefix public-fold)
        pos (index-of s value)
        len (count value)]
    (str "./" (subs s (+ pos len)))))

(defn get-files-list
  [dir]
  (if-let [url (io/resource dir)]
    (->> url
         (.getPath)
         (clojure.java.io/file)
         (file-seq)
         (filter #(.isFile %))
         (mapv str)
         (map remove-prefix))))

(defn generate-app-resources []
  (->> ["./manifest.json"
        "./page-skeleton"
        (get-files-list (str js-fold "app.js"))
        (get-files-list (str js-fold "out/"))
        (get-files-list css-fold)
        (get-files-list img-fold)
        (->> defaults/default-assets (map #(str "." (:url %))))
        "https://fonts.googleapis.com/css?family=Luckiest+Guy"
        "https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic&subset=latin"
        "https://fonts.gstatic.com/s/lato/v15/S6u9w4BMUTPHh6UVSwiPGQ.woff2"
        "//cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css"
        ]
       flatten
       (remove nil?)))

(def resources
  ["./manifest.json"
   "./page-skeleton"
   "./js/compiled/app.js"
   "./css/styles.css"
   "./css/dashboard/classes.css.map"
   "./css/dashboard/classes.css"
   "./css/dashboard/students.css.map"
   "./css/dashboard/students.css"
   "./css/dashboard/index.css"
   "./css/dashboard/index.css.map"
   "./images/auth/animal-c.png"
   "./images/auth/animal-b.png"
   "./images/auth/animal-w.png"
   "./images/auth/animal-v.png"
   "./images/auth/animal-s.png"
   "./images/auth/animal-d.png"
   "./images/auth/animal-f.png"
   "./images/auth/asset-11.png"
   "./images/auth/asset-13.png"
   "./images/auth/asset-12.png"
   "./images/auth/animal-k.png"
   "./images/auth/form.png"
   "./images/auth/animal-l.png"
   "./images/student_dashboard/tmp/book3.jpg"
   "./images/student_dashboard/tmp/game2.jpg"
   "./images/student_dashboard/tmp/game3.jpg"
   "./images/student_dashboard/tmp/book2.jpg"
   "./images/student_dashboard/tmp/game1.jpg"
   "./images/student_dashboard/tmp/book1.png"
   "./images/student_dashboard/tmp/video3.jpg"
   "./images/student_dashboard/tmp/video2.jpg"
   "./images/student_dashboard/tmp/video1.jpg"
   "./images/student_dashboard/play.png"
   "./images/dashboard/scene-preview/Park_Swing.jpg"
   "./images/dashboard/scene-preview/Stadium_Running.jpg"
   "./images/dashboard/scene-preview/Cinema_Room.jpg"
   "./images/dashboard/scene-preview/Stadium_Cycling-Race.jpg"
   "./images/dashboard/scene-preview/Library_Magic-Hat.jpg"
   "./images/dashboard/scene-preview/Feria_Ferris-Wheel.jpg"
   "./images/dashboard/scene-preview/Park_See-Saw.jpg"
   "./images/dashboard/scene-preview/Library_Book.jpg"
   "./images/dashboard/scene-preview/Stadium_Volleyball.jpg"
   "./images/dashboard/scene-preview/Library_Drawing-Lesson.jpg"
   "./images/dashboard/scene-preview/Feria_Main.jpg"
   "./images/dashboard/scene-preview/Park_Sandbox.jpg"
   "./images/dashboard/scene-preview/Park_Hide-and-seek.jpg"
   "./images/dashboard/scene-preview/Park_Pinata.jpg"
   "./images/dashboard/scene-preview/Library_Room.jpg"
   "./images/dashboard/scene-preview/Casa_Room.jpg"
   "./images/dashboard/scene-preview/Park_Main.jpg"
   "./images/dashboard/scene-preview/Park_Slide.jpg"
   "./images/dashboard/bg_01.jpg"
   "./images/dashboard/bg_02.jpg"
   "./images/dashboard/bg_03.jpg"
   "./raw/audio/background/POL-daily-special-short.mp3"
   "./raw/audio/effects/NFF-fruit-collected.mp3"
   "./raw/audio/effects/NFF-glitter.mp3"
   "./raw/audio/effects/NFF-robo-elastic.mp3"
   "./raw/audio/effects/NFF-rusted-thing.mp3"
   "./raw/audio/effects/NFF-zing.mp3"
   "./raw/audio/effects/wrong.wav"
   "./raw/audio/effects/correct.mp3"
   "./raw/img/ui/back_button_01.png"
   "./raw/img/ui/back_button_02.png"
   "./raw/img/ui/close_button_01.png"
   "./raw/img/ui/close_button_02.png"
   "./raw/img/ui/play_button_01.png"
   "./raw/img/ui/play_button_02.png"
   "./raw/img/ui/reload_button_01.png"
   "./raw/img/ui/reload_button_02.png"
   "./raw/img/ui/settings_button_01.png"
   "./raw/img/ui/settings_button_02.png"
   "./raw/img/ui/settings/music.png"
   "./raw/img/ui/settings/music_icon.png"
   "./raw/img/ui/settings/sound_fx.png"
   "./raw/img/ui/settings/sound_fx_icon.png"
   "./raw/img/ui/settings/settings.png"
   "./raw/img/ui/hand.png"
   "./raw/img/bg.jpg"
   "./raw/img/ui/logo.png"
   "./raw/anim/senoravaca/skeleton.atlas"
   "./raw/anim/senoravaca/skeleton.json"
   "./raw/anim/senoravaca/skeleton.png"
   "./raw/anim/senoravaca/skeleton2.png"
   "./raw/anim/vera/skeleton.atlas"
   "./raw/anim/vera/skeleton.json"
   "./raw/anim/vera/skeleton.png"
   "./raw/anim/vera-45/skeleton.atlas"
   "./raw/anim/vera-45/skeleton.json"
   "./raw/anim/vera-45/skeleton.png"
   "./raw/anim/vera-45/skeleton2.png"
   "./raw/anim/vera-45/skeleton3.png"
   "./raw/anim/vera-45/skeleton4.png"
   "./raw/anim/vera-45/skeleton5.png"
   "./raw/anim/vera-45/skeleton6.png"
   "./raw/anim/vera-45/skeleton7.png"
   "./raw/anim/vera-45/skeleton8.png"
   "./raw/anim/vera-90/skeleton.atlas"
   "./raw/anim/vera-90/skeleton.json"
   "./raw/anim/vera-90/skeleton.png"
   "./raw/anim/vera-90/skeleton2.png"
   "./raw/anim/vera-90/skeleton3.png"
   "./raw/anim/vera-90/skeleton4.png"
   "./raw/anim/rock/skeleton.atlas"
   "./raw/anim/rock/skeleton.json"
   "./raw/anim/rock/skeleton.png"
   "./raw/anim/mari/skeleton.atlas"
   "./raw/anim/mari/skeleton.json"
   "./raw/anim/mari/skeleton.png"
   "./raw/anim/boxes/skeleton.atlas"
   "./raw/anim/boxes/skeleton.json"
   "./raw/anim/boxes/skeleton.png"
   "./raw/anim/boxes/skeleton2.png"
   "./raw/anim/boxes/skeleton3.png"
   "./raw/anim/book/skeleton.atlas"
   "./raw/anim/book/skeleton.json"
   "./raw/anim/book/skeleton.png"
   "./raw/anim/book/skeleton2.png"
   "./raw/anim/book/skeleton3.png"
   "./raw/anim/hat/skeleton.atlas"
   "./raw/anim/hat/skeleton.json"
   "./raw/anim/hat/skeleton.png"
   "./raw/anim/pinata/skeleton.atlas"
   "./raw/anim/pinata/skeleton.json"
   "./raw/anim/pinata/skeleton.png"
   "https://fonts.googleapis.com/css?family=Luckiest+Guy"
   "https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic&subset=latin"
   "https://fonts.gstatic.com/s/lato/v15/S6u9w4BMUTPHh6UVSwiPGQ.woff2"
   "//cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css"])

(defn get-app-resources
  []
  [true {:data resources}])

(defn get-values-list
  [data]
  (cond
    (sequential? data) (flatten (map get-values-list data))
    (map? data) (get-values-list (vals data))
    :else data))

(defn find-resources
  [data]
  (filter #(and (string? %)
                (starts-with? % "/raw/")
                (not (starts-with? % "/raw/video/"))) (get-values-list data)))

(defn get-level-resources
  []
  (let [course-name "test"
        scenes (->> course-name
                    course/get-course-data
                    :scenes)
        scenes-resources (->> scenes
                              (map #(->> %
                                         (course/get-scene-data course-name)
                                         (find-resources))))
        api-data (->> scenes
                      (map #(str "/api/courses/" course-name "/scenes/" %))
                      (into [(str "/api/courses/" course-name)
                             (str "/api/courses/" course-name "/lesson-sets")
                             "/api/schools/current"]))
        lessons-resources (->> course-name
                               dataset/get-course-lessons
                               find-resources)]
    [true {:resources   (->> [scenes-resources
                              lessons-resources]
                             flatten
                             distinct)
           :scenes-data api-data}]))
