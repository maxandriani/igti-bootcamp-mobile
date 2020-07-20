import 'package:desafio_dart/domains/account.dart';

/// Considerando que o id deve ser único e é sequencial, qual o próximo id possível para conta?
void getNextId(List<Account> accounts) {
  final accs = accounts..sort((a, b) => b.id.compareTo(a.id));

  final nextId = accs.first.id + 1;

  print(
      'Considerando que o id deve ser único e é sequencial, qual o próximo id possível para conta? ${nextId}');
}
