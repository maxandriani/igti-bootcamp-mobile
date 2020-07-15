import { IAccount } from "../i-account";

/** Considere o cliente com o maior saldo em cada agência (caso haja mais de um cliente com o maior saldo, escolha apenas um). O valor total desses saldos é: */
export default function calcTotalOfHigestAccPerAgency(...accounts: Array<IAccount>) {
  const agencies = new Map<number, IAccount>();

  for (const acc of accounts) {
    if (agencies.has(acc.agencia)) {
      if ((agencies.get(acc.agencia)?.balance || 0) < acc.balance) {
        agencies.set(acc.agencia, acc);
      }
    } else {
      agencies.set(acc.agencia, acc);
    }
  }

  const sun = Array.from(agencies.values())
    .reduce((prev, item) => ({...prev, balance: prev.balance + item.balance}), { balance: 0 });

  console.info(`Considere o cliente com o maior saldo em cada agência (caso haja mais de um cliente com o maior saldo, escolha apenas um). O valor total desses saldos é: $${sun.balance}`);

}