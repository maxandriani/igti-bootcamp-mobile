import 'package:desafio_dart/domains/account.dart';
import 'package:desafio_dart/questions/get_client_w_highest_balance_at_ag_10.dart';

/// O nome do(a) cliente com o menor saldo na agência 47 é:
void getClientWLowestBalanceAtAg47(List<Account> accounts) {
  final accs = accounts.where((item) => item.agencia == 47).toList();

  accs.sort((a, b) => a.balance.compareTo(b.balance));

  final acc = accs.first;

  print(
      'O nome do(a) cliente com o menor saldo na agência 47 é: ${acc.name}, \$${acc.balance}');
}
