package DAO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity defines which objects should be persisted in the database
@Entity
//Defines the name of the table created for the entity
@Table(name = "Pedido")
public class PedidoDAO implements Serializable { // clase bean

	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	@Id
	@Column(name = "pedidoId", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pedidoId;
	
	@Column(name = "codPedido", length = 100, nullable = true)
	private String codPedido;
	
	
	// CONSTRUCTORES
	
	// constructor vacío
	public PedidoDAO() {
		super();
	}

		
	// GETTERS Y SETTERS
	public int getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
