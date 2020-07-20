class Account {
  final int id;
  final int agencia;
  final int conta;
  final String name;
  final double balance;

  Account(
      {this.id, this.agencia, this.conta, this.name = '', this.balance = 0});

  Account copyWith({int agencia, int conta, String name, double balance}) {
    return Account(
        agencia: agencia ?? this.agencia,
        conta: conta ?? this.conta,
        name: name ?? this.name,
        balance: balance ?? this.balance);
  }

  Account.fromJson(Map<String, dynamic> json)
      : id = json['id'],
        agencia = json['agencia'],
        conta = json['conta'],
        name = json['name'],
        balance = json['balance'] + .0; // +.0 cast possible int to double
}
