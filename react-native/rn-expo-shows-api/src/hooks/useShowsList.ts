import React, { useState, useEffect } from 'react';
import ShowListDto from '../entities/list-show.dto';
import loadMostPopularShows from '../actions/loadMostPopularShows';
import loadShowsByQuery from '../actions/loadShowsByQuery';

export default function useShowsList(query?: string, page: number = 1): Array<ShowListDto> {
  
  const [showList, setShowList] = useState<Array<ShowListDto>>([]);

  useEffect(() => {
    ((query)
      ? loadShowsByQuery(query, page)
      : loadMostPopularShows(page))
        .then(shows => setShowList(shows))
        .catch(err => console.error(err));
  }, [ query, page ]);

  return showList;

}