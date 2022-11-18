package implementation;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.PedidoDAO;
import interfaces.PedidoInterface;

@Service
public class PedidoServiceImpl implements PedidoInterface {
	
	// Atributos
	private DataSource dataSource;

	// Getters y Setters
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// Métodos
	
	/**
	 * método tipo select para obtener todos los objetos de tipo PedidoDAO de la tabla pedido de la BBDD
	 */
	@Override
	@Autowired
	public ArrayList<PedidoDAO> selectPedidos() {

		System.out.println("[INFO] Entrando en PedidoServiceImpl");
		String sql = "SELECT * FROM \"public\".\"pedido\"";
		ArrayList<PedidoDAO> listaPedidos = new ArrayList<PedidoDAO>();
		
		try {
			Connection conn = dataSource.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			if (!resultSet.next()) {
				System.out.println("[INFO] -- La lista está vacía");
				return null;
			}

			while (resultSet.next()) {
				PedidoDAO pedido = new PedidoDAO();
				pedido.setPedidoId(resultSet.getInt("pedidoId"));
				pedido.setCodPedido(resultSet.getString("codPedido"));
				listaPedidos.add(pedido);
			}
			
			System.out.println("[INFO] -- Saliendo de PedidoServiceImpl.selectPedidos()");
			return listaPedidos;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[ERROR] -- PedidoServiceImpl.selectEverything -- " + e.toString());
		}
		
		System.out.println("[INFO] -- Saliendo de PedidoServiceImpl.selectPedidos()");
		return null;
	}

	/**
	 * método tipo insert para añadir un objeto del tipo PedidoDAO a la tabla pedido de la BBDD
	 */
	@Override
	@Autowired
	public void insertPedido(String codPedido) {
		
		System.out.println("[INFO] -- Entrando en PedidoServiceImpl.insertPedido()");
		System.out.println("\nIntroduzca un código de pedido para crear un pedido");
		
		try {
			Connection conn = dataSource.getConnection();
			
			// Realizamos el insert
			Statement statement = conn.createStatement();

			String sql = "INSERT INTO \"public\".\"pedido\" VALUES(DEFAULT, \' " + codPedido + "\');";
			System.out.println(sql);
			
			statement.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println("[ERROR] -- PedidoServiceImpl.insertPedido() -- " + e.toString());
			e.printStackTrace();
		}
		
		System.out.println("[INFO] -- PedidoServiceImpl.insertPedido()");
	}


}
