import 'package:desafio_dart/domains/account.dart';

/// A agência com maior saldo é a:
void highestBalanceAgency(List<Account> accounts) {
  var accs = Map<int, double>();

  for (var acc in accounts) {
    accs[acc.agencia] = ((accs[acc.agencia] ?? 0) + acc.balance);
  }

  final sorted = accs.entries.toList()
    ..sort((a, b) => b.value.compareTo(a.value));

  final acc = sorted.first;

  print('A agência com maior saldo é a: ${acc.key}, \$${acc.value}');
}
