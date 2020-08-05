import episodateApi from "../services/episodate-api";
import ShowListDto, { IShowListJsonDto } from "../entities/list-show.dto";

export default async function loadMostPopularShows(page: number): Promise<Array<ShowListDto>> {
  return episodateApi
    .get(`/most-popular?page=${page}`)
      .then(response => response.data.tv_shows)
      .then((shows: Array<IShowListJsonDto>) => shows.map(show => ShowListDto.from(show)));
}