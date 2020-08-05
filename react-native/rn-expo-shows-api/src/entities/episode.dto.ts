export interface IEpisodeJsonDto {
  season: number;
  episode: number;
  name: string;
  air_date: string;
}

export default class EpisodeDto {
  constructor(
    public season: number,
    public episode: number,
    public name: string,
    public airDate: Date
  ) {}

  static from (data: IEpisodeJsonDto) {
    return new EpisodeDto(
      data.season,
      data.episode,
      data.name,
      new Date(data.air_date)
    );
  }
}
