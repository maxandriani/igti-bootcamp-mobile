import 'package:desafio_dart/domains/account.dart';

/// Considere o cliente com o maior saldo em cada agência (caso haja mais de um cliente com o maior saldo,
/// escolha apenas um). O valor total desses saldos é:
void calcTotalOfHigestAccPerAgency(List<Account> accounts) {
  var agencies = Map<int, Account>();

  for (var acc in accounts) {
    if (agencies.containsKey(acc.agencia)) {
      if ((agencies[acc.agencia].balance ?? 0) < acc.balance) {
        agencies[acc.agencia] = acc;
      }
    } else {
      agencies[acc.agencia] = acc;
    }
  }

  var sum = agencies.values.reduce((prev, item) =>
      item.copyWith(balance: (prev?.balance ?? 0) + item.balance));

  print(
      'Considere o cliente com o maior saldo em cada agência (caso haja mais de um cliente com o maior saldo, escolha apenas um). O valor total desses saldos é: \$${sum.balance}');
}
