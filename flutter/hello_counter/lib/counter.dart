import 'package:flutter/material.dart';

class Counter extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return CounterState();
  }
}

class CounterState extends State<Counter> {
  int valor = 0;

  increment() {
    setState(() {
      valor++;
    });
  }

  decrement() {
    setState(() {
      valor--;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Counter'),
      ),
      body: ListView(
        children: <Widget>[
          Card(
            child: Column(
              children: <Widget>[
                ListTile(
                  title: Text('Counter state'),
                ),
                Text(
                  'Count: $valor',
                  style: TextStyle(fontSize: 40),
                ),
                Divider(),
                ButtonBar(
                  alignment: MainAxisAlignment.center,
                  children: <Widget>[
                    RaisedButton(
                        onPressed: () => increment(),
                        child: Text(
                          '+',
                          style: TextStyle(fontSize: 20),
                        )),
                    RaisedButton(
                      onPressed: () => decrement(),
                      child: Text(
                        '-',
                        style: TextStyle(fontSize: 20),
                      ),
                    ),
                  ],
                )
              ],
            ),
          )
        ],
      ),
    );
  }
}
