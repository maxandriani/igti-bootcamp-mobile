import EpisodeDto, { IEpisodeJsonDto } from "./episode.dto";

export interface IDetailShowJsonDto {
  id: number;
  name: string;
  permalink: string;
  url: string;
  description: string;
  description_source: string;
  start_date: string;
  end_date: string | null;
  country: string;
  status: string;
  runtime: number;
  network: string;
  youtube_link: string;
  image_path: string;
  image_thumbnail_path: string;
  rating: number;
  rating_count: number;
  countdown: number,
  genres: Array<string>;
  pictures: Array<string>;
  episodes: Array<IEpisodeJsonDto>;
}

export default class DetailShowDto {
  constructor(
    public id: number,
    public name: string,
    public permalink: string,
    public url: string,
    public description: string,
    public descriptionSource: string,
    public startDate: Date,
    public endDate: Date | null,
    public country: string,
    public status: string,
    public runtime: number,
    public network: string,
    public youtubeLink: string,
    public imagePath: string,
    public imageThumbnailPath: string,
    public rating: number,
    public ratingCount: number,
    public countdown: number,
    public genres: Array<string>,
    public pictures: Array<string>,
    public episodes: Array<EpisodeDto>
  ) {}

  static from(data: IDetailShowJsonDto): DetailShowDto {
    return new DetailShowDto(
      data.id,
      data.name,
      data.permalink,
      data.url,
      data.description,
      data.description_source,
      new Date(data.start_date),
      (data.end_date) ? new Date(data.end_date) : null,
      data.country,
      data.status,
      data.runtime,
      data.network,
      data.youtube_link,
      data.image_path,
      data.image_thumbnail_path,
      data.rating,
      data.rating_count,
      data.countdown,
      data.genres,
      data.pictures,
      data.episodes.map(episode => EpisodeDto.from(episode))
    );
  }
}