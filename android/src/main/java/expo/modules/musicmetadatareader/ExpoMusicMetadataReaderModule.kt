package expo.modules.musicmetadatareader
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record

import android.media.MediaMetadataRetriever

data class SongData (
  @Field
  val album: String?
) : Record

class ExpoMusicMetadataReaderModule : Module() {
  // val context: Context
  //   get() = appContext.reactContext ?: throw Error("App Context could not be resolved")

  private fun readSongMetadata(songUri: String): SongData {
    val metadataRetriever = MediaMetadataRetriever()
    metadataRetriever.setDataSource(songUri)
    val album = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM)
    return SongData(album)
  }

  // private fun readSongCoverData(songUri: String) {
  //     // Read & set cover image
  //     val retriever: MediaMetadataRetriever = MediaMetadataRetriever()
  //     retriever.setDataSource(applicationContext, songUri)
  //     val coverBytes = retriever.embeddedPicture

  //     if (coverBytes != null) {
  //         val coverBitmap = BitmapFactory.decodeByteArray(coverBytes, 0, coverBytes.size)
  //     }
  // }

  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  override fun definition() = ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('ExpoMusicMetadataReader')` in JavaScript.
    Name("ExpoMusicMetadataReader")

    // TODO: should this be converted to async?
    Function("readSongMetadata") { songUri: String ->
      readSongMetadata(songUri)
    }

    // // Defines event names that the module can send to JavaScript.
    // Events("onChange")

    // // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
    // Function("hello") {
    //   "Hello world! 👋"
    // }

    // // Defines a JavaScript function that always returns a Promise and whose native code
    // // is by default dispatched on the different thread than the JavaScript runtime runs on.
    // AsyncFunction("setValueAsync") { value: String ->
    //   // Send an event to JavaScript.
    //   sendEvent("onChange", mapOf(
    //     "value" to value
    //   ))
    // }

    // // Enables the module to be used as a native view. Definition components that are accepted as part of
    // // the view definition: Prop, Events.
    // View(ExpoMusicMetadataReaderView::class) {
    //   // Defines a setter for the `name` prop.
    //   Prop("name") { view: ExpoMusicMetadataReaderView, prop: String ->
    //     println(prop)
    //   }
    // }
  }
}
