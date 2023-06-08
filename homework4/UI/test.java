package homework4.UI;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 10, 310, 191);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(test.class.getResource("/homework4/img/OK.jpg")));
		lblNewLabel.setBounds(10, 32, 80, 30);
		panel.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 72, 280, 109);
		panel.add(textArea);
		
		textArea.setText("1234456");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 try {
			            Graphics graphics = panel.getGraphics();
			            if (graphics != null) {
			                graphics.setColor(panel.getForeground());
			                panel.print(graphics);
			                graphics.dispose();
			            }
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(test.class.getResource("/homework4/img/export.jpg")));
		lblNewLabel_1.setBounds(259, 226, 80, 30);
		contentPane.add(lblNewLabel_1);
	}
}
