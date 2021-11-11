package org.artemanha.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
*Classe utilizada como entidade para usuario no banco de dados
*Esta Classe é responsável por definir os atributos da API/colunas do banco de dados MYSQL com suas respectivas anotations.
*As anotations são resposnsáveis pela definição do comportamento de cada atributo.
*
*@since 1.0
*@author Grupo Radia Perlman #3
*/
@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String nomeCompleto;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String email;
	
	@NotNull
	@Size(min = 8, max = 15)
	private String senha;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_completo() {
		return nomeCompleto;
	}

	public void setNome_completo(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
