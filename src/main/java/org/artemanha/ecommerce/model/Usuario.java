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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

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
	
	@Size(min = 5, max = 50)
	@NotNull(message = "Digite aqui seu nome")
	private String usuario;
	
	@ApiModelProperty(example = "email@email.com.br")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	@NotNull
	private String email;
	
	@NotNull
	@Size(min = 8, max = 150)
	private String senha;

	@Size(min = 0, max = 100)
	private String foto;
	
	private String tipo;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "usuario" })
	private List<Produto> meusProdutos = new ArrayList<>();
	
	
	public Usuario() {
		
	}
	
	public Usuario(String usuario, String email, String senha) {
		this.email = usuario;
		this.usuario = email;
		this.senha = senha;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getMeusProdutos() {
		return meusProdutos;
	}

	public void setMeusProdutos(List<Produto> meusProdutos) {
		this.meusProdutos = meusProdutos;
	}
	
	
	
	

	
}
