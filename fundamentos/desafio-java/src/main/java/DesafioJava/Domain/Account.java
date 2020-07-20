package DesafioJava.Domain;

public class Account {
    
    Integer id;
    Integer agencia;
    Integer conta;
    String name;
    Double balance = 0.0;
    
    public Account() {}
    
    public Account(Integer id,
	           Integer agencia,
	           Integer conta,
	           String name,
	           Double balance) {
	setId(id);
	setAgencia(agencia);
	setConta(conta);
	setName(name);
	setBalance(balance);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
