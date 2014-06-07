package logica;

public class Cliente extends ThreadSocket{

	public final static String MENSAJE_RECIBIDO="MENSAJE_RECIBIDO";
	
	private String nombre;
	private Libreria libreria;
	private Libro libro;


	public Cliente(String ip, int puerto) {
		super(ip, puerto);
//		System.out.println(recibirMensaje());
//		enviarMensaje("hola Servidor");
		this.pedirLibro();
	}
	
	public void gestionarConexion() {
		String comando = recibirMensaje();
		if(comando.equals(EnumComandos.PETICION_LISTA_LIBROS.getNombreComando())){
			recibirLibreria();
			pedirLibro();
		}else if(comando.equals(EnumComandos.PETICION_IDENTIFICACION_DEL_LIBRO.getNombreComando())){
			identificacionLibro();
			enviarNombreLibro("");
		}else if(comando.equals(EnumComandos.PETICION_ENVIAR_LIBRO.getNombreComando())){
			facilitarLibro();
		}else if(comando.equals(EnumComandos.PETICION_RECIBIR_LIBRO.getNombreComando())){
			recibirLibro();
		}
	}
	public void pedirLibro(){
		enviarMensaje(EnumComandos.PETICION_LIBRO.getNombreComando());
	}
	public void identificacionLibro(){
		enviarMensaje(EnumComandos.IDENTIFICACION_DEL_LIBRO.getNombreComando());
	}
	
	public void facilitarLibro(){
		enviarMensaje(EnumComandos.FACILITAR_LIBRO.getNombreComando());
	}
	
	public void enviarNombreLibro(String id){
		enviarMensaje(id);
	}
	
	public void recibirLibro(){
		libro = (Libro) recibirObjeto();
	}
	public void recibirLibreria(){
		libreria = (Libreria) recibirObjeto();		
	}
}
