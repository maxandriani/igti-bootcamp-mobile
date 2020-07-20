import 'package:desafio_dart/domains/account.dart';

/// O nome do(a) cliente com o maior saldo na agência 10 é:
void getClientWHighestBalanceAtAg10(List<Account> accounts) {
  final accs = accounts.where((acc) => acc.agencia == 10).toList();

  accs.sort((Account a, Account b) => b.balance.compareTo(a.balance));

  final client = accs.first;

  print(
      'O nome do(a) cliente com o maior saldo na agência 10 é: ${client.name}, \$${client.balance}');
}
