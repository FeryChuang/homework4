package homework4.UI;

import java.awt.EventQueue;
import javax.swing.text.JTextComponent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.ImageIcon;
import java.awt.Color;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JPasswordField PW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 414, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 85, 414, 566);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(208, 80, 45, 30);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(208, 110, 45, 30);
		panel_1.add(lblNewLabel_1);
		
		ID = new JTextField();
		ID.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		ID.setForeground(new Color(90, 130, 212));
		ID.setBackground(new Color(240, 240, 240));
		ID.setBounds(245, 84, 80, 20);
		panel_1.add(ID);
		ID.setColumns(10);
		
		PW = new JPasswordField();
		PW.setForeground(new Color(90, 130, 212));
		PW.setBackground(new Color(240, 240, 240));
		PW.setBounds(245, 118, 80, 20);
		panel_1.add(PW);
		
		JLabel forgetButton = new JLabel("");
		forgetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				info f1=new info();
				f1.setVisible(true);
			}
		});
		forgetButton.setIcon(new ImageIcon(login.class.getResource("/homework4/img/forget.jpg")));
		forgetButton.setBounds(177, 150, 80, 30);
		panel_1.add(forgetButton);
		
		

		JLabel signButton = new JLabel("");
		signButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] password = PW.getPassword();
				char[] correctPass = new char[] {'0', '0', '0', '0'};
				boolean PWC=true; 
				if (Arrays.equals(password, correctPass)) {
					PWC=true;
				} else {
					PWC=false;
				}
				
				if(ID.getText().equals("bb")&& PWC==true){
					cart C1=new cart();
					C1.setVisible(true);
					dispose();
				}else {
					info f1=new info();
					f1.setVisible(true);
				}
			}
		});
		signButton.setIcon(new ImageIcon(login.class.getResource("/homework4/img/signIn.jpg")));
		signButton.setBounds(278, 150, 80, 30);
		panel_1.add(signButton);
		

		JLabel EXITbutton = new JLabel("");
		EXITbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		EXITbutton.setIcon(new ImageIcon(login.class.getResource("/homework4/img/exit.jpg")));
		EXITbutton.setBounds(314, 516, 80, 30);
		panel_1.add(EXITbutton);
		
		JLabel login_panel = new JLabel("");
		login_panel.setIcon(new ImageIcon(login.class.getResource("/homework4/img/login.jpg")));
		login_panel.setBounds(152, 32, 230, 170);
		panel_1.add(login_panel);
		
		JLabel cat = new JLabel("");
		cat.setIcon(new ImageIcon(login.class.getResource("/homework4/img/catCart3.jpg")));
		cat.setBounds(0, 0, 414, 566);
		panel_1.add(cat);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(login.class.getResource("/homework4/img/shop logo-out.jpg")));
		lblNewLabel_2.setBounds(0, 0, 414, 60);
		panel.add(lblNewLabel_2);
		
		
		
	}
}
