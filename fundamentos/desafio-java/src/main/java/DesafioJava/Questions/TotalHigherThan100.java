package DesafioJava.Questions;

import java.util.Collection;

import DesafioJava.Domain.Account;

public class TotalHigherThan100 implements IQuestion {

    /** O número total de contas com mais de 100 reais de saldo é: */
    @Override
    public void execute(Collection<Account> accounts) {
	
	var sum = accounts
		.stream()
		.filter(item -> item.getBalance() > 100)
		.count();
	
	System.out.println(
		"O número total de contas com mais de 100 reais de saldo é: "
		+ sum);
	
    }

}
