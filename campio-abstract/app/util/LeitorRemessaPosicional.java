package campio.app.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import campio.app.model.Transacao;

public class LeitorRemessaPosicional extends LeitorRemessa {
	public List<Transacao> converter (String caminhoArquivo){
		System.out.println("IMPLEMENTACAO POSICIONAL");
		
		List<String> conteudos = ler(caminhoArquivo);
		
		
		return null;
	}
}
