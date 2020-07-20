import 'package:desafio_dart/domains/account.dart';

/// Quantos clientes que tem Maria no nome estão na agencia 47?
void howManyAccWNameMariaAtAg47(List<Account> accounts) {
  final sum = accounts
      .where((acc) =>
          acc.agencia == 47 &&
          acc.name
              .contains(RegExp('maria', multiLine: true, caseSensitive: false)))
      .length;

  print('Quantos clientes que tem Maria no nome estão na agencia 47? ${sum}');
}
