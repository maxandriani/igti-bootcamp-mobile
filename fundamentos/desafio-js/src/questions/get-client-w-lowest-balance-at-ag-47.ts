import { IAccount } from "../i-account";

/** O nome do(a) cliente com o menor saldo na agência 47 é: */
export default function getClientWLowestBalanceAtAg47(...accounts: Array<IAccount>) {
  const acc = accounts
    .filter(acc => acc.agencia == 47)
    .sort((a, b) => a.balance - b.balance)[0];

  console.info(`O nome do(a) cliente com o menor saldo na agência 47 é: ${acc.name}, $${acc.balance}`);
}