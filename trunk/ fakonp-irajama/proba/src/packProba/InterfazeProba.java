package packProba;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class InterfazeProba extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ButtonGroup taldea;
	private JLabel label1;
	private JLabel label2; 
	private JLabel label3; 
	private JRadioButton rdbtnHombre; 
	private JRadioButton rdbtnMujer; 
	private JComboBox comboBox; 
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazeProba frame = new InterfazeProba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazeProba() {
	setTitle("Tituloa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label1 = new JLabel("Izena:");
		label1.setBounds(22, 9, 139, 36);
		contentPane.add(label1);
		
		JButton btnBotoiaSakatu = new JButton("Datuak bidali");
		btnBotoiaSakatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String izena= textField.getText();
			Integer urtea=(Integer)comboBox.getSelectedItem();
			ButtonModel bm= taldea.getSelection();
			String sexua="";
			if (bm==rdbtnMujer.getModel())
				sexua=rdbtnMujer.getText();
			else sexua= rdbtnHombre.getText();
			textArea.setText("Zure datuak heldu dira:");
			textArea.setText("Izena: " +izena + "\nSexua: "+ sexua + "\nUrtea: "+ urtea);

			}
		});
		btnBotoiaSakatu.setBounds(303, 132, 133, 25);
		contentPane.add(btnBotoiaSakatu);
		
		label2 = new JLabel("Sexua:");
		label2.setBounds(12, 57, 139, 36);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Jaiotze urtea:");
		label3.setBounds(22, 126, 139, 36);
		contentPane.add(label3);
	
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(80, 53, 149, 23);
		contentPane.add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(80, 87, 149, 23);
		contentPane.add(rdbtnMujer);
		
		//VIPVIPVIPVIPVIPVIPVIPVIPVIPVIPVIP (talde horretatik bakarrik bakarra aukeratu ahal izateko)
		taldea= new ButtonGroup();
		taldea.add(rdbtnMujer);
		taldea.add(rdbtnHombre);
		
		textField = new JTextField();
		textField.setBounds(99, 18, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(129, 132, 114, 25);
		contentPane.add(comboBox);
		//Combobox-ari balioak gehitzeko
		for(int i=1900; i<2010; i++)
		comboBox.addItem(i);
		
		textArea = new JTextArea();
		textArea.setBounds(71, 208, 302, 99);
		contentPane.add(textArea);
	
	}
}
