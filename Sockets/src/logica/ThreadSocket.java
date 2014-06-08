package logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadSocket implements Runnable {
	public boolean pausado;
	public boolean finalizado;
	private DataInputStream canalEntrada;
	private DataOutputStream canalSalida;
	private Socket socket;
	private Thread hilo;
	private ObjectInputStream canalEntradaObjeto;
	private ObjectOutputStream canalSalidaObjeto;

	public ThreadSocket(String ip, int puerto) {
//		try {
//			socket = new Socket(ip, puerto);
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		this.inicializarAtributos();
	}

	public ThreadSocket(Socket socket) {
		this.socket = socket;
		this.inicializarAtributos();
	}

	public void inicializarAtributos() {
		finalizado = false;
		pausado = false;
		hilo = new Thread(this);
		try {
			canalEntrada = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			canalSalida = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			canalEntradaObjeto = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			canalSalidaObjeto = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void iniciar() {
		hilo.start();
	}

	public synchronized void detener() {
		finalizado = true;
		this.notify();
	}

	public void recibirLibros(Libreria libreria){
		
	}
//	public Libro recibirLibro(){
//		return null;
//		
//	}
	
	public void enviarObjeto(Object object){
		try {
			canalSalidaObjeto.writeObject(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object recibirObjeto(){
		Object objeto = new Object();
			try {
				objeto = canalEntradaObjeto.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return objeto;
	}
	
	public String recibirMensaje(){
		String mensaje="";
		try {
			mensaje = canalEntrada.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mensaje;
	}
	
	public void enviarMensaje(String mensaje){

		try {
		canalSalida.writeUTF(mensaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gestionarConexion() {

	}
	
	public void cerrarConexion(){
		try {
			canalEntrada.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			canalSalida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.detener();
	}

	public void run() {
		while (!finalizado) {
			gestionarConexion();
			synchronized (this) {
				if (finalizado) {
					break;
				}
			}
		}this.iniciar();
	}
}
