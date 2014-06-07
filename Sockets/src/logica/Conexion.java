package logica;

import java.net.Socket;

public class Conexion extends ThreadSocket {

	public final static String RECIBIR_NUMERO = "RECIBIR_NUMERO";
	private Libreria libreria;
	private Libro libro;
	

	public Conexion(Socket socket,Libreria libreria) {
		super(socket);
		// enviarMensaje("Hola Cliente");
		// System.out.println(recibirMensaje());
		enviarMensaje(EnumComandos.PETICION_LISTA_LIBROS.getNombreComando());
		enviarObjeto(libreria);
	}

	@Override
	public void gestionarConexion() {
		String comando = recibirMensaje();
		if (comando.equals(EnumComandos.PETICION_LIBRO)) {
			pedirIdentificacion();
		}else if (comando.equals(EnumComandos.IDENTIFICACION_DEL_LIBRO)) {
			buscarLibro();
		}else if(comando.equals(EnumComandos.FACILITAR_LIBRO)){
			enviarLibro();
		}
	}
	
	public void pedirIdentificacion(){
		enviarMensaje(EnumComandos.PETICION_IDENTIFICACION_DEL_LIBRO.getNombreComando());
	}
	
	public void buscarLibro(){
		String id="";
		id = recibirMensaje();
		for (Libro libro : libreria ) {
			if(id.equals(libro.getNombre())){
				this.libro = libro;
			}
		}
	}
	
	public void enviarLibro(){
		enviarMensaje(EnumComandos.PETICION_RECIBIR_LIBRO.getNombreComando());
		enviarObjeto(libro);
	}
}
