package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import logica.Libro;

public class PanelJlistBiblioteca extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel modeloLista;
	private JList<Libro> listaLibros;
	private JButton buttonDescargar;
	
	public PanelJlistBiblioteca(ArrayList<Libro> libreria) {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200,getHeight()));
		modeloLista = new DefaultListModel<>();
		listaLibros = new JList<Libro>(modeloLista);
		listaLibros.setPreferredSize(new Dimension(200,getHeight()));
		for (Libro libro : libreria) {
			modeloLista.addElement(libro.getNombre());
		}
		buttonDescargar = new JButton("DESCARGAR");
		add(buttonDescargar, BorderLayout.SOUTH);
		add(listaLibros, BorderLayout.CENTER);
	}

	public JButton getButtonDescargar() {
		return buttonDescargar;
	}

	public void setButtonDescargar(JButton buttonDescargar) {
		this.buttonDescargar = buttonDescargar;
	}
	
}
