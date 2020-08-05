import React from 'react';
import { StyleSheet, View, TouchableOpacity } from 'react-native';
import { MaterialIcons } from '@expo/vector-icons'; 
import colors from '../../shared/colors';
import { BottomTabNavigationProp, BottomTabBarProps, BottomTabBarOptions } from '@react-navigation/bottom-tabs';
import tabs from '../../shared/tabs';

interface ISaTabBarProps extends BottomTabBarProps<BottomTabBarOptions> {
  // navigation: BottomTabNavigationProp<any, ''>
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: colors.header.background,
    flexDirection: 'row',
    justifyContent: 'space-around'
  },
  button: {
    paddingVertical: 10,
    paddingHorizontal: 30
  }
});

const IconFontSize = 32;

export default function SaTabBar({ navigation, state }: ISaTabBarProps) {

  function getIconColor(idx: number): string {
    return (idx === state.index)
      ? colors.header.active
      : colors.header.text
  }

  return (
    <View style={styles.container}>
      <TouchableOpacity 
        style={styles.button}
        onPress={() => navigation.navigate(tabs.Home)}>
        <MaterialIcons
          name="home"
          size={IconFontSize}
          color={getIconColor(0)} />
      </TouchableOpacity>
      <TouchableOpacity 
        style={styles.button}
        onPress={() => navigation.navigate(tabs.Shows)}>
        <MaterialIcons
          name="list"
          size={IconFontSize}
          color={getIconColor(1)} />
      </TouchableOpacity>
      <TouchableOpacity 
        style={styles.button}
        onPress={() => navigation.navigate(tabs.FavoriteShows)}>
        <MaterialIcons
          name="favorite"
          size={IconFontSize}
          color={getIconColor(2)} />
      </TouchableOpacity>
    </View>
  );
}