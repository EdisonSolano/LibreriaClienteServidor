package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Libreria extends ArrayList<Libro> implements Serializable {

	private static final long serialVersionUID = 5337723239694208268L;
	private Libreria libreria;

	public Libro agregar(Libro libro) {
		add(libro);
		return libro;
	}

	public String mirarBiblioteca() {
		String datos = " ";
		for (Libro libro : libreria) {
			datos = libro.getNombre() + " " + libro.getISBN() + " "
					+ libro.getAutor() + " " + libro.getCubierta();
			System.out.println("---------");
		}
		return datos;
	}

	public Libreria getLibreria() {
		return libreria;
	}

	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}
	
}
