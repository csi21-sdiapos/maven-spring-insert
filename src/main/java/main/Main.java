package main;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.PedidoDAO;
import implementation.PedidoServiceImpl;

public class Main {
	
	// para pedir los datos al usuario por consola para probar el insert
	final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// con los objetos registry y factory, activamos el archivo hibernate.cfg.xml para crear automaáticamente las tablas en la BBDD cuando ejecutamos el proyecto
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		/***************************************************************************************************************************/
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		PedidoServiceImpl pedido = (PedidoServiceImpl) applicationContext.getBean("pedido");

		System.out.println("\nIntroduzca un código de pedido para crear un nuevo pedido");
		String codPedido = sc.nextLine();
		
		pedido.insertPedido(codPedido);
		ArrayList<PedidoDAO> listaPedidos = pedido.selectPedidos();

		for (PedidoDAO p : listaPedidos)
			System.out.println(p.getPedidoId() + " - " + p.getCodPedido());
	}

}
