package br.org.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //Sinônimo de entidade = tabela
@Table(name = "tb_postagem") //Cria a tabela postagem
public class PostagemModel {
	
	@Id //Declara essa variavel como atributo ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Declara auto-incremento
	private long id;
	
	@NotNull //Não pode valor nulo
	@Size(min = 5, max = 100) //Estabelecendo tamanho minimo e maximo
	private String titulo;
	
	@NotNull //Não pode valor nulo
	@Size(min = 10, max = 500) //Estabelecendo tamanho minimo e maximo
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP) //Estabelecendo o atributo de data
	private Date date = new java.sql.Date(System.currentTimeMillis()); //Criando a variavel (POO) do tipo data
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaModel tema;

	//Encapsulamento
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public TemaModel getTema() {
		return tema;
	}

	public void setTema(TemaModel tema) {
		this.tema = tema;
	}
}