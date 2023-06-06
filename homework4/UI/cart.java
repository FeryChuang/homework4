package homework4.UI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import homework4.prog.order;
import homework4.prog.product;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cart extends JFrame {

	private JPanel contentPane;
	ArrayList<product> products;
	private JTextField Name;
	private JTextField Cost;
	private JTextField Sale;
	ArrayList<order> orders;
	private JTable tableP;
	DefaultTableModel modelP;
	private JTable tableO;
	DefaultTableModel modelO;
	private JTable tableS;
	DefaultTableModel modelS;
	private JTable tableC;
	DefaultTableModel modelC;
	private JTextField ProductName;
	private JTextField ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cart frame = new cart();
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
	public cart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 120, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//宣告兩個陣列
		products = new ArrayList<product>();
		orders= new ArrayList<order>();
		
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
		
		//進貨的分頁
		JPanel Products = new JPanel();
		tabbedPane.addTab("進貨", null, Products, null);
		Products.setLayout(null);
		
		Name = new JTextField();
		Name.setBounds(32, 362, 80, 25);
		Products.add(Name);
		Name.setColumns(10);
		
		Cost = new JTextField();
		Cost.setBounds(133, 362, 60, 25);
		Products.add(Cost);
		Cost.setColumns(10);
		
		Sale = new JTextField();
		Sale.setBounds(219, 362, 60, 25);
		Products.add(Sale);
		Sale.setColumns(10);
		
		//顯示進貨商品的表格
		JSpinner Stock = new JSpinner();
		Stock.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		Stock.setBounds(307, 362, 40, 25);
		Products.add(Stock);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 30, 320, 280);
		Products.add(scrollPane);
		
		tableP = new JTable();
		tableP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tableP.getSelectedRow();
				Name.setText(modelP.getValueAt(i, 0).toString());
				Cost.setText(modelP.getValueAt(i, 1).toString());
				Sale.setText(modelP.getValueAt(i, 2).toString());
				Stock.setValue(modelP.getValueAt(i, 3));
			}
		});//上面是按了表格就會把所選資料顯示到對應欄位=為了可以修改
		//建立P表格的小精靈
		scrollPane.setViewportView(tableP);
		modelP =new DefaultTableModel();
		Object[] columnP= {"商品名稱","進貨價","出售價","庫存"};
		Object[] rowP=new Object[4];
		modelP.setColumnIdentifiers(columnP);
		tableP.setModel(modelP);
		
		
		JLabel lblNewLabel_2 = new JLabel("商品名稱");
		lblNewLabel_2.setBounds(32, 333, 80, 15);
		Products.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("進貨價");
		lblNewLabel_3.setBounds(135, 333, 46, 15);
		Products.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("出售價");
		lblNewLabel_4.setBounds(219, 333, 46, 15);
		Products.add(lblNewLabel_4);
				
		JLabel lblNewLabel_5 = new JLabel("進貨量");
		lblNewLabel_5.setBounds(301, 333, 46, 15);
		Products.add(lblNewLabel_5);
		
		
		
		
		///////////////////////////////
		//建立銷售業面
		JPanel Sales = new JPanel();
		tabbedPane.addTab("銷售", null, Sales, null);
		Sales.setLayout(null);
		
		ProductName = new JTextField();
		ProductName.setEditable(false);
		ProductName.setBounds(31, 231, 96, 21);
		Sales.add(ProductName);
		ProductName.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 71, 364, 146);
		Sales.add(scrollPane_2);
		
		tableS = new JTable();
		tableS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tableS.getSelectedRow();
				ProductName.setText(modelS.getValueAt(i, 0).toString());			
			}
		});//上面是按了表格就會把所選資料顯示到對應欄位=為了可以修改
		//建立S表格的小精靈
		scrollPane_2.setViewportView(tableS);
		modelS =new DefaultTableModel();
		Object[] columnS= {"商品名稱","售價","剩餘數量"};
		Object[] rowS=new Object[3];
		modelS.setColumnIdentifiers(columnS);
		tableS.setModel(modelS);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 291, 364, 146);
		Sales.add(scrollPane_3);
		
		//建立C表格的小精靈
		tableC = new JTable();
		scrollPane_3.setViewportView(tableC);
		modelC =new DefaultTableModel();
		Object[] columnC= {"商品名稱","售價","購買數量","小計"};
		Object[] rowC=new Object[4];
		modelC.setColumnIdentifiers(columnC);
		tableC.setModel(modelC);
		
		
		
		JSpinner Amount = new JSpinner();
		Amount.setBounds(192, 230, 30, 22);
		Sales.add(Amount);
		
				
		JLabel lblNewLabel = new JLabel("架上商品");
		lblNewLabel.setBounds(10, 46, 87, 15);
		Sales.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("購物車");
		lblNewLabel_1.setBounds(10, 266, 87, 15);
		Sales.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("會員ID");
		lblNewLabel_6.setBounds(10, 13, 46, 15);
		Sales.add(lblNewLabel_6);
		
		ID = new JTextField();
		ID.setBounds(66, 10, 96, 21);
		Sales.add(ID);
		ID.setColumns(10);
		
		////////////////
		
		JPanel Orders = new JPanel();
		tabbedPane.addTab("訂單", null, Orders, null);
		Orders.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(32, 28, 320, 327);
		Orders.add(scrollPane_1);
		
		tableO = new JTable();
		scrollPane_1.setViewportView(tableO);
		
		modelO =new DefaultTableModel();
		Object[] columnO= {"會員ID","訂購內容","會員","總金額"};
		Object[] rowO=new Object[4];
		modelO.setColumnIdentifiers(columnO);
		tableO.setModel(modelO);
		
		//////////////////////////
		//按鈕們
		
		JButton btnNewButton_5 = new JButton("刪除訂單");
		btnNewButton_5.setBounds(252, 386, 100, 30);
		Orders.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("輸出表單");
		btnNewButton_6.setBounds(252, 430, 100, 30);
		Orders.add(btnNewButton_6);
		
		JButton btnNewButton = new JButton("進貨");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowP[0]=Name.getText();
				rowP[1]=Integer.parseInt(Cost.getText());
				rowP[2]=Integer.parseInt(Sale.getText());
				rowP[3]=Stock.getValue();
				modelP.addRow(rowP);
				rowS[0]=rowP[0];
				rowS[1]=rowP[2];
				rowS[2]=rowP[3];
				modelS.addRow(rowS);
				
				Name.setText("");
				Cost.setText("");
				Sale.setText("");
				Stock.setValue(0);
				JOptionPane.showMessageDialog(null, "上架成功");
				}
		});
		btnNewButton.setBounds(36, 414, 80, 30);
		Products.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tableP.getSelectedRow();
				if(i>=0) {
					modelP.setValueAt(Name.getText(), i, 0);
					modelP.setValueAt(Cost.getText(), i, 1);
					modelP.setValueAt(Sale.getText(), i, 2);
					modelP.setValueAt(Stock.getValue(), i, 3);
					modelS.setValueAt(Name.getText(), i, 0);
					modelS.setValueAt(Sale.getText(), i, 1);
					modelS.setValueAt(Stock.getValue(), i, 2);
					JOptionPane.showMessageDialog(null, "修改成功");
				}else{
					JOptionPane.showMessageDialog(null, "請選擇一筆訂單");
				}
			}
		});
		btnNewButton_1.setBounds(152, 414, 80, 30);
		Products.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tableP.getSelectedRow();
				if(i>=0) {
					modelP.removeRow(i);
					modelS.removeRow(i);
					JOptionPane.showMessageDialog(null, "已刪除!");
					
				}else {
					JOptionPane.showMessageDialog(null, "請選擇一筆訂單");
				}
			}
		});
		btnNewButton_2.setBounds(268, 414, 80, 30);
		Products.add(btnNewButton_2);
		
		JButton addCart = new JButton("加入購物車");
		addCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tableS.getSelectedRow();
				String PN=modelS.getValueAt(i, 0).toString();
				int PA=(int)Amount.getValue();
				int SP=Integer.parseInt(modelS.getValueAt(i, 1).toString());
				
				rowC[0]=PN;
				rowC[1]=SP;
				rowC[2]=PA;
				rowC[3]=SP*PA;
				modelC.addRow(rowC);
				
				products.add(new product(PN,SP,PA));
			}
		});
		addCart.setBounds(261, 226, 100, 30);
		Sales.add(addCart);
		
		JCheckBox Member = new JCheckBox("會員9折");
		Member.setBounds(19, 457, 74, 23);
		Sales.add(Member);
		
		JButton addOrder = new JButton("下單!");
		addOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Mid=ID.getText();
				if (Member.isSelected()) {
					boolean menber=true;
				}
				
			}
		});
		addOrder.setBounds(265, 453, 100, 30);
		Sales.add(addOrder);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("New tab", null, panel_1, null);
		
		
	}
}
