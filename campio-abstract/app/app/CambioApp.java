package campio.app.app;

import java.util.List;

import campio.app.model.Transacao;
import campio.app.util.LeitorRemessa;
import campio.app.util.LeitorRemessaDelimitado;
import campio.app.util.LeitorRemessaPosicional;
import campio.app.util.TransacaoPrint;

public class CambioApp {
	public static void main(String[] args) {
		
		LeitorRemessa leitor=null;
		String caminho = "C:\\estudo\\remessas\\POSREMESSA.csv";
		
		if(caminho.contains("DEL"))
			leitor = new LeitorRemessaDelimitado();
		else
			leitor = new LeitorRemessaPosicional();
		
		List<Transacao> transacoes = leitor.converter(caminho);
	
		TransacaoPrint printer = new TransacaoPrint();
		printer.imprimir(transacoes.get(0));
		
	}
}
