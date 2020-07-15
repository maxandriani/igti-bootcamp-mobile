import { IAccount } from "../i-account";

/** O número de contas com mais de 100 reais de saldo na agência 33 é: */
export default function higherThan100OnAgency33(...accounts: Array<IAccount>) {
  const n = accounts
    .filter(acc => acc.balance > 100 && acc.agencia == 33)
    .length;
  console.info(`O número de contas com mais de 100 reais de saldo na agência 33 é: ${n}`);
}