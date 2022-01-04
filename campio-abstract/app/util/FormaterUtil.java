package campio.app.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import campio.app.model.Moeda;

public class FormaterUtil {
	// https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
	public static String moeda(Double valor, Moeda moeda) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
		if (moeda == Moeda.BRL)
			symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
		DecimalFormat formatter = new DecimalFormat("¤ ###,###.###", symbols);
		return formatter.format(valor);
	}

	public static String cpf(String cpf) {
		String part1 = cpf.substring(0, 3);
		String part2 = cpf.substring(3, 6);
		String part3 = cpf.substring(6, 9);
		String part4 = cpf.substring(9, 11);
		String cpfFormatado = part1.concat(".").concat(part2).concat(".").concat(part3).concat("-").concat(part4);
		return cpfFormatado;
	}

	public static String data(LocalDateTime data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data.format(formatter);
	}

	public static String hora(LocalDateTime hora) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh.mm.ss");
		return hora.format(formatter);
	}

	
}
