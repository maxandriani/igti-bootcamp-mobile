import React from 'react';
import { StyleSheet, View, StyleProp, ViewStyle } from 'react-native';
import { MaterialIcons } from '@expo/vector-icons';
import colors from '../../shared/colors';

export interface ISaStarsProps {
  ratting: number,
  count: number,
  style?: StyleProp<ViewStyle>
}

enum StarTypeEnum {
  Empty = 'star-border',
  Half = 'star-half',
  Full = 'star'
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center'
  },
  star: {
    margin: 5
  }
});

export default function SaStars({ ratting, style, count = 5 }: ISaStarsProps) {

  function getStartType(idx: number, count: number, ratting: number): StarTypeEnum {
    if (ratting === 0) {
      return StarTypeEnum.Empty;
    } else {
      const score = count / ratting;
      if (score <= idx) {
        return StarTypeEnum.Full
      } else {
        return StarTypeEnum.Empty
      }
    }
  }

  function inflate(count: number, ratting: number) {
    const elements = [];

    for (let idx = 1; idx <= count; idx++) {
      elements.push(<MaterialIcons key={idx} style={styles.star} name={getStartType(idx, count, ratting)} size={24} color={colors.warning} />)
    }

    return elements;
  }

  return (
    <View style={[styles.container, style]}>
      {inflate(count, ratting)}
    </View>
  )
}