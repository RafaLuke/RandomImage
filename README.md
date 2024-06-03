# RandomImage

RandomImage es una aplicación simple para ilustrar la aplicación **Version Catalog** sobre un proyecto android.

La aplicación muestra imágenes de [Lorem Picsum](https://picsum.photos/), renovándola cada vez que pasa a primer plano o se toca la pantalla.

Con esta mínima funcionalidad, se hace uso de dependencias de **androidx** y de la librería [Glide](https://github.com/bumptech/glide).

## Ramas

* master - Contiene el código de la aplicación con los ficheros gradle en formato Groovy DSL
* feature/kotlinDSL - Rama con los ficheros de gradle transcritos en Kotlin DSL
* feature/kotlinDSLBuildSrc - Rama con los ficheros de gradle en Kotlin DSL haciendo uso del módulo buildSrc
* feature/kotlinDSLBuildSrcVersionCatalog - Rama con los ficheros de gradle en Kotlin DSL, con un módulo buildSrc pero con las dependencias migradas a un catálogo de versiones.

## Requerimientos

* [Android Studio Giraffe](https://developer.android.com/studio/releases/past-releases/as-giraffe-release-notes?hl=es-419) o posterior
* [Java 17](https://jdk.java.net/17/) o posterior