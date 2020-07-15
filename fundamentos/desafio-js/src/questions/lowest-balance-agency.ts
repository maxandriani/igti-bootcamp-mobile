import { IAccount } from "../i-account";

/** A agência com o menor saldo é a: */
export default function lowestBalanceAgency(...accounts: Array<IAccount>) {
  const accs = new Map<number, number>();

  for (const acc of accounts) {
    accs.set(acc.agencia, (accs.get(acc.agencia) || 0) + acc.balance);
  }

  const acc = Array.from(accs.entries())
    .sort((a, b) => a[1] - b[1])[0];

  console.info(`A agência com o menor saldo é a: ${acc[0]}, $${acc[1]}`);
}