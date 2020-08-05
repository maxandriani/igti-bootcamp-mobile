import React, { useState } from 'react';
import { StyleSheet } from 'react-native';
import colors from '../shared/colors';
import IShowParam from '../interfaces/i-show-params';
import { BottomTabScreenProps } from '@react-navigation/bottom-tabs';
import { createStackNavigator } from '@react-navigation/stack';
import FavoriteShowsListScreen from './FavoriteShowsList';
import ShowDetailScreen from './ShowDetail';
import favoriteTabs from '../shared/favorite-tabs';

interface IFavoriteShowsScreenProps 
  extends BottomTabScreenProps<any> {

}

const Stack = createStackNavigator<IShowParam>();

const styles = StyleSheet.create({
  viewStyle: {
    flex: 1
  }
});

export default function ShowsScreen({ navigation }: IFavoriteShowsScreenProps) {
  return (
    <Stack.Navigator>
      <Stack.Screen
        name={favoriteTabs.ShowList}
        component={FavoriteShowsListScreen}
        options={{ headerShown: false }} />
      <Stack.Screen 
        name={favoriteTabs.ShowDetailes}
        component={ShowDetailScreen}
        options={{
          headerStyle: {
            backgroundColor: colors.header.background,
          },
          headerTintColor: colors.header.text
        }} />
    </Stack.Navigator>
  );
}