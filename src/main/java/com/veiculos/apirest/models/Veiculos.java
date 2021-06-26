package com.veiculos.apirest.models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="TB_VEICULOS")
public class Veiculos implements Serializable {

			private static final long serialVersionUID = 1L;

			@Id
			@GeneratedValue(strategy=GenerationType.AUTO)
			private int id;	
			
			@Column(nullable=false)
			private String marca;
			
			@Column(nullable=false)
			private String modelo;
			
			@Column(nullable=false)
			private String ano;
			
			@Column(nullable=false)
			private Double preço;
			
		    @OneToOne
		    @JoinColumn(name="cpf", referencedColumnName="cpf", nullable=false)
		    private Usuario usuario;
		    
		    
		    
		    public Veiculos () {
		    	
		    }
		    
			public Veiculos(int id, String marca, String modelo, String ano, Double preço, Usuario usuario) {
				super();
				this.id = id;
				this.marca = marca;
				this.modelo = modelo;
				this.ano = ano;
				this.preço = preço;
				this.usuario = usuario;
					}
		
			 public Veiculos toEntity(Usuario usuario) {
					return new Veiculos(this.id, this.marca, this.modelo, this.ano,this.preço, usuario);
				}
			    
		    
			public Double getPreço() {
				return preço;
			}

			public void setPreço(Double preço) {
				this.preço = preço;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getMarca() {
				return marca;
			}

			public void setMarca(String marca) {
				this.marca = marca;
			}

			public String getModelo() {
				return modelo;
			}

			public void setModelo(String modelo) {
				this.modelo = modelo;
			}

			public String getAno() {
				return ano;
			}

			public void setAno(String ano) {
				this.ano = ano;
			}

			public Usuario getUsuario() {
				return usuario;
			}

			public void setUsuario(Usuario usuario) {
				this.usuario = usuario;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((ano == null) ? 0 : ano.hashCode());
				result = prime * result + id;
				result = prime * result + ((marca == null) ? 0 : marca.hashCode());
				result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
				result = prime * result + ((preço == null) ? 0 : preço.hashCode());
				result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
				Veiculos other = (Veiculos) obj;
				if (ano == null) {
					if (other.ano != null)
						return false;
				} else if (!ano.equals(other.ano))
					return false;
				if (id != other.id)
					return false;
				if (marca == null) {
					if (other.marca != null)
						return false;
				} else if (!marca.equals(other.marca))
					return false;
				if (modelo == null) {
					if (other.modelo != null)
						return false;
				} else if (!modelo.equals(other.modelo))
					return false;
				if (preço == null) {
					if (other.preço != null)
						return false;
				} else if (!preço.equals(other.preço))
					return false;
				if (usuario == null) {
					if (other.usuario != null)
						return false;
				} else if (!usuario.equals(other.usuario))
					return false;
				return true;
			}

			}


		

