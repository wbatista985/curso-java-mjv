package campio.app.util;

public class FormatUtilPower {
	public static String cep(Long cep) {
		String cepFormatado = cep.toString().format("%08d", cep);
		
		cepFormatado = cepFormatado.replaceAll("(\\d{2})(\\d{3})(\\d{3})", "$1.$2-$3");
		
		return cepFormatado;
	}
	public static String removerSpecialCaracteres(String texto) {
		String textoSemCaratereEspecial = texto.replaceAll("\\D", "");
		return textoSemCaratereEspecial;
	}
	public static void main(String[] args) {
		Long cep = 630102L;
		
		String cepFormatado =cep(cep); 
		System.out.println(cepFormatado);
		
		String cepSemFormatacao = removerSpecialCaracteres(cepFormatado);
		System.out.println(cepSemFormatacao);
	}
}
