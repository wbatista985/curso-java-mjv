package campio.app.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import campio.app.model.Moeda;
import campio.app.model.Transacao;

public class LeitorRemessaDelimitado extends LeitorRemessa {
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
	
	public List<Transacao> converter (String caminhoArquivo){
		System.out.println("IMPLEMENTACAO DELIMITADA");
		List<String> conteudos = ler(caminhoArquivo);
		List<Transacao> transacoes = new ArrayList();
		
		for(String linha:conteudos) {
			String [] campos = linha.split(";");
			Transacao t = new Transacao();
			t.setCpf(campos[1]);
			t.setNome(campos[2]);
			t.setValorVendido(Double.valueOf(campos[4]));
			t.setTaxaCambio(Double.valueOf(campos[5]));
			t.setValorComprado(Double.valueOf(campos[7]));
			t.setMoedaVenda(Moeda.valueOf( campos[3].toUpperCase() ));
			t.setMoedaCompra(Moeda.valueOf( campos[6].toUpperCase() ));
			
			String date = campos[0];
			
			LocalDate data = LocalDate.parse(date,formatter);
			t.setDataTransacao(data);
			
			transacoes.add(t);
		}
		return transacoes;
	}
}
