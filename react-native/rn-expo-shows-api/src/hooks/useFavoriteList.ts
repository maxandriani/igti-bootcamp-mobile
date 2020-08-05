import React, { useState, useEffect } from 'react';
import loadFavoriteShows from '../actions/loadFavoriteShows';
import ShowListDto from '../entities/list-show.dto';
import saveFavoriteShows from '../actions/saveFavoriteShows';

export default function useFavoriteList(): [Array<ShowListDto>, (add: ShowListDto) => void, (remove: ShowListDto) => void] {
  
  const [favoriteShows, setFavoriteShows] = useState<Array<ShowListDto>>([]);

  async function addFavorite(show: ShowListDto) {
    if (!favoriteShows.find(item => item.id === show.id)) {
      const list = [...favoriteShows, show];
      await saveFavoriteShows(list);
      setFavoriteShows(list);
    }
  }

  async function removeFavorite(show: ShowListDto) {
    const list = favoriteShows.filter(item => item.id !== show.id);
    await saveFavoriteShows(list);
    setFavoriteShows(list);
  }

  useEffect(() => {
    loadFavoriteShows()
      .then(shows => setFavoriteShows(shows))
      .catch(err => console.error(err));
  }, [])

  return [favoriteShows, addFavorite, removeFavorite];
}