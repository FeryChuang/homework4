package homework4.UI;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


import homework4.prog.order;
import homework4.prog.product;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

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
	JLabel clock;
	

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
		addWindowListener(new WindowAdapter(){
			public void windowActivated(WindowEvent e) {
				super.windowActivated(e);
				new Thread(new ClocKRunnable()).start();
			}
		});
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 120, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//宣告兩個陣列
		products = new ArrayList<product>();
		orders= new ArrayList<order>();
		
		JPanel logo = new JPanel();
		logo.setBounds(10, 10, 414, 60);
		contentPane.add(logo);
		logo.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/shop logo-out.jpg")));
		lblNewLabel_7.setBounds(0, 0, 414, 60);
		logo.add(lblNewLabel_7);
		
		JPanel main = new JPanel();
		main.setBounds(10, 69, 414, 592);
		contentPane.add(main);
		main.setLayout(null);
		
		JTabbedPane tabbedPane_outside = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_outside.setBounds(10, 10, 394, 526);
		main.add(tabbedPane_outside);
		
		JTabbedPane tabbedPane_inside = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_outside.addTab("SHOP", null, tabbedPane_inside, null);
		
		//進貨的分頁
		JPanel Products = new JPanel();
		tabbedPane_inside.addTab("STOCK", null, Products, null);
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
		TableColumnModel columnModelP = tableP.getColumnModel();
		columnModelP.getColumn(0).setPreferredWidth(120);
		columnModelP.getColumn(1).setPreferredWidth(80);
		columnModelP.getColumn(2).setPreferredWidth(80);
		columnModelP.getColumn(3).setPreferredWidth(40);

		
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
		tabbedPane_inside.addTab("SALE", null, Sales, null);
		Sales.setLayout(null);
		
		ProductName = new JTextField();
		ProductName.setEditable(false);
		ProductName.setBounds(31, 195, 96, 21);
		Sales.add(ProductName);
		ProductName.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 35, 364, 146);
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
		TableColumnModel columnModelS = tableS.getColumnModel();
		columnModelS.getColumn(0).setPreferredWidth(160);
		columnModelS.getColumn(1).setPreferredWidth(80); 
		columnModelS.getColumn(2).setPreferredWidth(80);
		

		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 255, 364, 146);
		Sales.add(scrollPane_3);
		
		//建立C表格的小精靈
		tableC = new JTable();
		scrollPane_3.setViewportView(tableC);
		modelC =new DefaultTableModel();
		Object[] columnC= {"商品名稱","售價","購買數量","小計"};
		Object[] rowC=new Object[4];
		modelC.setColumnIdentifiers(columnC);
		tableC.setModel(modelC);
		TableColumnModel columnModelC = tableC.getColumnModel();
		columnModelC.getColumn(0).setPreferredWidth(120); // 會員ID列寬度設定為100
		columnModelC.getColumn(1).setPreferredWidth(40); // 訂購內容列寬度設定為300
		columnModelC.getColumn(2).setPreferredWidth(40); // 會員列寬度設定為150
		columnModelC.getColumn(3).setPreferredWidth(40); // 總金額列寬度設定為200

		
		
		JSpinner Amount = new JSpinner();
		Amount.setBounds(192, 194, 30, 22);
		Sales.add(Amount);
		
				
		JLabel lblNewLabel = new JLabel("架上商品");
		lblNewLabel.setBounds(10, 10, 87, 15);
		Sales.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("購物車");
		lblNewLabel_1.setBounds(10, 230, 87, 15);
		Sales.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("會員ID");
		lblNewLabel_6.setBounds(20, 414, 46, 15);
		Sales.add(lblNewLabel_6);
		
		ID = new JTextField();
		ID.setBounds(76, 411, 96, 21);
		Sales.add(ID);
		ID.setColumns(10);
		
		////////////////
		
		JPanel Orders = new JPanel();
		tabbedPane_inside.addTab("ORDER", null, Orders, null);
		Orders.setLayout(null);
		
		JScrollPane tableO_scrollPane = new JScrollPane();
		tableO_scrollPane.setBounds(32, 28, 320, 304);
		Orders.add(tableO_scrollPane);
		
		tableO = new JTable();
		tableO_scrollPane.setViewportView(tableO);
		
		modelO =new DefaultTableModel();
		Object[] columnO= {"會員ID","訂購內容","會員","總金額"};
		Object[] rowO=new Object[4];
		modelO.setColumnIdentifiers(columnO);
		tableO.setModel(modelO);
		TableColumnModel columnModel = tableO.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50); 
		columnModel.getColumn(1).setPreferredWidth(180); 
		columnModel.getColumn(2).setPreferredWidth(40); 
		columnModel.getColumn(3).setPreferredWidth(50); 

		
		//////////////////////////
		//按鈕們
		
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
		btnNewButton.setBounds(35, 397, 80, 30);
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
		btnNewButton_1.setBounds(151, 397, 80, 30);
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
		btnNewButton_2.setBounds(267, 397, 80, 30);
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
				
				Amount.setValue(0);
			}
		});
		addCart.setBounds(261, 190, 100, 30);
		Sales.add(addCart);
		
		JCheckBox Member = new JCheckBox("會員9折");
		Member.setBounds(86, 438, 74, 23);
		Sales.add(Member);
		
		JButton addOrder = new JButton("下單!");
		addOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Mid=ID.getText();
				boolean OM=true;
				if (Member.isSelected()) {
					OM=true;
				}else { OM=false;}
				rowO[0]=Mid;
				
				String allP="";
				for(int row = 0; row < modelC.getRowCount(); row++) {
					String CP= modelC.getValueAt(row, 0).toString()+"*"+Amount.getValue()+";";
					allP+=CP;
				}
				
				rowO[1]=allP;
				rowO[2]=OM;
				
				int allS=0;
				for (int row = 0; row < modelC.getRowCount(); row++) {
		            int cellValue = Integer.parseInt(modelC.getValueAt(row, 3).toString());
		            allS += cellValue;
				}
				rowO[3]=allS;
				modelO.addRow(rowO);
				
				checkOut CO=new checkOut();
				CO.setVisible(true);
			}
		});
		addOrder.setBounds(261, 414, 100, 30);
		Sales.add(addOrder);
		
		JPanel monthly_report = new JPanel();
		tabbedPane_outside.addTab("REPORT", null, monthly_report, null);
		
		JButton deletOrderButton = new JButton("刪除訂單");
		deletOrderButton.setBounds(252, 350, 100, 30);
		Orders.add(deletOrderButton);
		
		JButton exportOrderButton = new JButton("輸出表單");
		exportOrderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		exportOrderButton.setBounds(252, 394, 100, 30);
		Orders.add(exportOrderButton);
		
		clock = new JLabel("");
		clock.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		clock.setBounds(28, 557, 150, 20);
		main.add(clock);
		
		JButton exitButton = new JButton("離開");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(283, 552, 80, 30);
		main.add(exitButton);
		
		
		
	}
	private static String format(int number){
		return number<10 ? "0"+number : ""+number;
	}
	private static String getTime() {
		Calendar calendar=new GregorianCalendar();
		int Year=calendar.get(Calendar.YEAR);
		int Month=calendar.get(Calendar.MONTH);
		int Day=calendar.get(Calendar.DATE);
		int Hour=calendar.get(Calendar.HOUR_OF_DAY);
		int Minute=calendar.get(Calendar.MINUTE);
		int Second=calendar.get(Calendar.SECOND);
		return Year+"/"+(Month+1)+"/"+Day+" "+format(Hour)+":"+format(Minute)+":"+format(Second);
	}
	
	private class ClocKRunnable implements Runnable{
		public void run() {
			while(true) {
				clock.setText(getTime());
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
