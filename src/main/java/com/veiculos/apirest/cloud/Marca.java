package com.veiculos.apirest.cloud;

public class Marca {

private String nome;
private String codigo;

public Marca() {
	};
public Marca(String nome, String codigo) {
	super();
	this.nome = nome;
	this.codigo = codigo;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Marca other = (Marca) obj;
	if (codigo == null) {
		if (other.codigo != null)
			return false;
	} else if (!codigo.equals(other.codigo))
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	return true;
}	
}