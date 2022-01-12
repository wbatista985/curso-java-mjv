package campio.app.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import campio.app.model.Transacao;

public abstract class LeitorRemessa {

	public abstract List<Transacao> converter (String caminhoArquivo);
	
	protected List<String> ler(String caminhoArquivo) {
		try {
            List<String> transacoes = Files.readAllLines(Paths.get(caminhoArquivo), StandardCharsets.UTF_8);
            return transacoes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
}
