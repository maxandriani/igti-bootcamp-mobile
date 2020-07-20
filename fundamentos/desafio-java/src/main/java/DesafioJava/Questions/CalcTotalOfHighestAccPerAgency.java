package DesafioJava.Questions;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;

import com.google.common.base.MoreObjects;

import DesafioJava.Domain.Account;

public class CalcTotalOfHighestAccPerAgency implements IQuestion {

    /** 
     * Considere o cliente com o maior saldo em cada agência (caso haja mais de um cliente com o maior saldo, escolha apenas um). O valor total desses saldos é: 
     */
    @Override
    public void execute(Collection<Account> accounts) {
	var agencies = new HashMap<Integer, Account>();
	
	for (var acc : accounts) {
	    if (agencies.containsKey(acc.getAgencia())) {
		if (MoreObjects.firstNonNull(agencies.get(acc.getAgencia()).getBalance(), 0) < acc.getBalance()) {
		    agencies.put(acc.getAgencia(), acc);
		}
	    } else {
		agencies.put(acc.getAgencia(), acc);
	    }
	}
	
	var sum = agencies
		.values()
		.stream()
		.reduce(new Account(), (Account prev, Account current) -> new Account(null, null, null, null, (prev.getBalance() + current.getBalance())));
	
	System.out.println(
		"Considere o cliente com o maior saldo em cada agência (caso haja mais de um cliente com o maior saldo, escolha apenas um). O valor total desses saldos é: $" 
		+ sum.getBalance());
	
    }

}
