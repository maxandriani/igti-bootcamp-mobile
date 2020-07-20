package DesafioJava.Questions;

import java.util.Collection;

import DesafioJava.Domain.Account;

public class HowManyAccAtAg47 implements IQuestion {

    /**
     * Quantos clientes estão na agência 47?
     */
    @Override
    public void execute(Collection<Account> accounts) {
	
	var sum = accounts
		.stream()
		.filter(item -> item.getAgencia().equals(47))
		.count();
	
	System.out.println(
		"Quantos clientes estão na agência 47? "
		+ sum);
//	}
	
    }

}
