package interfaces;

import java.util.ArrayList;

import javax.sql.DataSource;

import DAO.PedidoDAO;

public interface PedidoInterface {

	// Método que realizara una consulta de todos los datos de la tabla Pedido
	public ArrayList<PedidoDAO> selectPedidos();

	// Metodo que inserta un pedido con los parametros indicados
	public void insertPedido(String codPedido);
}
