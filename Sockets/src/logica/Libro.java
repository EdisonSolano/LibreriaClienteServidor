package logica;

import java.io.Serializable;

public class Libro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8124180746421300862L;
	private String nombre;
	private String autor;
	private long ISBN;
	private String cubierta;

	public Libro(String nombre, String autor, long iSBN, String cubierta) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		ISBN = iSBN;
		this.cubierta = cubierta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	public String getCubierta() {
		return cubierta;
	}
	public void setCubierta(String cubierta) {
		this.cubierta = cubierta;
	}
}
