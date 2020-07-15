import { IAccount } from "../i-account";

/** Quantos clientes que tem Maria no nome estão na agencia 47? */
export default function howManyAccWNameMariaAtAg47(...accounts: Array<IAccount>) {
  const sum = accounts
    .filter(acc => acc.agencia == 47 && acc.name.match(/maria/gi))
    .length;

  console.info(`Quantos clientes que tem Maria no nome estão na agencia 47? ${sum}`);
}