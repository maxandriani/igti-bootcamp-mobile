package DesafioJava.Questions;

import java.util.Collection;

import DesafioJava.Domain.Account;

public interface IQuestion {
    public void execute(Collection<Account> accounts);
}
