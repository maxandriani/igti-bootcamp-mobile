import ShowListDto, { IShowListJsonDto } from "../entities/list-show.dto";
import episodateApi from "../services/episodate-api";

export default async function loadShowsByQuery(query: string, page: number): Promise<Array<ShowListDto>> {
  return episodateApi
    .get(`/search?q=${query}&page=${page}`)
      .then(response => response.data.tv_shows)
      .then((shows: Array<IShowListJsonDto>) => shows.map(show => ShowListDto.from(show)));
}