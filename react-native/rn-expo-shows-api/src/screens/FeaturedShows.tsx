import React, { useState } from 'react';
import { StyleSheet, View, Text, ScrollView, TouchableOpacity, Image } from 'react-native';
import { BottomTabNavigationProp } from "@react-navigation/bottom-tabs";
import colors from '../shared/colors';
import useShowsList from '../hooks/useShowsList';
import ShowListDto from '../entities/list-show.dto';
import homeTabs from '../shared/home-tabs';

interface IFeaturedShowsScreenProps {
  navigation: BottomTabNavigationProp<any, 'Profile'>
}

const styles = StyleSheet.create({
  scrollView: {
    flex: 1
  },
  viewStyle: {
    flex: 1,
    alignItems: 'stretch',
    justifyContent: 'flex-start',
    backgroundColor: colors.background,
    paddingHorizontal: 16,
    paddingVertical: 32
  },
  headerStyle: {
    paddingVertical: 40
  },
  headerTitleStyle: {
    fontSize: 48,
    fontWeight: '900',
    color: colors.accent,
    textAlign: 'center'
  },
  icon: {
    fontSize: 96,
    textAlign: 'center'
  },
  headline: {
    fontSize: 21,
    lineHeight: 28,
    textAlign: 'center',
    marginBottom: 10,
    backgroundColor: colors.accent,
    borderRadius: 20,
    padding: 5,
    color: 'white'
  },
  imageGrid: {
    flex: 1,
    flexDirection: 'row',
    flexWrap: 'wrap',
    alignContent: 'center'
  },
  imageGridItem: {
    flex: 1,
    flexBasis: '30%',
    height: 200,
    backgroundColor: 'black',
    flexShrink: 0,
    margin: 5,
    borderTopLeftRadius: 20,
    borderBottomRightRadius: 20,
    overflow: 'hidden'
  },
  imageGridItemThumb: {
    flex: 1
  }
});

export default function FeaturedShowsScreen({ navigation }: IFeaturedShowsScreenProps) {
  const shows = useShowsList();

  function goToShow(show: ShowListDto) {
    navigation.navigate(homeTabs.ShowDetailes, { showId: show.id, showName: show.name })
  }

  return (
    <View style={styles.viewStyle}>
      <ScrollView style={styles.scrollView}>
        <View style={styles.headerStyle}>
          <Text style={styles.headerTitleStyle}>My Shows</Text>
        </View>

        <Text style={styles.headline}>TOP Shows do momento!</Text>

        <View style={styles.imageGrid}>
        {shows
          .filter((show, idx) => idx < 9)
          .map(show => (
            <TouchableOpacity
              key={show.id}
              style={styles.imageGridItem}
              onPress={() => goToShow(show)}>
              <Image
                style={styles.imageGridItemThumb}
                source={{ uri: show.imageThumbnailPath }}></Image>
            </TouchableOpacity>
          ))}
        </View>
      </ScrollView>
    </View>
  );
}