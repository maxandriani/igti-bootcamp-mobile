import 'package:desafio_dart/domains/account.dart';

/// O número total de contas com mais de 100 reais de saldo é:
void totalHigherThan100(List<Account> accounts) {
  final higherThan100 = accounts.where((acc) => acc.balance > 100).length;

  print(
      'O número total de contas com mais de 100 reais de saldo é: ${higherThan100}');
}
