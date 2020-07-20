import 'package:desafio_dart/domains/account.dart';

/// O número de contas com mais de 100 reais de saldo na agência 33 é:
void higherThan100OnAgency33(List<Account> accounts) {
  final n =
      accounts.where((acc) => acc.balance > 100 && acc.agencia == 33).length;

  print(
      'O número de contas com mais de 100 reais de saldo na agência 33 é: ${n}');
}
