package DesafioJava.Questions;

import java.util.Collection;

import DesafioJava.Domain.Account;

public class SumOfDeposits implements IQuestion {

    /** A Soma total dos depósitos de todas as agências é: */
    @Override
    public void execute(Collection<Account> accounts) {
	
	var total = accounts
		.stream()
		.reduce(new Account(), (prev, current) -> new Account(null, null, null, null, prev.getBalance() + current.getBalance()))
		.getBalance();
	
	System.out.println(
		"A Soma total dos depósitos de todas as agências é: $"
		+ total);
	
    }

}
