package DesafioJava.Questions;

import java.util.Collection;

import DesafioJava.Domain.Account;

public class HowManyAccWNameMariaAtAg47 implements IQuestion {

    /** Quantos clientes que tem Maria no nome estão na agencia 47? */
    @Override
    public void execute(Collection<Account> accounts) {
	
	var sum = accounts
		.stream()
		.filter(item -> 
			item.getAgencia()
				.equals(47)
			&& item.getName()
				.toLowerCase()
				.contains("maria"))
		.count();
	
	System.out.println(
		"Quantos clientes que tem Maria no nome estão na agencia 47? "
		+ sum);
    }

}
