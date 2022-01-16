package easy.job.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProfissionalPost {
	private Integer id;
	private String nome;
	private String profissao;
	private String email;
	private String biografia;
	private MultipartFile image;
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	@Override
	public String toString() {
		return "Profissional [id=" + id + ", nome=" + nome + ", profissao=" + profissao + ", email=" + email
				+ ", biografia=" + biografia + "]";
	}
}
