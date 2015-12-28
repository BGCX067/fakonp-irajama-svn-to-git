package praktika1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class interfazePraktika1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ButtonGroup taldea;
	private JRadioButton rdbtnEmakumea;
	private JRadioButton rdbtnGizona;	
	private JComboBox comboBox;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazePraktika1 frame = new interfazePraktika1();
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
	public interfazePraktika1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Titulua");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(12, 12, 70, 15);
		contentPane.add(lblIzena);
		
		JLabel lblSexua = new JLabel("Sexua:");
		lblSexua.setBounds(12, 63, 70, 15);
		contentPane.add(lblSexua);
		
		JLabel lblJaiotzeUrtea = new JLabel("Jaiotze urtea:");
		lblJaiotzeUrtea.setBounds(12, 138, 110, 15);
		contentPane.add(lblJaiotzeUrtea);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
		
			Color zuria= Color.white;
			public void mouseClicked(MouseEvent e) {
				textField.setBackground(zuria);
				textArea.setText("");
			}
		});
		textField.setBounds(100, 10, 281, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		rdbtnEmakumea = new JRadioButton("Emakumea");
		rdbtnEmakumea.setBounds(83, 59, 149, 23);
		contentPane.add(rdbtnEmakumea);
		
		rdbtnGizona = new JRadioButton("Gizona");
		rdbtnGizona.setBounds(83, 86, 149, 23);
		contentPane.add(rdbtnGizona);
		
		taldea = new ButtonGroup();
		taldea.add(rdbtnEmakumea);
		taldea.add(rdbtnGizona);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(140, 133, 92, 24);
		contentPane.add(comboBox);
		
		for(int i=1900; i<2010; i++)
		comboBox.addItem(i);
		
		JButton btnDatuakBidali = new JButton("Datuak bidali");
		btnDatuakBidali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String izena= textField.getText();
				Color gorri= new Color(255,0,0);
				if ("".equals(izena)){
					textArea.setText("Sartu zure izena");
					textField.setBackground(gorri);
					
				}
				else{
				int urtea= (Integer) comboBox.getSelectedItem();
				ButtonModel bm=taldea.getSelection();
				String sexua="";
				if (bm == rdbtnEmakumea.getModel())
					sexua = rdbtnEmakumea.getText();
				else 
					sexua =rdbtnGizona.getText();
				textArea.setText("Izena"+ izena + "\nSexua"+ sexua+"\nUrtea" +urtea+ "\n Bukatu duzu!!!");
			}
			}
		});
		btnDatuakBidali.setBounds(264, 133, 144, 25);
		
		contentPane.add(btnDatuakBidali);
		
        textArea = new JTextArea();
		textArea.setBounds(33, 169, 386, 87);
		contentPane.add(textArea);
	}
}
