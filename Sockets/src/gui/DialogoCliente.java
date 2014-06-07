package gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoCliente extends JDialog {

	private JLabel lblIp;
	private JLabel lblPuerto;
	private JTextField txtIp;
	private JTextField txtPuerto;

	public DialogoCliente() {
		lblIp = new JLabel("ip");
		lblPuerto = new JLabel("Puerto");
		txtIp= new JTextField();
		txtPuerto= new JTextField();
	}
}
