import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
/**
 * This thread is responsible for reading server's input and printing it
 * to the console.
 * It runs in an infinite loop until the client disconnects from the server.
 *
 * @author www.codejava.net
 */
public class ReadThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private Client client;
    JFrame frame;

 
    public ReadThread(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
 
        try {
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println("Error getting input stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public void run() {
        while (true) {
            try {
//                String response = reader.readLine();
//                System.out.println("\n" + response);
 
                // SOME SHIT IMMA GONNA try 
                ObjectInputStream getobj = new ObjectInputStream(socket.getInputStream());
                
                try {
                    BasicInfo rcvinfo = (BasicInfo)getobj.readObject();   
                    System.out.println("recived this info on readthread ");
                    System.out.println(rcvinfo.prn);
                    System.out.println(rcvinfo.date);
                    System.out.println(rcvinfo.time);
                    System.out.println(rcvinfo.time);
                    System.out.println(rcvinfo.key);
                    System.out.println(rcvinfo.value);
                    String key = rcvinfo.key;
                    String value = rcvinfo.value;
                    
                    if(key.equals("login") && value.equals("SUCCESS")) {
                    	login_scuucessful(rcvinfo);	
                    }
                    if(rcvinfo.key == "login" && rcvinfo.value == "FALI") {
                    		
                    }
                    if(key.equals("SHUTDOWN") && value.equals("SUCCESS")) {
                    	shutdownpc();	
                    }
                    
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
                
                // prints the username after displaying the server's message
//                if (client.getUserName() != null) {
//                    System.out.print("[" + client.getUserName() + "]: ");
//                }
            } catch (IOException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
    
    private void login_scuucessful(BasicInfo rcvinfo) {
    	System.out.println("ReadThread : Kachara code execution started !! " );
    	client.closeframe();
  	   	frame = new JFrame(" Login Success  ");
  	   	// Setting the width and height of frame
  	   	frame.setSize(350, 350);
  	   	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        // adding panel to frame
        frame.add(panel);
//        JLabel userLabel = new JLabel("After Login screen is here BOIS !");
//        
//        userLabel.setBounds(10,20,80,25);
//        panel.add(userLabel);
//        
        String prn = rcvinfo.prn;
        String status = " Login Success " ;
        String date = rcvinfo.date ;
        String time = rcvinfo.time;
        
        frame.setVisible(true);
        
         javax.swing.JLabel jLabel1;
         javax.swing.JLabel jLabel2;
         javax.swing.JLabel jLabel3;
         javax.swing.JLabel jLabel4;
         javax.swing.JLabel jLabel5;
         javax.swing.JLabel jLabel6;
         javax.swing.JLabel jLabel7;
         javax.swing.JPanel jPanel2;
        
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
	        jLabel6.setText("Date:" + date);

	        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
	        jLabel7.setForeground(new java.awt.Color(102, 0, 102));
	        jLabel7.setText("Time:" + time);

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
	        
	        JButton loginButton = new JButton("logout");
	        loginButton.setBounds(10, 80, 80, 25);
	        loginButton.addActionListener( new ActionListener() {

	            @Override
	            public void actionPerformed(java.awt.event.ActionEvent e) {
	            	
	            	// TODO Auto-generated method stub
	            }
	         });
	        panel.add(loginButton);
			panel.add(jPanel2);
    	
    }
    
    
    private void shutdownpc() {
    	Runtime runtime = Runtime.getRuntime();
        try {
			Process proc = runtime.exec("shutdown -s -t 0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.exit(0);

    }
}