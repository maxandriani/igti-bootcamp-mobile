import ShowListDto from "../entities/list-show.dto";
import { AsyncStorage } from "react-native";
import { STORAGE_KEY } from "../shared/storage-key";

export default async function saveFavoriteShows(shows: Array<ShowListDto> = []) {
  return AsyncStorage.setItem(STORAGE_KEY,  JSON.stringify(shows.map(fav => fav.id)));
}