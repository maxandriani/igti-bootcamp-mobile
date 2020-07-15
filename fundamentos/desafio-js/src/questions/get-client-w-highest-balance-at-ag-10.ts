import { IAccount } from "../i-account";
/** O nome do(a) cliente com o maior saldo na agência 10 é: */
export default function getClientWHighestBalanceAtAg10(...accounts: Array<IAccount>) {
  const acc = accounts
    .filter(acc => acc.agencia == 10)
    .sort((a, b) => b.balance - a.balance)[0]
  
  console.info(`O nome do(a) cliente com o maior saldo na agência 10 é: ${acc.name}, $${acc.balance}`);
}