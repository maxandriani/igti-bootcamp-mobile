import React from 'react';
import { StyleSheet } from 'react-native';
import { BottomTabScreenProps } from '@react-navigation/bottom-tabs';
import { createStackNavigator } from '@react-navigation/stack';
import showTabs from '../shared/show-tabs';
import ShowsListScreen from './ShowsList';
import ShowDetailScreen from './ShowDetail';
import colors from '../shared/colors';
import IShowParam from '../interfaces/i-show-params';

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
        name={showTabs.ShowList}
        component={ShowsListScreen}
        options={{ headerShown: false }} />
      <Stack.Screen 
        name={showTabs.ShowDetailes}
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