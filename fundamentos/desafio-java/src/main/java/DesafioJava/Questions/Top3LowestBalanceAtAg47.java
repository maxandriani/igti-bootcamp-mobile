package DesafioJava.Questions;

import java.util.Collection;
import java.util.stream.Collectors;

import DesafioJava.Domain.Account;

public class Top3LowestBalanceAtAg47 implements IQuestion {

    /**
     * Você deve mostrar os nomes dos três clientes com menor saldo da agência 47, 
     * separados por vírgula e em ordem crescente (do menor para o maior). 
     * 
     * Qual seria a sua saída do programa?
     */
    @Override
    public void execute(Collection<Account> accounts) {
	
	var names = accounts
		.stream()
		.filter(acc -> acc.getAgencia().equals(47))
		.sorted((a, b) -> a.getBalance() - b.getBalance())
		.limit(3)
		.map(item -> item.getName())
		.sorted()
		.collect(Collectors.joining(", "));
	
	
	System.out.println(
		"Os três clientes com menor saldo da ag 47 são: $"
		+ names);
	
    }

}
