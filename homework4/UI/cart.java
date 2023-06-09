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
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

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
	int selectRow;
	private JTable tableEX;
	private JTable tableIN;
	private JTable tableBAL;
	DefaultTableModel modelEX;
	DefaultTableModel modelIN;
	DefaultTableModel modelBAL;
	private JTextField itemName;
	private JTextField itemPrice;
	

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
		setBounds(450, 150, 450, 700);
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
		Object[] rowS = {"", 0, 0};
		modelS.setColumnIdentifiers(columnS);
		tableS.setModel(modelS);
		TableColumnModel columnModelS = tableS.getColumnModel();
		columnModelS.getColumn(0).setPreferredWidth(160);
		columnModelS.getColumn(1).setPreferredWidth(80); 
		columnModelS.getColumn(2).setPreferredWidth(80);
		
        ///購物車
		
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
		TableColumnModel columnModelC = tableC.getColumnModel(); // 列寬度設定
		columnModelC.getColumn(0).setPreferredWidth(120); 
		columnModelC.getColumn(1).setPreferredWidth(40); 
		columnModelC.getColumn(2).setPreferredWidth(40); 
		columnModelC.getColumn(3).setPreferredWidth(40); 

		
		
		JSpinner Amount = new JSpinner();
		Amount.setBounds(192, 194, 30, 22);
		Sales.add(Amount);
		
				
		JLabel lblNewLabel = new JLabel("架上商品");
		lblNewLabel.setBounds(10, 10, 87, 15);
		Sales.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("購物車");
		lblNewLabel_1.setBounds(10, 230, 87, 15);
		Sales.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("訂購人");
		lblNewLabel_6.setBounds(20, 414, 46, 15);
		Sales.add(lblNewLabel_6);
		
		ID = new JTextField();
		ID.setBackground(new Color(240, 240, 240));
		ID.setBounds(62, 411, 96, 21);
		Sales.add(ID);
		ID.setColumns(10);
		
		////////////////訂單頁
		
		JPanel Orders = new JPanel();
		tabbedPane_inside.addTab("ORDER", null, Orders, null);
		Orders.setLayout(null);
		
		JScrollPane tableO_scrollPane = new JScrollPane();
		tableO_scrollPane.setBounds(32, 28, 320, 304);
		Orders.add(tableO_scrollPane);
		
		tableO = new JTable();
		tableO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow=tableO.getSelectedRow();
			}
		});
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
		
		
		/////按鈕們
		
		JLabel creatButton = new JLabel("進貨上架");
		creatButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(Name.getText().equals("")||Cost.getText().equals("")||Sale.getText().equals("")||Stock.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "請輸入完整資料");
				}else {	
					int CP=Integer.parseInt(Cost.getText());
					int SP=Integer.parseInt(Sale.getText());
									
					if (CP>=SP) {
						JOptionPane.showMessageDialog(null, "價格錯誤");
					}else {
						rowP[0]=Name.getText();
						rowP[1]=CP;
						rowP[2]=SP;
						rowP[3]=Stock.getValue();
						modelP.addRow(rowP);
						
						products.add(new product(Name.getText(),CP,SP,(int)Stock.getValue()));
						
						for(product o:products) {o.show();}
						
						int lastIndex = products.size()-1;
						rowS[0]=products.get(lastIndex).getName();
						rowS[1]=products.get(lastIndex).getSale();
						rowS[2]=products.get(lastIndex).getStock();
						modelS.addRow(rowS);
												
						Name.setText("");
						Cost.setText("");
						Sale.setText("");
						Stock.setValue(0);
						JOptionPane.showMessageDialog(null, "上架成功");
					}
				}	
			}
		});
		creatButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/creat.jpg")));
		creatButton.setBounds(32, 407, 80, 30);
		Products.add(creatButton);
		
		JLabel updateButton = new JLabel("修改");
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tableP.getSelectedRow();
				int lastIndex = i;
				if(i>=0) {
					int CP=Integer.parseInt(Cost.getText());
					int SP=Integer.parseInt(Sale.getText());
					if(CP>=SP) {
						JOptionPane.showMessageDialog(null, "價格錯誤");
					}else {
						modelP.setValueAt(Name.getText(), i, 0);
						modelP.setValueAt(Cost.getText(), i, 1);
						modelP.setValueAt(Sale.getText(), i, 2);
						modelP.setValueAt(Stock.getValue(), i, 3);
						
						products.get(lastIndex).setName(Name.getText());
						products.get(lastIndex).setCost(CP);
						products.get(lastIndex).setSale(SP);
						products.get(lastIndex).setStock((int)Stock.getValue());
						
						for(product o:products) {o.show();}
						
						modelS.setValueAt(products.get(lastIndex).getName(), i, 0);
						modelS.setValueAt(products.get(lastIndex).getSale(), i, 1);
						modelS.setValueAt(products.get(lastIndex).getStock(), i, 2);
						JOptionPane.showMessageDialog(null, "修改成功");
						Name.setText("");
						Cost.setText("");
						Sale.setText("");
						Stock.setValue(0);						
					}	
				}else{
					JOptionPane.showMessageDialog(null, "請選擇一筆訂單");
				}
			}
		});
		updateButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/update.jpg")));
		updateButton.setBounds(148, 407, 80, 30);
		Products.add(updateButton);
		
		JLabel deleteButton = new JLabel("刪除");
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tableP.getSelectedRow();
				if(i>=0) {
					modelP.removeRow(i);
					products.remove(i);
					for(product o:products) {o.show();}
					modelS.removeRow(i);
					JOptionPane.showMessageDialog(null, "已刪除!");					
				}else {
					JOptionPane.showMessageDialog(null, "請選擇一筆訂單");
				}
			}
		});
		deleteButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/delete.jpg")));
		deleteButton.setBounds(264, 407, 80, 30);
		Products.add(deleteButton);
		
		JCheckBox Member = new JCheckBox("會員9折");
		Member.setBounds(23, 435, 74, 23);
		Sales.add(Member);
		
		JLabel addCartButton = new JLabel("加入購物車");
		addCartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Amount.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "請選擇數量");
				}else {
					int i=tableS.getSelectedRow();
					String PN=modelS.getValueAt(i, 0).toString();
					int PA=(int)Amount.getValue();
					int IS=(int)(modelS.getValueAt(i, 2));
					
					if(PA>IS) {
						JOptionPane.showMessageDialog(null, "剩餘數量不足");
					}else {
						int SP=Integer.parseInt(modelS.getValueAt(i, 1).toString());
						int SA=IS-PA;
						
						rowC[0]=PN;
						rowC[1]=SP;
						rowC[2]=PA;
						rowC[3]=SP*PA;
						modelC.addRow(rowC);
												
						Amount.setValue(0);
						modelS.setValueAt(SA, i, 2);
						
						ProductName.setText("");
						
					}
				}	
			}
		});
		addCartButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/add.jpg")));
		addCartButton.setBounds(267, 190, 80, 30);
		Sales.add(addCartButton);
		

		JLabel deletePButton = new JLabel("刪除購物車");
		deletePButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i =tableC.getSelectedRow();
				if(i>=0) {
					String productN= modelC.getValueAt(i, 0).toString();
					
					for(product check:products) {
						if (productN.equals(check.getName())) {
							int purchaseA = (int)modelC.getValueAt(i,2);
							
							check.setStock(check.getStock()+purchaseA);
							
							modelC.removeRow(i);
							
							for(int j=0 ; j<modelS.getRowCount() ; j++ ) {
								String checkName = modelS.getValueAt(j,0).toString();
								if (productN.equals(checkName)) {
									int nowA = (int)modelS.getValueAt(j,2);
									int newA= nowA+purchaseA;
									modelS.setValueAt(newA, j, 2);
									break;									
								}
							}
							break;							
						}
					}					
				}else {
					JOptionPane.showMessageDialog(null, "請選擇一筆商品");
				}
				
			}
		});
		deletePButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/delete.jpg")));
		deletePButton.setBounds(177, 411, 80, 30);
		Sales.add(deletePButton);
		
		
		JLabel checkOutButton = new JLabel("下單");
		checkOutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "請輸入訂購人名稱");
				}else {
					String Mid=ID.getText();
					String OM="";
					if (Member.isSelected()) {
						OM="會員";
					}else { OM="非會員";}
					rowO[0]=Mid;
					
					String allP="";
					for(int row = 0; row < modelC.getRowCount(); row++) {
						String CP= modelC.getValueAt(row, 0).toString()+"*"+modelC.getValueAt(row, 2)+"件; ";
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
					String checkOutBill="";
					checkOutBill+="訂購人："+Mid+"\n身分："+OM+"\n";
					for(int i=0; i<modelC.getColumnCount();i++) {
						checkOutBill+=modelC.getColumnName(i)+"\t";
					}
					checkOutBill+="\n";
					for(int i=0; i<modelC.getRowCount();i++) {
						for(int j=0; j<modelC.getColumnCount() ; j++) {
						    checkOutBill+=modelC.getValueAt(i, j).toString()+"\t";
					}
					checkOutBill+="\n";
					}
					checkOutBill+="\n總金額：\t\t\t"+allS;
					
					try {
						checkOut.output.setText(checkOutBill);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					CO.setVisible(true);
					int RR=modelC.getRowCount();
					for(int i=RR-1;i>=0;i--) {
						modelC.removeRow(i);
					}
				}	
			}
		});
		checkOutButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/checkOut.jpg")));
		checkOutButton.setBounds(267, 411, 80, 30);
		Sales.add(checkOutButton);
		
		

		JLabel deleteOrderButton = new JLabel("刪除訂單");
		deleteOrderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(selectRow>=0) {
					modelO.removeRow(selectRow);
					JOptionPane.showMessageDialog(null, "已刪除!");
					
				}else {
					JOptionPane.showMessageDialog(null, "請選擇一筆訂單");
				}
			}
		});
		deleteOrderButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/delete.jpg")));
		deleteOrderButton.setBounds(272, 355, 80, 30);
		Orders.add(deleteOrderButton);
		
		JLabel exportOrderButton = new JLabel("輸出明細");
		exportOrderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableO.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "沒有資料可匯出");
				}else {
					try {
						BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("OrderList.csv"), "UTF-8"));
						out.write('\ufeff');
						for(int i=0; i<modelO.getColumnCount();i++) {
							out.write(modelO.getColumnName(i)+",");
						}
						out.write("\n");
						for(int i=0; i<modelO.getRowCount();i++) {
							for(int j=0; j<modelO.getColumnCount() ; j++) {
								out.write(modelO.getValueAt(i, j).toString()+",");
							}
							out.write("\n");
						}
						out.flush();
						out.close();
						JOptionPane.showMessageDialog(null, "匯出完成");						
					}catch(IOException e2) {
						e2.printStackTrace();
					}
				}

			}
		});
		exportOrderButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/export.jpg")));
		exportOrderButton.setBounds(272, 395, 80, 30);
		Orders.add(exportOrderButton);
		
		///////第二個分頁
		JPanel monthly_report = new JPanel();
		tabbedPane_outside.addTab("REPORT", null, monthly_report, null);
		monthly_report.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 270, 430);
		monthly_report.add(panel);
		panel.setLayout(null);
		
		///支出表格
		JScrollPane scrollPaneEX = new JScrollPane();
		scrollPaneEX.setBounds(0, 0, 270, 180);
		panel.add(scrollPaneEX);
		
		tableEX = new JTable();
		scrollPaneEX.setViewportView(tableEX);
		modelEX=new  DefaultTableModel();
		Object[] columnEX= {"支出項目","金額"};
		Object[] rowEX=new Object[2];
		modelEX.setColumnIdentifiers(columnEX);
		tableEX.setModel(modelEX);
		TableColumnModel columnModelEX=tableEX.getColumnModel();
		columnModelEX.getColumn(0).setPreferredWidth(120);
		columnModelEX.getColumn(1).setPreferredWidth(60);
		
		//收入表格
		JScrollPane scrollPaneIN = new JScrollPane();
		scrollPaneIN.setBounds(0, 179, 270, 180);
		panel.add(scrollPaneIN);
		
		tableIN = new JTable();
		scrollPaneIN.setViewportView(tableIN);
		modelIN=new  DefaultTableModel();
		Object[] columnIN= {"收入項目","金額"};
		Object[] rowIN=new Object[2];
		modelIN.setColumnIdentifiers(columnIN);
		tableIN.setModel(modelIN);
		TableColumnModel columnModelIN=tableIN.getColumnModel();
		columnModelIN.getColumn(0).setPreferredWidth(120);
		columnModelIN.getColumn(1).setPreferredWidth(60);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 358, 270, 70);
		panel.add(scrollPane_1);
		
		//結算表格
		tableBAL = new JTable();
		scrollPane_1.setViewportView(tableBAL);
		modelBAL=new  DefaultTableModel();
		Object[] columnBAL= {"總結算","金額"};
		Object[] rowBAL=new Object[2];
		modelBAL.setColumnIdentifiers(columnBAL);
		tableBAL.setModel(modelBAL);
		
		JLabel lblNewLabel_8 = new JLabel("自填項目");
		lblNewLabel_8.setBounds(290, 82, 67, 15);
		monthly_report.add(lblNewLabel_8);
		
		itemName = new JTextField();
		itemName.setBounds(290, 107, 80, 21);
		monthly_report.add(itemName);
		itemName.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("金額");
		lblNewLabel_9.setBounds(290, 138, 46, 15);
		monthly_report.add(lblNewLabel_9);
		
		itemPrice = new JTextField();
		itemPrice.setBounds(290, 157, 80, 21);
		monthly_report.add(itemPrice);
		itemPrice.setColumns(10);
		
		JLabel ExpensesButton = new JLabel("新增支出");
		ExpensesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(itemName.getText().equals("")||itemPrice.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "請輸入完整資料");
				}else {
					rowEX[0]=itemName.getText();
					rowEX[1]=Integer.parseInt(itemPrice.getText());
					modelEX.addRow(rowEX);
					itemName.setText("");
					itemPrice.setText("");
				}	
			}
		});
		ExpensesButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/ExpBut.jpg")));
		ExpensesButton.setBounds(290, 204, 80, 30);
		monthly_report.add(ExpensesButton);
		
		JLabel IncomeButton = new JLabel("新增收入");
		IncomeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(itemName.getText().equals("")||itemPrice.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "請輸入完整資料");
				}else {
					rowIN[0]=itemName.getText();
					rowIN[1]=Integer.parseInt(itemPrice.getText());
					modelIN.addRow(rowIN);
					itemName.setText("");
					itemPrice.setText("");
				}
			}
		});
		IncomeButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/InBut.jpg")));
		IncomeButton.setBounds(290, 251, 80, 30);
		monthly_report.add(IncomeButton);
		
		JLabel RepoUp = new JLabel("修改");
		RepoUp.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/update.jpg")));
		RepoUp.setBounds(290, 298, 80, 30);
		monthly_report.add(RepoUp);
		
		JLabel RepoDel = new JLabel("刪除");
		RepoDel.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/delete.jpg")));
		RepoDel.setBounds(290, 345, 80, 30);
		monthly_report.add(RepoDel);
		
		JLabel RepoExpo = new JLabel("匯出明細");
		RepoExpo.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/print.jpg")));
		RepoExpo.setBounds(290, 439, 80, 30);
		monthly_report.add(RepoExpo);
		
		JLabel GetData = new JLabel("取得資料");
		GetData.addMouseListener(new MouseAdapter() {
			private boolean buttonClicked = false;
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!buttonClicked) {
					rowEX[0]="房租";
					rowEX[1]="8000";
					modelEX.addRow(rowEX);
					rowEX[0]="水電費";
					rowEX[1]="1600";
					modelEX.addRow(rowEX);
								
					rowEX[0]="進貨總支出";
					int EXSum=0;
					for (int i=0; i<products.size();i++) {
						EXSum+=products.get(i).getSum();
					}
					rowEX[1]=EXSum;
					modelEX.addRow(rowEX);
					
					rowIN[0]="販售總收入";
					int INSum=0;
					for(int i=0;i<modelO.getRowCount();i++) {
						INSum+=(int)modelO.getValueAt(i, 3);
					}
					rowIN[1]=INSum;
					modelIN.addRow(rowIN);
					
					buttonClicked=true;
				}	
			}
		});
		GetData.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/getData.jpg")));
		GetData.setBounds(290, 31, 80, 30);
		monthly_report.add(GetData);
		
		JLabel balanceButton = new JLabel("結算");
		balanceButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowBAL[0]="總支出";
				int allEX=0;
				for(int i=0; i<modelEX.getRowCount();i++) {
					allEX+=Integer.parseInt(modelEX.getValueAt(i, 1));
				}
				rowBAL[1]=allEX;
				modelBAL.addRow(rowBAL);
				
				rowBAL[0]="總收入";
				int allIN=0;
				for(int i=0; i<modelIN.getRowCount();i++) {
					allEX+=(int)modelIN.getValueAt(i, 1);
				}
				rowBAL[1]=allIN;
				modelBAL.addRow(rowBAL);
				
				/*rowBAL[0]="結算";
				rowBAL[1]=(allIN-allEX)+"";
				modelBAL.addRow(rowBAL);*/
			}
		});
		balanceButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/balBut.jpg")));
		balanceButton.setBounds(290, 392, 80, 30);
		monthly_report.add(balanceButton);
		TableColumnModel columnModelBAL=tableBAL.getColumnModel();
		columnModelBAL.getColumn(0).setPreferredWidth(120);
		columnModelBAL.getColumn(1).setPreferredWidth(60);
		
		//////時鐘
		
		clock = new JLabel("");
		clock.setForeground(new Color(99, 130, 191));
		clock.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		clock.setBounds(30, 550, 150, 20);
		main.add(clock);
		
		JLabel EXITButton = new JLabel("離開");
		EXITButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		EXITButton.setIcon(new ImageIcon(cart.class.getResource("/homework4/img/exit.jpg")));
		EXITButton.setBounds(302, 547, 80, 30);
		main.add(EXITButton);
		
		
		
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
