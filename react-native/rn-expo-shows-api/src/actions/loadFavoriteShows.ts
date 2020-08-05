import ShowListDto from "../entities/list-show.dto";
import { AsyncStorage } from "react-native";
import { STORAGE_KEY } from "../shared/storage-key";
import loadShowById from "./loadShowById";

export default async function loadFavoriteShows(): Promise<Array<ShowListDto>> {
  return AsyncStorage
    .getItem(STORAGE_KEY)
      .then(jsonStr => JSON.parse(jsonStr || '[]'))
      .then((ids: Array<number>) => ids.map(id => loadShowById(id)))
      // Converte todas as promessas em uma única promessa de uma coleção dos resultados individuais.
      .then(promises => Promise.all(promises));
}