package pakete1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class interfazeaProba extends JFrame {
	//karrax tontoooo!!!!!!

	private JPanel label1;
	private JTextField testua1;
	private ButtonGroup talde;
	private JRadioButton rdbtnGizona;
	private JRadioButton rdbtnEmakumea;
	private JComboBox combUrteak;
	private JTextArea textArea;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazeaProba frame = new interfazeaProba();
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
	public interfazeaProba() {
		
		setTitle("Tituloa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		label1 = new JPanel();
		label1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(label1);
		label1.setLayout(null);
		
		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setBounds(27, 5, 46, 37);
		label1.add(lblIzena);
		
		testua1 = new JTextField();
		testua1.setBounds(107, 9, 329, 30);
		label1.add(testua1);
		testua1.setColumns(10);
		
		JLabel lblSexua = new JLabel("Sexua");
		lblSexua.setBounds(27, 69, 70, 15);
		label1.add(lblSexua);
		
		rdbtnEmakumea = new JRadioButton("Emakumea");
		rdbtnEmakumea.setBounds(92, 81, 107, 23);
		label1.add(rdbtnEmakumea);
		
		rdbtnGizona = new JRadioButton("Gizona");
		rdbtnGizona.setBounds(92, 108, 81, 23);
		label1.add(rdbtnGizona);
		
		talde= new ButtonGroup();
		talde.add(rdbtnEmakumea);
		talde.add(rdbtnGizona);
		
		
		JLabel lblJaiotzeUrtea = new JLabel("Jaiotze Urtea");
		lblJaiotzeUrtea.setBounds(27, 151, 107, 30);
		label1.add(lblJaiotzeUrtea);
		
		combUrteak = new JComboBox();
		combUrteak.setBounds(151, 154, 92, 24);
		label1.add(combUrteak);
		
		for (int i=1900; i<2010; i++)
		combUrteak.addItem(i);
		
		
		JButton btnDatuakBidali = new JButton("Datuak Bidali");
		btnDatuakBidali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (testua1.getText().equals("")){
					textArea.setText("Sartu Izena");
					Color kolorea = new Color (255,0,0);
					testua1.setBackground(kolorea);
				}else{
			
				System.out.println("Bokotoia sakatu dut!!");
				
				String testu = testua1.getText();
				Integer urte = (Integer) combUrteak.getSelectedItem();
				
				ButtonModel bm = talde.getSelection();
				
			    String sexua = "";
			    
			    if( bm == rdbtnEmakumea.getModel())
			    	sexua = rdbtnEmakumea.getText();
			    else
			    	sexua = rdbtnGizona.getText();
			    textArea.setText("Izena: " + testu + "\nSexua:" + sexua + "\nUrtea:" + urte);
				
				}
			    
		
			}
		});
		btnDatuakBidali.setBounds(285, 154, 151, 25);
		label1.add(btnDatuakBidali);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(27, 193, 409, 103);
		label1.add(textArea);
	}
}
