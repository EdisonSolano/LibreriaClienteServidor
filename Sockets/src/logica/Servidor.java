package logica;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor implements Runnable {

	public final static int PUERTO = 400;
	public boolean finalizado;
	private Socket socket;
	private ServerSocket socketServidor;
	private ArrayList<Conexion> listaConexion;
	private Thread hiloServidor;
	private Libreria libreria;

	public Servidor() {
		socket = null;
		this.inicializarAtributos();
	}

	public void inicializarAtributos() {
		hiloServidor = new Thread(this);
		listaConexion = new ArrayList<Conexion>();
		try {
			socketServidor = new ServerSocket(PUERTO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void iniciar() {
		hiloServidor.start();
	}

	public synchronized void detener() {
		finalizado = true;
		this.notify();
	}

	public void run() {
		while (!finalizado) {
			try {
				socket = socketServidor.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listaConexion.add(new Conexion(socket, libreria));
			System.out.println("Bienvenido Cliente N° " + listaConexion.size());
			synchronized (this) {
				if (finalizado) {
					break;
				}
			}
		}
	}
}
