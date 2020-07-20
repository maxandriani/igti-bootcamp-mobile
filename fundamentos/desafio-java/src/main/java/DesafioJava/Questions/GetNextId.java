package DesafioJava.Questions;

import java.util.Collection;

import DesafioJava.Domain.Account;

public class GetNextId implements IQuestion {
    
    /** Considerando que o id deve ser único e é sequencial, qual o próximo id possível para conta? */
    @Override
    public void execute(Collection<Account> accounts) {
	
	var nextId = accounts
		.stream()
		.sorted((a, b) -> b.getId() - a.getId())
		.findFirst()
		.map(item -> item.getId() + 1)
		.orElseThrow();
	
	System.out.println(
		"Considerando que o id deve ser único e é sequencial, qual o próximo id possível para conta? "
		+ nextId);
	
    }
}
