package org.artemanha.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
*Classe utilizada como entidade para produto no banco de dados
*Esta Classe é responsável por definir os atributos da API/colunas do banco de dados MYSQL com suas respectivas anotations.
*As anotations são resposnsáveis pela definição do comportamento de cada atributo.
*
*@since 1.0
*@author Grupo Radia Perlman #3
*/
@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String nome;
		
	@NotNull
	private double preco;
	
	@NotNull
	private int quantidade;
	
	@NotNull
	@Size(min = 0, max = 200)
	private String imagemProduto;
	
	@NotNull
	@Size(min = 0, max = 200)
	private String avalicaoProduto;
	
	public String getImagemProduto() {
		return imagemProduto;
	}

	public void setImagemProduto(String imagemProduto) {
		this.imagemProduto = imagemProduto;
	}

	public String getAvalicaoProduto() {
		return avalicaoProduto;
	}

	public void setAvalicaoProduto(String avalicaoProduto) {
		this.avalicaoProduto = avalicaoProduto;
	}

	@OneToMany(mappedBy ="produto", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("produto")
	private List <Categoria> categoria = new ArrayList<>();
	
	@OneToMany(mappedBy ="usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List <Usuario> usuario = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	
	
	
}
