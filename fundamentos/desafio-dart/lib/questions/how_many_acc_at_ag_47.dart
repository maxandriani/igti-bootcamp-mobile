import 'package:desafio_dart/domains/account.dart';

/// Quantos clientes estão na agência 47?
void howManyAccAtAg47(List<Account> accounts) {
  final sum = accounts.where((acc) => acc.agencia == 47).length;

  print('Quantos clientes estão na agência 47? ${sum}');
}
