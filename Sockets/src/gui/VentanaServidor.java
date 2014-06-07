package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

public class VentanaServidor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar jMenuBar;
	private JMenu jMenuArchivo;
	private JMenu jMenuAcercaDe;
	private JMenuItem jMenuItemReferencia;
	private JMenuItem jMenuItem1;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem4;
	private JToolBar jToolBar;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private Cursor cursosBoton;
	private JTabbedPane jTabbedPane;
	private PanelPestanaServidor pestanaServidor;
	private PanelPestanaLibreria pestanaLibreria;
	
	public VentanaServidor() {
		setTitle("Proyecto Sockets");
		setSize(800, 525);
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(new Color(33,185,196));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.inicializarJMenu();
		this.inicializarJToolBar();
		this.inicializarJTabbetPane();
	}

	public void inicializarJMenu() {
		jMenuBar = new JMenuBar();
		jMenuArchivo = new JMenu("Archivo");
		jMenuAcercaDe = new JMenu("Acerca de");
		jMenuItem1 = new JMenuItem("Item1");
		jMenuItem2 = new JMenuItem("Item2");
		jMenuItem3 = new JMenuItem("Item3");
		jMenuItem4 = new JMenuItem("Item4");
		jMenuItemReferencia = new JMenuItem("Referencia");
//		setActionCommand
//		addActionListenr
		jMenuArchivo.add(jMenuItem1);
		jMenuArchivo.add(jMenuItem2);
		jMenuArchivo.add(jMenuItem3);
		jMenuArchivo.add(jMenuItem4);
		jMenuAcercaDe.add(jMenuItemReferencia);
		jMenuBar.add(jMenuArchivo);
		jMenuBar.add(jMenuAcercaDe);
		setJMenuBar(jMenuBar);
	}

	public void inicializarJToolBar() {
		jToolBar = new JToolBar();
		jButton1 = new JButton(createImageIcon(
				"/img/.png", "Editar"));
		jButton2 = new JButton(createImageIcon(
				"/img/.png", "Editar"));
		jButton3 = new JButton(createImageIcon(
				"/img/.png", "Editar"));
		jButton4 = new JButton(createImageIcon(
				"/img/.png", "Editar"));
		jButton1.setToolTipText("Accion1");
		jButton2.setToolTipText("Accion2");
		jButton3.setToolTipText("Accion3");
		jButton4.setToolTipText("Accion4");
		this.jButton1.setCursor(cursosBoton);
		this.jButton2.setCursor(cursosBoton);
		this.jButton3.setCursor(cursosBoton);
		this.jButton4.setCursor(cursosBoton);
//		setActionCommand
//		addActionlistener
		jToolBar.add(jButton1);
		jToolBar.add(jButton2);
		jToolBar.add(jButton3);
		jToolBar.add(jButton4);
		add(jToolBar, BorderLayout.PAGE_START);
	}

	
	public void inicializarJTabbetPane() {
		jTabbedPane = new JTabbedPane();
		jTabbedPane.addTab("Conexiones",
				createImageIcon("/img/conexion.png", "Editar"),
				pestanaServidor, "Does nothing");
		jTabbedPane.addTab("Libreria",
				createImageIcon("/img/libreria.png", "Editar"),
				pestanaLibreria, "Does nothing");
		add(jTabbedPane, BorderLayout.CENTER);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public static void main(String[] args) {
		VentanaServidor servidor = new VentanaServidor();
		servidor.setVisible(true);
	}
}
