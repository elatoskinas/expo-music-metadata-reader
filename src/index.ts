// import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to ExpoMusicMetadataReader.web.ts
// and on native platforms to ExpoMusicMetadataReader.ts
import ExpoMusicMetadataReaderModule from './ExpoMusicMetadataReaderModule';
import { SongData } from './ExpoMusicMetadataReader.types';

// TODO: implement functions / events

export function readSongMetadata(songUri: string): SongData {
  return ExpoMusicMetadataReaderModule.readSongMetadata(songUri);
}

// export async function setValueAsync(value: string) {
//   return await ExpoMusicMetadataReaderModule.setValueAsync(value);
// }

// const emitter = new EventEmitter(ExpoMusicMetadataReaderModule ?? NativeModulesProxy.ExpoMusicMetadataReader);

// export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
//   return emitter.addListener<ChangeEventPayload>('onChange', listener);
// }

// export { ExpoMusicMetadataReaderViewProps, ChangeEventPayload };