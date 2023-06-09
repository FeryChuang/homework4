package homework4.UI;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Random;


import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;


public class checkOut extends JFrame {

	private JPanel contentPane;
	static JTextArea output;
	JLabel clock;
	JLabel date;

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
		/*addWindowListener(new WindowAdapter(){
			public void windowActivated(WindowEvent e) {
				super.windowActivated(e);
				new Thread(new ClocKRunnable()).start();
			}
		});*/
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(475, 150, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(35, 25, 312, 446);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(checkOut.class.getResource("/homework4/img/shop logo-black-s.jpg")));
		lblNewLabel_1.setBounds(11, 10, 290, 66);
		panel.add(lblNewLabel_1);
		
		output = new JTextArea();
		output.setEditable(false);
		output.setBounds(0, 238, 312, 173);
		panel.add(output);
		
		JLabel lblNewLabel_2 = new JLabel("電子發票證明聯");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 38));
		lblNewLabel_2.setBounds(21, 67, 270, 40);
		panel.add(lblNewLabel_2);
		
		date = new JLabel("");
		date.setFont(new Font("微軟正黑體", Font.PLAIN, 35));
		date.setBounds(30, 106, 251, 50);
		panel.add(date);
		date.setText(getDate());
		
		
		clock = new JLabel("New label");
		clock.setBounds(21, 200, 175, 15);
		panel.add(clock);
		clock.setText(getTime());
		
		JLabel lblNewLabel_4 = new JLabel("營業人統編:39670184");
		lblNewLabel_4.setBounds(21, 217, 175, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("退貨憑電子發票紙本正本辦理");
		lblNewLabel_5.setBounds(21, 421, 270, 15);
		panel.add(lblNewLabel_5);
		
		JLabel number = new JLabel("New label");
		number.setFont(new Font("微軟正黑體", Font.BOLD, 38));
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setBounds(11, 141, 290, 57);
		panel.add(number);
		
		String BN="";
		StringBuilder sb = new StringBuilder();
		Random random =new Random();
		
		char letter1 = (char)(random.nextInt(26)+'A');
		char letter2 = (char)(random.nextInt(26)+'A');
		sb.append(letter1).append(letter2);
		sb.append("-");
		for (int i=0; i<9; i++) {
			int num = random.nextInt(10);
			sb.append(num);			
		}
		
		BN=sb.toString();
		number.setText(BN);
		
		
		//output.displayImage();
		
		JLabel printCheckOut = new JLabel("列印明細");
		printCheckOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(new Printable() {
                    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
                            throws PrinterException {
                        if (pageIndex > 0) {
                            return NO_SUCH_PAGE;
                        }

                        Graphics2D g2d = (Graphics2D) graphics;
                        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                        panel.printAll(graphics);

                        return PAGE_EXISTS;
                    }
                });

                if (job.printDialog()) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                        ex.printStackTrace();
                    }
                }}
		});
		printCheckOut.setIcon(new ImageIcon(checkOut.class.getResource("/homework4/img/print.jpg")));
		printCheckOut.setBounds(73, 481, 80, 30);
		contentPane.add(printCheckOut);
		
		JLabel lblNewLabel = new JLabel("確認關閉");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(checkOut.class.getResource("/homework4/img/OK.jpg")));
		lblNewLabel.setBounds(235, 481, 80, 30);
		contentPane.add(lblNewLabel);
		
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
	
	private static String getDate() {
		Calendar calendar=new GregorianCalendar();
		int Year=calendar.get(Calendar.YEAR);
		int Month=calendar.get(Calendar.MONTH);
		return Year+"年"+format(Month)+"-"+format((Month+1))+"月";
	}
	/*private class ClocKRunnable implements Runnable{
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
	}*/
}

