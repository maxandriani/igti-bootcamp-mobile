import { IAccount } from "../i-account";

/** Considerando que o id deve ser único e é sequencial, qual o próximo id possível para conta? */
export default function getNextId(...accounts: Array<IAccount>) {
  const nextId = accounts
    .sort((a, b) => b.id - a.id)[0].id + 1;

  console.log(`Considerando que o id deve ser único e é sequencial, qual o próximo id possível para conta? ${nextId}`);
}