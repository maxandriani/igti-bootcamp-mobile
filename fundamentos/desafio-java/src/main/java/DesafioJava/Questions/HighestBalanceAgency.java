package DesafioJava.Questions;

import java.util.Collection;
import java.util.HashMap;

import com.google.common.base.MoreObjects;

import DesafioJava.Domain.Account;

public class HighestBalanceAgency implements IQuestion {

    /** A agência com maior saldo é a: */
    @Override
    public void execute(Collection<Account> accounts) {
	
	var accs = new HashMap<Integer, Integer>(); // Agência vs Saldos...
	
	for (var acc : accounts) {
	    accs.put(acc.getAgencia(),
		     (
			     MoreObjects.firstNonNull(accs.get(acc.getAgencia()), 0)
			     + acc.getBalance()
		     ));
	}
	
	var node = accs
		.entrySet()
		.stream()
		.sorted((a, b) -> b.getValue() - a.getValue())
		.findFirst()
		.orElseThrow();

	System.out.println(
		"A agência com maior saldo é a: "
		+ node.getKey()
		+ ", $"
		+ node.getValue());
//	}
	
    }

}
