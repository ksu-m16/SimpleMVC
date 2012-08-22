package simplemvc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTextField;

public class MyView extends JFrame {

	private IController controller = new MyController();
	private IModel model = new MyModel();
	
	public IController getController() {
		return controller;
	}

	public void setController(IController controller) {
		this.controller = controller;
//		this.model = this.controller.getModel();
	}

	private JPanel contentPane;
	private JTextField txtNumber;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyView frame = new MyView();
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
	public MyView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnRead = new JButton("Set!");
		btnRead.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					model.setNumber(Integer.parseInt(MyView.this.txtNumber.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		txtNumber = new JTextField();
		try {
			txtNumber.setText(String.valueOf(model.getNumber()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_txtNumber = new GridBagConstraints();
		gbc_txtNumber.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumber.gridx = 5;
		gbc_txtNumber.gridy = 3;
		contentPane.add(txtNumber, gbc_txtNumber);
		txtNumber.setColumns(10);
		GridBagConstraints gbc_btnRead = new GridBagConstraints();
		gbc_btnRead.gridheight = 3;
		gbc_btnRead.gridwidth = 3;
		gbc_btnRead.insets = new Insets(0, 0, 0, 5);
		gbc_btnRead.gridx = 4;
		gbc_btnRead.gridy = 4;
		contentPane.add(btnRead, gbc_btnRead);
	}

}
