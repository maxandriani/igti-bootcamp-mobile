import React from 'react';
import { StyleSheet } from 'react-native';
import colors from '../shared/colors';
import { BottomTabScreenProps } from '@react-navigation/bottom-tabs';
import { createStackNavigator } from '@react-navigation/stack';
import IShowParam from '../interfaces/i-show-params';
import homeTabs from '../shared/home-tabs';
import FeaturedShowsScreen from './FeaturedShows';
import ShowDetailScreen from './ShowDetail';

interface IShowsScreenProps 
  extends BottomTabScreenProps<any> {

}

const Stack = createStackNavigator<IShowParam>();

const styles = StyleSheet.create({
  viewStyle: {
    flex: 1
  }
});

export default function ShowsScreen({ navigation }: IShowsScreenProps) {
  return (
    <Stack.Navigator>
      <Stack.Screen
        name={homeTabs.Featured}
        component={FeaturedShowsScreen}
        options={{ headerShown: false }} />
      <Stack.Screen 
        name={homeTabs.ShowDetailes}
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