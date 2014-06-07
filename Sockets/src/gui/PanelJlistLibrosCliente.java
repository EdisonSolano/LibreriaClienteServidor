package gui;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;

import logica.Libreria;
import logica.Libro;

public class PanelJlistLibrosCliente extends JPanel{

	private JList<Libro> listaLibros;
	
	public PanelJlistLibrosCliente(ArrayList<Libro> libreria) {
		setLayout(new FlowLayout());
		listaLibros = new JList<Libro>();
		add(listaLibros);
	}
}
