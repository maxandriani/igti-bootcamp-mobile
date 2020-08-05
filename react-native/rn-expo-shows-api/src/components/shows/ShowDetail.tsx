import React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import DetailShowDto from '../../entities/details-show.dto';
import SaStars from '../ui/SaStars';
import { MaterialIcons } from '@expo/vector-icons'
import colors from '../../shared/colors';

export interface IShowDetailProps {
  show: DetailShowDto
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
    shadowColor: 'black',
    shadowOpacity: 0.4,
    shadowRadius: 10,
    borderRadius: 10,
    padding: 20
  },
  description: {
    borderBottomColor: 'grey',
    borderBottomWidth: 1,
    paddingBottom: 16
  },
  descriptionText: {
    fontSize: 16,
    lineHeight: 21,
    marginBottom: 16
  },
  descriptionSource: {
    fontSize: 11,
    lineHeight: 16
  },

  dateBar: {
    justifyContent: 'center',
    alignItems: 'center'
  },
  date: {
    minWidth: 90
  },
  text: {
    fontSize: 16,
    lineHeight: 21
  },
  label: {
    minWidth: 100,
    maxWidth: 140,
    fontSize: 12,
    lineHeight: 21
  },
  icon: {
    marginHorizontal: 10,
    marginVertical: 5
  },
  box: {
    paddingVertical: 12,
    borderBottomColor: 'grey',
    borderBottomWidth: 1,
    flexDirection: 'row',
    alignItems: 'stretch',
    justifyContent: 'flex-start'
  },
  tag: {
    backgroundColor: colors.accent,
    paddingVertical: 5,
    paddingHorizontal: 10,
    borderRadius: 20,
    margin: 4
  }
});

export default function ShowDetail({ show }: IShowDetailProps) {

  function printDate(date: Date | null): string {
    return (date)
      ? `${date.getDate()}/${date.getMonth() + 1}/${date.getFullYear()}`
      : ``;
  }

  function stripText(text: string): JSX.Element[] {
    const paragraphs = text.split(/\<br\/?\>/gi);
    return paragraphs
      .map((t, idx) => <Text key={idx} style={styles.descriptionText}>{t.replace(/(<([^>]+)>)/ig, '')}</Text>)
  }

//   const regex = /(<([^>]+)>)/ig;
// const result = data.description.replace(regex, '');

  return (
    <View style={styles.container}>
      <SaStars style={[styles.box, { justifyContent: 'center', marginTop: 0, borderBottomWidth: 0 }]} count={5} ratting={show.rating} />

      <View style={styles.description}>
        {stripText(show.description)}
        <Text style={styles.descriptionSource}>Fonte: {show.descriptionSource}</Text>
      </View>

      <View style={[styles.box, styles.dateBar]}>
        <Text style={[styles.text, styles.date]}>{printDate(show.startDate)}</Text>
        <MaterialIcons style={styles.icon} name="arrow-forward" size={24} color="black" />
        <Text style={[styles.text, styles.date]}>{printDate(show.endDate)}</Text>
      </View>

      <View style={styles.box}>
        <Text style={styles.label}>País</Text>
        <Text style={styles.text}>{show.country}</Text>
      </View>

      <View style={styles.box}>
        <Text style={styles.label}>Status</Text>
        <Text style={styles.text}>{show.status}</Text>
      </View>

      <View style={styles.box}>
        <Text style={styles.label}>Emissora</Text>
        <Text style={styles.text}>{show.network}</Text>
      </View>

      <View style={[styles.box, { borderBottomWidth: 0, justifyContent: 'center' }]}>
        {show.genres.map((genre, idx) => (<Text key={idx} style={styles.tag}>{genre}</Text>))}
      </View>
    </View>
  )
}