# PhotoAlbumManager API

Framework: Play 2.3

Build Tool: Gradle 3.4

JDK: 1.7


Gradle Tasks:

    Build
        -build or
        -playBinary

    Run
        -run or
        -runPlayBinary


Runs at **localhost:9000**

Routes can be found at **`conf/routes`**


Assumptions:

    1. I had confusion with Photo CRUD and adding/removing a photo to album. So currently, when delete is directly called
    on Photo, it doesn't update Albums' photo collection.
    2. There is no database. Used HashMap and initiated it on application start in `Global.java`
    3. Used default logger and it logs to `logs/applicaitons.log`
    4. Play currently doesn't ignore the ending '/' in request uri. There are workarounds but I hadn't implemented here.



Code Structure:

    app
        Controllers
        Global.java
    src
        dataMappers
        models
        services
    build.gradle


