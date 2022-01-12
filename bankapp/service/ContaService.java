package bankapp.service;

import bankapp.model.Conta;

public class ContaService {
	//+2 a 3 recursos que poderia realizar com uma conta
	public void depositar (Conta conta, double valorDepositado ) {
		conta.setSaldo(valorDepositado);
	}
}
