import 'package:flutter/material.dart';

void main() {
  runApp(Hello());
}

class Hello extends StatelessWidget {
  onPressMeClick() {
    debugPrint("Clicouuu");
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Material(
        color: Colors.white,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: <Widget>[
            Image.asset(
              'assets/logo.png',
              width: 90.0,
            ),
            Text(
              'Hello Max 😂',
              style: TextStyle(fontSize: 40.0),
            ),
            FlatButton(
                color: Colors.lightBlue,
                onPressed: () => onPressMeClick(),
                child: Text(
                  "Press me :p",
                  style: TextStyle(fontSize: 20.0),
                ))
          ],
        ),
      ),
    );
  }
}
