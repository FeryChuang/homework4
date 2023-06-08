package homework4.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import javax.swing.JLabel;


public class checkOut extends JFrame {

	private JPanel contentPane;
	static JTextArea output;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkOut frame = new checkOut();
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
	public checkOut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(475, 150, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		output = new JTextArea();
		output.setBounds(42, 10, 300, 370);
		contentPane.add(output);
		
		//output.displayImage();
		
		JLabel printCheckOut = new JLabel("列印明細");
		printCheckOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					output.print();
					}catch(PrinterException ex) {
						ex.printStackTrace();
					}
			}
		});
		printCheckOut.setIcon(new ImageIcon(checkOut.class.getResource("/homework4/img/print.jpg")));
		printCheckOut.setBounds(81, 410, 80, 30);
		contentPane.add(printCheckOut);
		
		JLabel lblNewLabel = new JLabel("確認關閉");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(checkOut.class.getResource("/homework4/img/OK.jpg")));
		lblNewLabel.setBounds(243, 410, 80, 30);
		contentPane.add(lblNewLabel);
	}
}
