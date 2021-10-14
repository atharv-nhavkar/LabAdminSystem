import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import javafx.scene.image.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JTable;

public class ServerWindow {

	public JFrame frame;
	public JPanel panel;

	
	private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerWindow window = new ServerWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1019, 695);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Walchand College Of Engineering , Sangli ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Lauch window that shows all the records of students of current date 
			}
		});
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setLabelFor(frame);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(51, 51, 153));
		lblNewLabel.setBackground(new Color(102, 51, 0));
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 36));
		lblNewLabel.setBounds(25, 0, 935, 84);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lab Managment System <somecoolname>");
		lblNewLabel_1.setFont(new Font("Vivaldi", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(193, 44, 547, 51);
		frame.getContentPane().add(lblNewLabel_1);
		panel = new JPanel();
		panel.setBounds(10, 149, 985, 499);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
//		JScrollPane scroll = new JScrollPane(panel);
//		scroll.setHorizontalScrollBarPolicy(
//		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scroll.setVerticalScrollBarPolicy(
//		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		
		
		
		JButton btnNewButton = new JButton("Todays All Records ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
//				showTable();
				riyaadduser("2019BTEIT00050" , "password");
				
				showtablesoniya();
				System.out.println("hello worls ") ;
//				JPanel panel_1 = new JPanel();
//				panel.add(panel_1);
//				panel_1.setLayout(new BorderLayout(0, 0));
//				JLabel lblNewLabel_3 = new JLabel("active!");
//				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
//				panel_1.add(lblNewLabel_3,BorderLayout.NORTH);
//				
//				JLabel lblNewLabel_2 = new JLabel("2019BTEIT00032");
//				panel_1.add(lblNewLabel_2,BorderLayout.SOUTH);
////				JLabel jLabel1 = new javax.swing.JLabel();
////		        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lAb aDmin pRoject/src/icons8_Contacts_25px.png"))); // NOI18N
////		        panel_1.add(jLabel1,BorderLayout.CENTER);
//		        ImageIcon icon = new ImageIcon("D:\\Java Acad Project 2.0\\lAb aDmin pRoject\\src\\images\\nerd.PNG"); 
//		        JLabel thumb = new JLabel(icon);
//		        thumb.setIcon(icon);
//		        panel_1.add(thumb,BorderLayout.CENTER);
//			    Border blackline = BorderFactory.createLineBorder(Color.black);
//			    panel_1.setBorder(blackline);				
				
				
			}
		});
		btnNewButton.setForeground(new Color(255, 51, 51));
		btnNewButton.setBackground(new Color(0, 102, 0));
		btnNewButton.setBounds(787, 44, 208, 33);
		frame.getContentPane().add(btnNewButton);
		System.out.println("hello worls ") ;
//		JLabel jLabel1 = new javax.swing.JLabel();
//        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lAb aDmin pRoject/src/icons8_Contacts_25px.png"))); // NOI18N
//        panel_1.add(jLabel1,BorderLayout.CENTER);
//        ImageIcon icon = new ImageIcon("D:\\Java Acad Project 2.0\\lAb aDmin pRoject\\src\\images\\geek2.png");
//	    Border blackline = BorderFactory.createLineBorder(Color.black);
//		
		
