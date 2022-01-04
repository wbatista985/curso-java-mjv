package campio.app.util;

import campio.app.model.Transacao;

public class TransacaoPrint {
	public String imprimir(Transacao transacao) {
	
		StringBuilder cupom = new StringBuilder();
		cupom.append("------------------------------\n");
		cupom.append("SIS CAMBIO - COMPROVANTE DE TRANSACAO\n");
		cupom.append("TRANSACAO DE CAMBIO\n");
		cupom.append("------------------------------\n");
		cupom.append(String.format("%-10s%s\n","NOME:",transacao.getNome()));
		cupom.append(String.format("%-10s%s\n","CPF:",FormaterUtil.cpf(transacao.getCpf())));
		cupom.append("------------------------------\n");
		cupom.append(String.format("%-10s%s\n","VENDIDO:",FormaterUtil.moeda(transacao.getValorVendido(), transacao.getMoedaVenda())));
		cupom.append(String.format("%-10s%s\n","COMPRADO:",FormaterUtil.moeda(transacao.getValorComprado(), transacao.getMoedaCompra())));
		cupom.append(String.format("%10d", 123));
		
		System.out.println(cupom);
		return cupom.toString();
	}
}
