import ExpoModulesCore

struct SongData {
  var album: String
}

public class ExpoMusicMetadataReaderModule: Module {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  public func definition() -> ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('ExpoMusicMetadataReader')` in JavaScript.
    Name("ExpoMusicMetadataReader")

    // TODO: add functions / events

    // // Defines event names that the module can send to JavaScript.
    // Events("onChange")

    Function("readSongMetadata") { (songUri: String) in
      // TODO: implement Swift logic
      return SongData(album: "TODO")
    }

    // // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
    // Function("hello") {
    //   return "Hello world! 👋"
    // }

    // // Defines a JavaScript function that always returns a Promise and whose native code
    // // is by default dispatched on the different thread than the JavaScript runtime runs on.
    // AsyncFunction("setValueAsync") { (value: String) in
    //   // Send an event to JavaScript.
    //   self.sendEvent("onChange", [
    //     "value": value
    //   ])
    // }

    // // Enables the module to be used as a native view. Definition components that are accepted as part of the
    // // view definition: Prop, Events.
    // View(ExpoMusicMetadataReaderView.self) {
    //   // Defines a setter for the `name` prop.
    //   Prop("name") { (view: ExpoMusicMetadataReaderView, prop: String) in
    //     print(prop)
    //   }
    // }
  }
}
