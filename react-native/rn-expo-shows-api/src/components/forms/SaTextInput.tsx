import React, { useState } from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { TextInput } from 'react-native-gesture-handler';
import colors from '../../shared/colors';

const styles = StyleSheet.create({
  container: {
    backgroundColor: colors.inputs.background,
    borderRadius: 5,
    borderBottomColor: colors.inputs.border,
    borderBottomWidth: 5,
    padding: 5,
    shadowColor: colors.inputs.shadow,
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.8,
    shadowRadius: 2,
    width: '100%'
  },
  label: {
    fontSize: 12
  },
  input: {
    fontSize: 16,
    height: 32
  }
});

export default function SaTextInput(props: {
  label: string,
  value?: string,
  onChange: (text: string) => void
}) {

  const [value, setValue] = useState(props.value);

  function onChange(val: string) {
    setValue(val);
    props.onChange(val);
  }

  return (
    <View style={styles.container}>
      <Text style={styles.label}>{props.label}</Text>
      <TextInput
        style={styles.input}
        value={value}
        onChangeText={onChange}></TextInput>
    </View>
  );
}