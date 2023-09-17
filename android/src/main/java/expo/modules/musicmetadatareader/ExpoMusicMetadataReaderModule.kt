package expo.modules.musicmetadatareader
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record

import android.media.MediaMetadataRetriever

data class SongData (
  @Field
  val title: String?,
  @Field
  val artist: String?,
  @Field
  val album: String?,
  @Field
  val albumArtist: String?,
  @Field
  val trackNumber: String?,
  @Field
  val totalTracks: String?,
  @Field
  val duration: String?,
  @Field
  val year: String?
) : Record

class ExpoMusicMetadataReaderModule : Module() {
  private fun readSongMetadata(songUri: String): SongData {
    val metadataRetriever = MediaMetadataRetriever()
    metadataRetriever.setDataSource(songUri)

    val title = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE)
    val artist = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST)
    val album = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM)
    val albumArtist = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST)
    // TODO: track number / total tracks inaccurate?
    val trackNumber = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER)
    val totalTracks = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_NUM_TRACKS)
    val duration = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
    // TODO: add date?
    val year = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR)

    return SongData(title, artist, album, albumArtist, trackNumber, totalTracks, duration, year)
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
  }
}
