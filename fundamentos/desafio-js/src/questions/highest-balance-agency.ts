import { IAccount } from "../i-account";

/** A agência com maior saldo é a: */
export default function highestBalanceAgency(...accounts: Array<IAccount>) {
  const accs = new Map<number, number>();

  for (const acc of accounts) {
    accs.set(acc.agencia, (accs.get(acc.agencia) || 0) + acc.balance);
  }

  const acc = Array.from(accs.entries())
    .sort((a, b) => b[1] - a[1])[0];

  console.info(`A agência com maior saldo é a: ${acc[0]}, $${acc[1]}`);
}