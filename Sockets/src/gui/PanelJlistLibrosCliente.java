package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.*;

import logica.Libreria;
import logica.Libro;

public class PanelJlistLibrosCliente extends PanelJlistBiblioteca{

	private DefaultListModel modeloLista;
	private JList<Libro> listaLibros;
	
	public PanelJlistLibrosCliente(ArrayList<Libro> libreria) {
		super(libreria);
		getButtonDescargar().setVisible(false);
	}
//	public PanelJlistLibrosCliente(ArrayList<Libro> libreria) {
//		setLayout(new BorderLayout());
//		setPreferredSize(new Dimension(200,getHeight()));
//		modeloLista = new DefaultListModel<>();
//		listaLibros = new JList<Libro>(modeloLista);
//		listaLibros.setPreferredSize(new Dimension(200,getHeight()));
//		for (Libro libro : libreria) {
//			modeloLista.addElement(libro.getNombre());
//		}
//		add(listaLibros, BorderLayout.CENTER);
//	}
}
