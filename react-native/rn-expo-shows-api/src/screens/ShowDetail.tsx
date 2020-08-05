import React, { useContext } from 'react';
import { StyleSheet, View, Text, Image, Button, ScrollView, Linking } from 'react-native';
import colors from '../shared/colors';
import { StackScreenProps } from '@react-navigation/stack';
import IShowParam from '../interfaces/i-show-params';
import useShowDetail from '../hooks/useShowDetail';
import ShowDetail from '../components/shows/ShowDetail';
import EpisodeDto from '../entities/episode.dto';
import ShowSeason from '../components/shows/ShowSeason';
import * as Sharing from 'expo-sharing';
import useFavoriteList from '../hooks/useFavoriteList';

interface IDetailScreenProps extends StackScreenProps<IShowParam> {}

const styles = StyleSheet.create({
  scrollView: {
  },
  container: {
    flex: 1,
    flexWrap: 'nowrap',
    justifyContent: 'flex-start'
  },
  viewStyle: {
    flex: 1,
    backgroundColor: colors.background,
    padding: 10
  },
  showHeader: {
    alignItems: 'center'
  },
  showHeaderTitle: {
    color: colors.header.active,
    fontSize: 32,
    lineHeight: 42
  },
  showThumb: {
    marginVertical: 20,
    padding: 0,
    flex: 1,
    shadowColor: 'black',
    shadowOpacity: 0.4,
    shadowRadius: 20,
    borderRadius: 20,
    overflow: 'hidden',
    justifyContent: 'space-between',
    alignContent: 'stretch'
  },
  showImage: {
    flex: 1,
    aspectRatio: 1,
    left: 0,
    right: 0,
  },
  showInfo: {
  },
  showSeasons: {
    marginTop: 20
  },
  showActions: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center'
  },
  showActionButton: {
    margin: 10
  }
});

function getSeasons(episodes: Array<EpisodeDto>): Array<{ title: string, episodes: Array<EpisodeDto> }> {
  const collection = episodes
    .sort((a, b) => a.season - b.season)
    .reduce((acc, item) => {
      const collection = (acc.get(item.season) || []);
      collection.push(item);
      acc.set(item.season, collection);
      return acc;
    }, new Map<number, EpisodeDto[]>());

  return Array
    .from(collection.entries())
    .map(([season, episodes]) => ({ title: `${season}ª Temporada`, episodes }));
}

export default function ShowDetailScreen({ navigation, route }: IDetailScreenProps) {
  
  const showId = route.params?.showId;
  const show = useShowDetail(showId);
  const [favorites, addFavorite, removeFavorite] = useFavoriteList();
  const hasFavorite = !!favorites.find(fav => fav.id === show?.id);

  return (
    <View style={styles.viewStyle}>
      {show != null && <ScrollView style={styles.scrollView}>
        <View style={styles.container}>
          <View style={styles.showHeader}>
            <Text style={styles.showHeaderTitle}>🎞 {show.name} 🎞</Text>
          </View>

          { (show?.imagePath) && 
          <View style={styles.showThumb}>
            <Image
              style={styles.showImage}
              source={{ cache: 'reload', uri: show.imagePath }}
              resizeMode="contain"></Image>
          </View>
          }

          <View style={styles.showInfo}>
            {(show != null) && <ShowDetail show={show} />}
          </View>

          {show != null && getSeasons(show.episodes || [])
            .map(({ title, episodes }, idx) => (
            <View key={idx} style={styles.showSeasons}>
              <ShowSeason title={title} episodes={episodes} />
            </View>))}

          <View style={styles.showActions}>
            
            {Sharing.isAvailableAsync() &&
            <View style={styles.showActionButton}>
              <Button
                color={colors.header.active}
                title="Share"
                onPress={() => Sharing.shareAsync(show.url)} />
            </View>}
            <View style={styles.showActionButton}>
              <Button
                color={colors.header.active}
                title={(hasFavorite)
                  ? 'Dislike'
                  : 'Like'}
                onPress={() => {
                  if (hasFavorite) {
                    removeFavorite(show)
                  } else {
                    addFavorite(show);
                  }
                }} />
            </View>
            <View style={styles.showActionButton}>
              <Button
                color={colors.header.active}
                title="Episodate"
                onPress={() => Linking.openURL(show.url)} />
            </View>
          </View>
        </View>
      </ScrollView>}
    </View>
  );
}