//		JPanel panel_1 = new JPanel();
//		panel.add(panel_1);
//		panel_1.setLayout(new BorderLayout(0, 0));
//		
//		JLabel lblNewLabel_3 = new JLabel("Currently Active ");
//		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
//		panel_1.add(lblNewLabel_3,BorderLayout.NORTH);
//		
//		JLabel lblNewLabel_2 = new JLabel("PRN : 2019BTEIT00032");
//		panel_1.add(lblNewLabel_2,BorderLayout.SOUTH);
		
	}
	
	ArrayList<BasicInfo> getinfo(){
		
		ArrayList<BasicInfo> infolist = new ArrayList<>(); 
		
		
		// actual code 
		
        
        try {
        	try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
            } catch (Exception e) {
                System.out.println("gotcha ");
                System.out.println(e.getMessage());
                System.out.println("gotcha ");
                //TODO: handle exception
            }
            String connUrl="jdbc:mysql://localhost/animal?";
			Connection conn=DriverManager.getConnection(connUrl,"root","password");
            String sql="SELECT * FROM allentries;";
            Statement st=conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
            	String prn = rs.getString("prn");
            	String cdate = rs.getString("cdate");
            	String ctime = rs.getString("ctime");
            	String ckey = rs.getString("ckey");
            	String value = rs.getString("value");
            	BasicInfo initial = new BasicInfo(prn, cdate, ctime,ckey,value);
    	        infolist.add(initial);
            	
            	
            }
            
         
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// actual code ends 
//		for(int i=0;i<5;i++) {
//	        Date date = new Date();  
//	        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
//	        String strDate = formatter.format(date);  
//	        System.out.println("Date Format with MM/dd/yyyy : "+strDate);
//	        
//	        formatter = new SimpleDateFormat("hh:mm:ss");
//	        String strtime = formatter.format(date);  
//	        System.out.println("TIme is  "+strtime);
//
//	        BasicInfo initial = new BasicInfo("sample", strDate, strtime,"sample","sample");
//	        infolist.add(initial);
//		}
		return infolist;
	}
	
	
	
	void showTable() {
		
		
		// SOmethig new trying n0w ...
		String[] columnNames = {"Roll No", "Name", "Class", "Section","something "};

		JFrame frame1 = new JFrame("Database Search Result");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(new BorderLayout()); 
		//TableModel tm = new TableModel();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		
		//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
		//table = new JTable(model);
		JTable table = new JTable();
		table.setModel(model); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		
		ArrayList<BasicInfo> infolist = getinfo() ;
		Object[] row = new Object[5];
		for(int i=0;i<infolist.size();i++) {
			row[0]= infolist.get(i).prn;
			row[1]= infolist.get(i).date;
			row[2]= infolist.get(i).time;
			row[3]= infolist.get(i).key;
			row[4]= infolist.get(i).value;
			model.addRow(row);
		}
		
		
		frame1.getContentPane().add(scroll);
		frame1.setVisible(true);
		frame1.setSize(400,300);

		// SOmethig new ends here ...
//		ArrayList<BasicInfo> infolist = getinfo() ; 
//		
//		DefaultTableModel nmodel = new DefaultTableModel();
//		
//		Object[] row = new Object[5];
//		Object[] columns  = {"PRN","date","time","key","value"}	;
//		nmodel.setColumnIdentifiers(columns);
//		table.setModel(nmodel);
//		for(int i=0;i<infolist.size();i++) {
//			row[0]= infolist.get(i).prn;
//			row[1]= infolist.get(i).date;
//			row[2]= infolist.get(i).time;
//			row[3]= infolist.get(i).key;
//			row[4]= infolist.get(i).value;
//			nmodel.addRow(row);
//		}
		
	}
	
	
	void add_user(String prn , String activity) {

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel(activity);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3,BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel(prn);
		panel_1.add(lblNewLabel_2,BorderLayout.SOUTH);
		
		
	}
	
	void riyaadduser(String prn , String status) {
	    
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        
		 jPanel2.setBackground(new java.awt.Color(255, 255, 255));
	        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

	        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programmer (3).jpg"))); // NOI18N

	        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
	        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
	        jLabel2.setText(prn);

	        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
	        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
	        jLabel3.setText("User:");

	        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
	        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
	        jLabel4.setText("Status:");

	        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
	        jLabel5.setForeground(new java.awt.Color(0, 255, 51));
	        jLabel5.setText(status);

	        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
	        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
	        jLabel6.setText("Date:");

	        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
	        jLabel7.setForeground(new java.awt.Color(102, 0, 102));
	        jLabel7.setText("Time:");

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addGap(56, 56, 56)
	                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addComponent(jLabel6)
	                    .addComponent(jLabel7)
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addComponent(jLabel4)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel5))
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel2)))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel3)
	                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel4)
	                    .addComponent(jLabel5))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jLabel6)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jLabel7))
	        );
	        
			panel.add(jPanel2);

	}
	void showtablesoniya() {
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new mainform().setVisible(true);
	            }
	        });

       
	}
}
