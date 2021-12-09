package org.artemanha.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe utilizada como entidade para categoria no banco de dados Esta Classe é
 * responsável por definir os atributos da API/colunas do banco de dados MYSQL
 * com suas respectivas anotations. As anotations são resposnsáveis pela
 * definição do comportamento de cada atributo.
 *
 * @since 1.0
 * @author Grupo Radia Perlman #3
 */
@Entity
@Table(name = "tb_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String vestuario;
	
	private String alimentacao;
	
	private String cosmetico;
	
	private String utilitarios;

	
	private String formaPagamento;

	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private Produto produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVestuario() {
		return vestuario;
	}

	public void setVestuario(String vestuario) {
		this.vestuario = vestuario;
	}

	public String getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(String alimentacao) {
		this.alimentacao = alimentacao;
	}

	public String getCosmetico() {
		return cosmetico;
	}

	public void setCosmetico(String cosmetico) {
		this.cosmetico = cosmetico;
	}

	public String getUtilitarios() {
		return utilitarios;
	}

	public void setUtilitarios(String utilitarios) {
		this.utilitarios = utilitarios;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	
}
