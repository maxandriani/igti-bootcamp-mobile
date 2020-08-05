import React, { useState } from 'react';
import { StyleSheet, View, Text } from 'react-native';
import colors from '../shared/colors';
import { StackScreenProps } from '@react-navigation/stack';
import IShowParam from '../interfaces/i-show-params';
import useFavoriteList from '../hooks/useFavoriteList';
import SaSearchInput from '../components/forms/SaSearchInput';
import ShowList from '../components/shows/ShowList';
import favoriteTabs from '../shared/favorite-tabs';

interface IFavoriteShowsListScreenProps extends StackScreenProps<IShowParam> {}

const styles = StyleSheet.create({
  viewStyle: {
    flex: 1,
    alignItems: 'stretch',
    justifyContent: 'flex-start',
    flexWrap: 'nowrap',
    backgroundColor: colors.background,
    paddingHorizontal: 16,
    paddingVertical: 32
  },
  header: {
    padding: 10,
    alignItems: 'center'
  },
  headerTitle: {
    fontSize: 24,
    color: colors.warning
  },
  showList: {
    flexShrink: 1
  },
  searchBar: {
    marginVertical: 18
  }
});

export default function FavoriteShowsListScreen({ navigation }: IFavoriteShowsListScreenProps) {

  const [search, setSearch] = useState<string>('');
  const [shows] = useFavoriteList();

  return (
    <View style={styles.viewStyle}>
      <View style={styles.header}>
        <Text style={styles.headerTitle}>🍕 Favorite Shows 🍿</Text>
      </View>

      <View style={styles.searchBar}>
        <SaSearchInput
          onChange={query => setSearch(query)}></SaSearchInput>
      </View>

      <View style={styles.showList}>
        <ShowList 
          items={shows.filter(item => !search || item.name.toLowerCase().match(search.toLowerCase()))}
          onPress={show => navigation.navigate(favoriteTabs.ShowDetailes, { showId: show.id, showName: show.name })}></ShowList>
      </View>
    </View>
  );
}