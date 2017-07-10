package br.unb.cic.imdb.negocio;

import java.time.LocalDate;
import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	private String username;
	
	@Column
	private String senha;
	
	@Column
	private String nome;
	
	@Column
	private LocalDate dataNasc;
	
	@Column
	private boolean gerencia;
	
	@OneToMany //(mappedBy = "usuario", targetEntity = Avaliacao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name = "avaliacoes")
	private List<Avaliacao> avaliacoes;
	
	public Usuario() { }
	
	public Usuario(String user, String senha, String nome, LocalDate dataNasc, boolean gerencia) {
		this.username = user;
		this.senha = senha;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.gerencia = gerencia;
	}

	public String getUser() {
		return username;
	}
	
	public void setUser(String user) {
		this.username = user;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public boolean isGerencia() {
		return gerencia;
	}

	public void setGerencia(boolean gerencia) {
		this.gerencia = gerencia;
	}
	
	public void addAvaliacao(Avaliacao avaliacao){
		avaliacoes.add(avaliacao);
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public Long getId() {
		return id;
	}
	
}
