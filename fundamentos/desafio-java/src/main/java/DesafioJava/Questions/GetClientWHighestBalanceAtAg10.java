package DesafioJava.Questions;

import java.util.Collection;

import DesafioJava.Domain.Account;

public class GetClientWHighestBalanceAtAg10 implements IQuestion {

    /** O nome do(a) cliente com o maior saldo na agência 10 é: */
    @Override
    public void execute(Collection<Account> accounts) {
	var acc = accounts
	  .stream()
	  .filter(a -> a.getAgencia().equals(10))
	  .sorted((a, b) -> (int) (b.getBalance() - a.getBalance()))
	  .findFirst()
	  .orElseThrow();
	
	System.out.println(
		"O nome do(a) cliente com o maior saldo na agência 10 é: "
		+ acc.getName()
		+ ", w/ $"
		+ acc.getBalance());
	
    }

}
