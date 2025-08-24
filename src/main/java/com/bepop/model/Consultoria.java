package com.bepop.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "consultorias")
public class Consultoria {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_empresa", nullable = false)
	private String nomeEmpresa;
	
	@Column(name = "cnpj", nullable = false)
	private String cnpj;
	
	
	@Column(name = "data", nullable = false)
	private Date data;
	
	
	@Column(name= "descricao")
	private String descricao;
	

	public Consultoria() {
		
	}
	
	public Consultoria(String nomeEmpresa, String cnpj, Date data) {
		this.nomeEmpresa = nomeEmpresa;
		this.cnpj = cnpj;
		this.data = data;
		
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	
	public Date getData() {
		return data;
	}

	public String getDataString() {

		return this.data.toString();
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
