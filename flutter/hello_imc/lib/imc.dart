import 'package:flutter/material.dart';

class Imc extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _ImcState();
  }
}

class _ImcLevel {
  double min;
  double max;
  String description;

  _ImcLevel({
    this.min,
    this.max,
    this.description
  });
}

class _ImcState extends State<Imc> {
  final _alturaCtrl  = TextEditingController();
  final _pesoCtrl    = TextEditingController();
  final _scaffoldkey = GlobalKey<ScaffoldState>();
  final _imcLevels   = [
    _ImcLevel(min: 0.0,   max: 17.0, description: 'Subnutrido'),
    _ImcLevel(min: 17.0,  max: 18.5, description: 'Abaixo do peso'),
    _ImcLevel(min: 18.5,  max: 25.0, description: 'Peso normal'),
    _ImcLevel(min: 25.0,  max: 30.0, description: 'Acima do peso'),
    _ImcLevel(min: 30.0,  max: 35.0, description: 'Obesidade I'),
    _ImcLevel(min: 35.0,  max: 40.0, description: 'Obesidade II (Severa)'),
    _ImcLevel(min: 40.0,  max: double.maxFinite, description: 'Obesidade III (Mórbida)')
  ];

  double imc = 0;

  _onItemTapped(int idx) {
    switch (idx) {
      case 1:
        _clearData();
        break;
      case 0:
        _calcImc();
        break;
    }
  }

  _clearData() {
    _alturaCtrl.clear();
    _pesoCtrl.clear();
    setState(() {
      imc = 0.0;
    });
  }

  _calcImc() {
    final alturaStr = _alturaCtrl.text,
          pesoStr   = _pesoCtrl.text;

    if (alturaStr.isEmpty || pesoStr.isEmpty) {
      return _scaffoldkey
        .currentState
        .showSnackBar(
          SnackBar(
            content: Text('Você precisa informar seu peso e também sua altura.')));
    }

    final altura = double.parse(alturaStr),
          peso   = double.parse(pesoStr);

    setState(() {
      imc = peso / (altura * altura);  
    });
  }

  String _getImcLevel(double _imc) {
    return (_imc > 0)
      ? _imcLevels
        .firstWhere((element) => element.min <= _imc && element.max > _imc)
        .description
      : '';
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: _scaffoldkey,
      appBar: AppBar(
        title: Text('Hello IMC'),
      ),
      body: ListView(
        children: <Widget>[
          Container(
            padding: EdgeInsets.symmetric(vertical: 12, horizontal: 64),
            alignment: Alignment.center,
            child: Image.asset(
              'assets/weight-solid.png',
              width: 120,
            ),
          ),
          Container(
              padding: EdgeInsets.all(12),
              child: TextField(
                keyboardType: TextInputType.numberWithOptions(decimal: true),
                controller: _alturaCtrl,
                decoration: InputDecoration(
                  hintText: 'Altura (m)',
                  icon: Icon(Icons.accessibility),
                  border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(5)),
                ),
              )),
          Container(
            padding: EdgeInsets.all(12),
            child: TextField(
              keyboardType: TextInputType.numberWithOptions(decimal: true),
              controller: _pesoCtrl,
              decoration: InputDecoration(
                hintText: 'Peso (Kg)',
                icon: Icon(Icons.file_download),
                border:
                    OutlineInputBorder(borderRadius: BorderRadius.circular(5)),
              ),
            ),
          ),
          Container(
            padding: EdgeInsets.all(12),
            alignment: Alignment.center,
            child: Text('IMC: ${imc.toStringAsFixed(2)}'),
          ),
          Container(
            padding: EdgeInsets.all(12),
            alignment: Alignment.center,
            child: Text('${_getImcLevel(imc)}'),
          )
        ],
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: [
          BottomNavigationBarItem(
              title: Text('Calcular'), icon: Icon(Icons.assignment_turned_in)),
          BottomNavigationBarItem(
              title: Text('Limpar'), icon: Icon(Icons.clear))
        ],
        onTap: (value) => _onItemTapped(value),
      ),
    );
  }
}
