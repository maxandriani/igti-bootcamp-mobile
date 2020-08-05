import episodateApi from "../services/episodate-api";
import DetailShowDto from "../entities/details-show.dto";

export default async function loadShowById(id: number) {
  return episodateApi
    .get(`/show-details?q=${id}`)
    .then(res => DetailShowDto.from(res.data.tvShow));
}
