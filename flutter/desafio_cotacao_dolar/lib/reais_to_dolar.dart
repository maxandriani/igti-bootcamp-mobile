import 'package:flutter/material.dart';

class ReaisToDolar extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _ReaisToDolarState();
  }
}

class _ReaisToDolarState extends State<ReaisToDolar> {
  final _reaisCtrl = TextEditingController();
  final _cotacaoCtrl = TextEditingController();
  final _scaffoldkey = GlobalKey<ScaffoldState>();

  double reaisToDolar = 0.0;

  _onItemTapped(int idx) {
    switch (idx) {
      case 1:
        _clearData();
        break;
      case 0:
        _calcReaisToDolar();
        break;
    }
  }

  _clearData() {
    _reaisCtrl.clear();
    _cotacaoCtrl.clear();
    setState(() {
      reaisToDolar = 0.0;
    });
  }

  _calcReaisToDolar() {
    final reaisStr = _reaisCtrl.text, cotacaoStr = _cotacaoCtrl.text;

    if (reaisStr.isEmpty || cotacaoStr.isEmpty) {
      return _scaffoldkey.currentState.showSnackBar(SnackBar(
          content: Text(
              'Você precisa informar quantos reais você possui e a cotação do dia.')));
    }

    final reais = double.parse(reaisStr), cotacao = double.parse(cotacaoStr);

    setState(() {
      reaisToDolar = (reais / cotacao);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: _scaffoldkey,
      appBar: AppBar(
        title: Text('Reais -> Dolar'),
      ),
      body: ListView(
        children: <Widget>[
          Container(
            padding: EdgeInsets.symmetric(vertical: 12, horizontal: 64),
            alignment: Alignment.center,
            child: Icon(Icons.monetization_on, size: 120),
          ),
          Container(
              padding: EdgeInsets.all(12),
              child: TextField(
                keyboardType: TextInputType.numberWithOptions(decimal: true),
                controller: _reaisCtrl,
                decoration: InputDecoration(
                  hintText: 'Reais (R\$ 00,0)',
                  icon: Icon(Icons.attach_money),
                  border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(5)),
                ),
              )),
          Container(
            padding: EdgeInsets.all(12),
            child: TextField(
              keyboardType: TextInputType.numberWithOptions(decimal: true),
              controller: _cotacaoCtrl,
              decoration: InputDecoration(
                hintText: 'Cotação do dia (US\$ 1,00 é igual a?)',
                icon: Icon(Icons.attach_money),
                border:
                    OutlineInputBorder(borderRadius: BorderRadius.circular(5)),
              ),
            ),
          ),
          if (reaisToDolar > 0.0)
            Container(
              padding: EdgeInsets.all(12),
              alignment: Alignment.center,
              child: Text(
                  'Com R\$ ${_reaisCtrl.text} é possível comprar US\$ ${reaisToDolar.toStringAsFixed(2)} com taxa de conversão de R\$ ${_cotacaoCtrl.text}'),
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
