import 'package:desafio_dart/domains/account.dart';

/// A Soma total dos depósitos de todas as agências é:
void sunOfDeposits(List<Account> accounts) {
  final total = accounts.reduce((prev, current) =>
      current.copyWith(balance: (prev?.balance ?? 0) + current.balance));

  print('A Soma total dos depósitos de todas as agências é: ${total.balance}');
}
