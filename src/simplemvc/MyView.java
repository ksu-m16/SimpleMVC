package simplemvc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.GridBagLayout;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class MyView extends JFrame {

	private IController controller ;

	public void setController(IController controller) {
		this.controller = controller;
	}

	private JPanel contentPane;
	private JTextField jtfNumber;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					initialize();
					MyView.this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	public void initialize() {
		jtfNumber.setText(controller.getValue());
	}
	
	/**
	 * Create the frame.
	 */
	public MyView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 96);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		jtfNumber = new JTextField();		

		jtfNumber.getDocument().addDocumentListener(new DocumentListener() {			
			public void update() {
				if (controller.checkValue(jtfNumber.getText())) {
					jtfNumber.setBackground(Color.WHITE);
				} else {
					jtfNumber.setBackground(Color.RED);					
				}								
			}			
			@Override
			public void removeUpdate(DocumentEvent e) { update(); }			
			@Override
			public void insertUpdate(DocumentEvent e) { update(); }			
			@Override
			public void changedUpdate(DocumentEvent e) { update(); }
		});
		
		GridBagConstraints gbc_jtfNumber = new GridBagConstraints();
		gbc_jtfNumber.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNumber.gridx = 0;
		gbc_jtfNumber.gridy = 0;
		contentPane.add(jtfNumber, gbc_jtfNumber);
		jtfNumber.setColumns(10);
		
		JButton jbSet = new JButton("-_-");
		
		//SEE: action listener should be used here
		jbSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!controller.checkValue(jtfNumber.getText())) {
					JOptionPane.showMessageDialog(MyView.this, "Invalid number value/format");
					return;
				}
				controller.setValue(jtfNumber.getText());
			}
		});
		/*
		jbSet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.setValue(MyView.this.jtfNumber.getText());
			}
		});
		*/
		
		GridBagConstraints gbc_jbSet = new GridBagConstraints();
		gbc_jbSet.fill = GridBagConstraints.HORIZONTAL;
		gbc_jbSet.gridx = 0;
		gbc_jbSet.gridy = 1;
		contentPane.add(jbSet, gbc_jbSet);
	}

}
