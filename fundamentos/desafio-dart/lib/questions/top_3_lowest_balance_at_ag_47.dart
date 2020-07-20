import 'package:desafio_dart/domains/account.dart';

/// Você deve mostrar os nomes dos três clientes com menor saldo da agência 47,
/// separados por vírgula e em ordem crescente (do menor para o maior).
///
/// Qual seria a sua saída do programa?
void top3LowestBalanceAtAg47(List<Account> accounts) {
  final names = (accounts
          .where((acc) => acc.agencia == 47)
          .toList() // Convert iterable to List
            ..sort((a, b) => a.balance.compareTo(b.balance)) // Chaining sort
      ) // return toList (before ..)
      .take(3)
      .map((acc) => acc.name)
      .toList() // Convert Iterable to List
        ..sort(); // Chaining Sort

  print('Os três clientes com menor saldo da ag 47 são: ${names.join(', ')}');
}
