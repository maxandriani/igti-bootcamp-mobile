import { IAccount } from "../i-account";

/**
 * Você deve mostrar os nomes dos três clientes com menor saldo da agência 47, 
 * separados por vírgula e em ordem crescente (do menor para o maior). 
 * 
 * Qual seria a sua saída do programa?
 */
export default function top3LowestBalanceAtAg47(...accounts: Array<IAccount>) {
  const names = accounts
    .filter(acc => acc.agencia == 47)
    .sort((a, b) => a.balance - b.balance)
    .filter((acc, idx) => idx < 3)
    .map(acc => acc.name)
    .sort();

  console.log(`Os três clientes com menor saldo da ag 47 são: ${names.join(', ')}`);
}