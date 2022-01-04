package campio.app.model;

public enum Moeda {
	USD ("DOLAR"),
	BRL ("REAL");
	private String nome;
	private Moeda(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
}
