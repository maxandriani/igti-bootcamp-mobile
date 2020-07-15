import { IAccount } from "../i-account";

/** O número total de contas com mais de 100 reais de saldo é: */
export default function totalHigherThan100(...accounts: Array<IAccount>) {
  const higherThan100 = accounts
    .filter(acc => acc.balance > 100)
    .length;
  console.info(`O número total de contas com mais de 100 reais de saldo é: ${higherThan100}`);
}