package bankapp;

import bankapp.model.Conta;
import bankapp.service.ContaService;

public class BankApplication {
	public static void main(String[] args) {
		//de 2 a 3 contas de integrantes
		//para realizar uma jornada nas contas
		
		Conta contaGleyson = new Conta();
		Conta contaJose = new Conta();
		
		ContaService terminal = new ContaService();
		terminal.depositar(contaGleyson, 50.0);
		terminal.depositar(contaJose, 20.0);
		
		System.out.println(contaGleyson.getSaldo());
		System.out.println(contaJose.getSaldo());
	}
}
