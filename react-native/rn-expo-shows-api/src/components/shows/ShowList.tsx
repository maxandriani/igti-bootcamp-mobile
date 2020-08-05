import React from 'react';
import { StyleSheet, Text, FlatList, TouchableOpacity, View, Image } from 'react-native';
import colors from '../../shared/colors';
import { MaterialIcons } from '@expo/vector-icons';
import ShowListDto from '../../entities/list-show.dto';

export interface IShowListItemProps {
  item: ShowListDto;
  onPress: (item: ShowListDto) => void;
}

export interface IShowListProps {
  items: Array<ShowListDto>;
  onPress: (item: ShowListDto) => void;
}

const styles = StyleSheet.create({
  container: {
  },
  listItem: {
    flex: 1,
    flexDirection: 'row',
    paddingHorizontal: 10,
    paddingVertical: 18,
    borderBottomWidth: 1,
    borderBottomColor: colors.accent,
    alignItems: 'center'
  },
  listItemContainer: {
    flex: 1
  },
  listItemText: {
    flex: 1,
    fontSize: 16
  },
  listItemDescription: {
    flex: 1,
    fontSize: 12
  },
  listItemThumb: {
    width: 42,
    height: 42,
    borderRadius: 21,
    marginRight: 20
  }
});

export function ShowListItem({ item, onPress }: IShowListItemProps) {
  return (
    <TouchableOpacity
      style={styles.listItem}
      onPress={() => onPress(item)}>
      <Image
        style={styles.listItemThumb}
        source={{ uri: item.imageThumbnailPath }}></Image>
      <View style={styles.listItemContainer}>
        <Text style={styles.listItemText}>{item.name}</Text>
        <Text style={styles.listItemDescription}>{item.status} | {item.network}</Text>
      </View>
      <MaterialIcons name="navigate-next" size={24} color={colors.accent} />
    </TouchableOpacity>
  )
}

export default function ShowList({ items, onPress }: IShowListProps) {
  return (
    <FlatList
      style={styles.container}
      data={items}
      renderItem={({ item }) => (
        <ShowListItem 
          item={item}
          onPress={onPress} />)}
      keyExtractor={(item, index) => item.id.toString()}/>
  )
}