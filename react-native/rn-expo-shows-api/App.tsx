import React from 'react';
import { StyleSheet } from 'react-native';
import { NavigationContainer, RouteProp } from '@react-navigation/native';
import { createBottomTabNavigator, BottomTabNavigationOptions } from '@react-navigation/bottom-tabs';
import HomeScreen from './src/screens/Home';
import colors from './src/shared/colors';
import tabs from './src/shared/tabs';
import ShowsScreen from './src/screens/Shows';
import FavoriteShowsScreen from './src/screens/FavoriteShows';
import SaTabBar from './src/components/ui/SaTabBar';

export default function App() {

  const BottomTab = createBottomTabNavigator();

  function tabOptions(props: {
    route: RouteProp<Record<string, object | undefined>, string>;
    navigation: any;
  }): BottomTabNavigationOptions {
    return {
      
    }
  }

  return (
    <NavigationContainer>
      <BottomTab.Navigator tabBar={props => <SaTabBar {...props} />}>
        <BottomTab.Screen
          name={tabs.Home}
          component={HomeScreen}
          options={tabOptions} />
        <BottomTab.Screen
          name={tabs.Shows}
          component={ShowsScreen}
          options={tabOptions}/>
        <BottomTab.Screen
          name={tabs.FavoriteShows}
          component={FavoriteShowsScreen}
          options={tabOptions} />
      </BottomTab.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: colors.background,
    alignItems: 'center',
    justifyContent: 'center',
    padding: 10
  },
});
