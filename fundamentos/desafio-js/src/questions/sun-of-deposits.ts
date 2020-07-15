import { IAccount } from "../i-account";

/** A Soma total dos depósitos de todas as agências é: */
export default function sunOfDeposits(...accounts: Array<IAccount>) {
  const total = accounts.reduce((prev, current) => ({ ...prev, balance: prev.balance + current.balance }), { balance: 0 });
  console.info(`A Soma total dos depósitos de todas as agências é: ${total.balance}`);
}