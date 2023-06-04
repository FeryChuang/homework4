package UI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import prog.order;
import prog.product;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class add extends JFrame {

	private JPanel contentPane;
	ArrayList<product> products;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField ID;
	ArrayList<order> orders;
	private JTable table;
	DefaultTableModel modelP;
	private JTable table_1;
	DefaultTableModel modelO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add frame = new add();
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
	public add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 414, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 80, 414, 571);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 10, 394, 551);
		panel_2.add(tabbedPane_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.addTab("New tab", null, tabbedPane, null);
		
		JPanel Products = new JPanel();
		tabbedPane.addTab("進貨", null, Products, null);
		Products.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(32, 362, 80, 25);
		Products.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(133, 362, 60, 25);
		Products.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(219, 362, 60, 25);
		Products.add(textField_3);
		textField_3.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(307, 362, 40, 25);
		Products.add(spinner);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 30, 320, 280);
		Products.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		modelP =new DefaultTableModel();
		Object[] columnP= {"商品名稱","進貨價","出售價","庫存"};
		Object[] rowP=new Object[4];
		modelP.setColumnIdentifiers(columnP);
		table.setModel(modelP);
		
		JButton btnNewButton = new JButton("進貨");
		btnNewButton.setBounds(36, 414, 80, 30);
		Products.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setBounds(152, 414, 80, 30);
		Products.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.setBounds(268, 414, 80, 30);
		Products.add(btnNewButton_2);
		
		////////////////
		
		JPanel Orders = new JPanel();
		tabbedPane.addTab("銷售", null, Orders, null);
		Orders.setLayout(null);
		
		ID = new JTextField();
		ID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				orders.add(new order(ID.getText()));
			}
		});
		ID.setBounds(61, 397, 96, 21);
		Orders.add(ID);
		ID.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(32, 30, 320, 280);
		Orders.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		modelO =new DefaultTableModel();
		Object[] columnO= {"會員ID","訂購內容","會員資格","付款方式","總金額"};
		Object[] rowO=new Object[5];
		modelO.setColumnIdentifiers(columnO);
		table_1.setModel(modelO);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("New tab", null, panel_1, null);
		
		
	}
}
