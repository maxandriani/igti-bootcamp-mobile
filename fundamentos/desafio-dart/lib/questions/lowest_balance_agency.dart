import 'package:desafio_dart/domains/account.dart';

/// A agência com o menor saldo é a:
void lowestBalanceAgency(List<Account> accounts) {
  final accs = Map<int, double>();

  for (var acc in accounts) {
    accs[acc.agencia] = (accs[acc.agencia] ?? 0) + acc.balance;
  }

  final sorted = accs.entries.toList();

  sorted.sort((a, b) => a.value.compareTo(b.value));

  final acc = sorted.first;

  print('A agência com o menor saldo é a: ${acc.key}, \$${acc.value}');
}
