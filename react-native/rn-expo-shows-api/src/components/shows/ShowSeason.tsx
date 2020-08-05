import React from 'react';
import { StyleSheet, StyleProp, ViewStyle, View, FlatList, Text } from 'react-native';
import EpisodeDto from '../../entities/episode.dto';
import colors from '../../shared/colors';

export interface IShowSeasonProps {
  title: string;
  episodes: Array<EpisodeDto>;
  style?: StyleProp<ViewStyle>;
}

export interface IShowSeasonItemProps {
  episode: EpisodeDto,
  style?: StyleProp<ViewStyle>
}

const styles = StyleSheet.create({
  listContainer: {},
  container: {
    backgroundColor: 'white',
    padding: 10,
    borderRadius: 10,
    shadowColor: 'black',
    shadowOpacity: 0.4,
    shadowRadius: 5
  },
  itemContainer: {
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'flex-start',
    alignItems: 'flex-start',
    borderTopWidth: 1,
    borderTopColor: colors.background,
    padding: 5
  },
  itemContainerNumber: {
    fontSize: 21,
    lineHeight: 28,
    minWidth: 60
  },
  text: {
    fontSize: 16,
    lineHeight: 21,
    margin: 5,
  },
  title: {
    fontSize: 14,
    lineHeight: 21,
    marginBottom: 12,
    textAlign: 'center'
  }
});

export function ShowSeasonItem({ episode }: IShowSeasonItemProps) {

  return (
    <View style={styles.itemContainer}>
      <Text style={styles.itemContainerNumber}>{episode.episode}</Text>
      <Text style={styles.text}>{episode.name}</Text>
    </View>
  );
}

export default function ShowSeason({ title, episodes, style }: IShowSeasonProps) {

  return (
    <View style={styles.container}>
      <Text style={styles.title}>{title}</Text>
      
      {episodes
        .sort((a, b) => a.episode - b.episode)
        .map(episode => <ShowSeasonItem key={`${episode.season}-${episode.episode}`} episode={episode} />)}
    </View>
  )
}