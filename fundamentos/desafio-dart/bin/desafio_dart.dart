import 'dart:convert';
import 'package:http/http.dart';

import 'package:desafio_dart/domains/account.dart';
import 'package:desafio_dart/questions/calc_total_of_highest_acc_per_agency.dart';
import 'package:desafio_dart/questions/get_client_w_highest_balance_at_ag_10.dart';
import 'package:desafio_dart/questions/get_client_w_lowest_balance_at_ag_47.dart';
import 'package:desafio_dart/questions/get_next_id.dart';
import 'package:desafio_dart/questions/higher_than_100_on_agency_33.dart';
import 'package:desafio_dart/questions/highest_balance_agency.dart';
import 'package:desafio_dart/questions/how_many_acc_at_ag_47.dart';
import 'package:desafio_dart/questions/how_many_acc_w_name_maria_at_ag_47.dart';
import 'package:desafio_dart/questions/lowest_balance_agency.dart';
import 'package:desafio_dart/questions/sun_of_deposits.dart';
import 'package:desafio_dart/questions/top_3_lowest_balance_at_ag_47.dart';
import 'package:desafio_dart/questions/total_higher_than_100.dart';

void main(List<String> arguments) async {
  print('Starting Desafio Fundamentos Mobile IGTI: Dart');

  print('Start requesting...');
  var response = await get('https://igti-film.herokuapp.com/api/accounts');

  print('JSON decoding...');
  List<dynamic> jsonAccounts = jsonDecode(response.body.toString());

  final accounts = jsonAccounts.map((item) => Account.fromJson(item)).toList();

  print('Answering questions...');
  calcTotalOfHigestAccPerAgency(accounts);
  getClientWHighestBalanceAtAg10(accounts);
  getClientWLowestBalanceAtAg47(accounts);
  getNextId(accounts);
  higherThan100OnAgency33(accounts);
  highestBalanceAgency(accounts);
  howManyAccAtAg47(accounts);
  howManyAccWNameMariaAtAg47(accounts);
  lowestBalanceAgency(accounts);
  sunOfDeposits(accounts);
  top3LowestBalanceAtAg47(accounts);
  totalHigherThan100(accounts);
}
