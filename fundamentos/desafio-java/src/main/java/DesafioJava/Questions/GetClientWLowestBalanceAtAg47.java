package DesafioJava.Questions;

import java.util.Collection;

import DesafioJava.Domain.Account;

public class GetClientWLowestBalanceAtAg47 implements IQuestion {

    /** O nome do(a) cliente com o menor saldo na agência 47 é: */
    @Override
    public void execute(Collection<Account> accounts) {
	
	var acc = accounts
		.stream()
		.filter(item -> item.getAgencia().equals(47))
		.sorted((a, b) -> a.getBalance() - b.getBalance())
		.findFirst()
		.orElseThrow();
	
	System.out.println(
		"O nome do(a) cliente com o menor saldo na agência 47 é: "
		+ acc.getName()
		+ ", w/ $"
		+ acc.getBalance());
	
    }

}
