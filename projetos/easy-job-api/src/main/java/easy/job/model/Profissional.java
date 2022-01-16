package easy.job.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profissional {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String profissao;
	private String email;
	private String biografia;
	@Column(name = "path_curriculo")
	private String pathCurriculo;
	public String getPathCurriculo() {
		return pathCurriculo;
	}
	public void setPathCurriculo(String pathCurriculo) {
		this.pathCurriculo = pathCurriculo;
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
