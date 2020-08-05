import React, { useState, useEffect } from 'react';
import DetailShowDto from '../entities/details-show.dto';
import episodateApi from '../services/episodate-api';
import loadShowById from '../actions/loadShowById';

export default function useShowDetail(showId: number): DetailShowDto | undefined {
  
  const [showState, setShowState] = useState<DetailShowDto>();

  useEffect(() => {
    if (showId) {
      loadShowById(showId)
        .then(show => setShowState(show))
        .catch(err => console.error(err));
    }
  }, [ showId ])

  return showState;
}