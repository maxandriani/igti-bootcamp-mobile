import React, { useState } from 'react';
import { StyleSheet, View, Text } from 'react-native';
import { StackScreenProps } from '@react-navigation/stack';
import colors from '../shared/colors';
import ShowList from '../components/shows/ShowList';
import SaSearchInput from '../components/forms/SaSearchInput';
import showTabs from '../shared/show-tabs';
import IShowParam from '../interfaces/i-show-params';
import useShowsList from '../hooks/useShowsList';

interface IShowsScreenProps extends StackScreenProps<IShowParam> {}

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

export default function ShowsListScreen({ navigation }: IShowsScreenProps) {

  const [search, setSearch] = useState<string>('');
  const shows = useShowsList(search);

  return (
    <View style={styles.viewStyle}>
      <View style={styles.header}>
        <Text style={styles.headerTitle}>Shows 😎</Text>
      </View>

      <View style={styles.searchBar}>
        <SaSearchInput
          onChange={query => setSearch(query)}></SaSearchInput>
      </View>

      <View style={styles.showList}>
        <ShowList items={shows} onPress={show => navigation.navigate(showTabs.ShowDetailes, { showId: show.id, showName: show.name })}></ShowList>
      </View>
    </View>
  );
}