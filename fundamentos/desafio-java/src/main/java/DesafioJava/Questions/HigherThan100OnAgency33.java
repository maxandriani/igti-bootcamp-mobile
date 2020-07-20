package DesafioJava.Questions;

import java.util.Collection;

import DesafioJava.Domain.Account;

public class HigherThan100OnAgency33 implements IQuestion {

    /** O número de contas com mais de 100 reais de saldo na agência 33 é: */
    @Override
    public void execute(Collection<Account> accounts) {
	
	var count = accounts
		.stream()
		.filter(acc -> acc.getBalance() > 100 && acc.getAgencia().equals(33))
		.count();
	
	System.out.println(
		"O número de contas com mais de 100 reais de saldo na agência 33 é: "
		+ count);
	
    }

}
