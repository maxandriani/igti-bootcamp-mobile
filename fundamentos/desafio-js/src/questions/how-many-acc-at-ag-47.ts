import { IAccount } from "../i-account";

/**
 * Quantos clientes estão na agência 47?
 */
export default function howManyAccAtAg47(...accounts: Array<IAccount>) {
  const sum = accounts
    .filter(acc => acc.agencia == 47)
    .length;

  console.info(`Quantos clientes estão na agência 47? ${sum}`);
}