export interface IShowListJsonDto {
  id: number;
  name: string;
  permalink: string;
  start_date: string;
  end_date?: string;
  country: string;
  network: string;
  status: string;
  image_thumbnail_path: string;
}

export default class ShowListDto {
  constructor(
    public id: number,
    public name: string,
    public permalink: string,
    public startDate: Date,
    public endDate: Date | null,
    public country: string,
    public network: string,
    public status: string,
    public imageThumbnailPath: string
  ) {}

  static from(data: IShowListJsonDto) {
    return new ShowListDto(
      data.id,
      data.name,
      data.permalink,
      new Date(data.start_date),
      (data.end_date) ? new Date(data.end_date) : null,
      data.country,
      data.network,
      data.status,
      data.image_thumbnail_path
    );
  }
}