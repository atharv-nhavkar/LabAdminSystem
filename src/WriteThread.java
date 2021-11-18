import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.awt.*;
//import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



 
/**
 * This thread is responsible for reading user's input and send it
 * to the server.
 * It runs in an infinite loop until the user types 'bye' to quit.
 *
 * @author www.codejava.net
 */
public class WriteThread extends Thread {
//    private PrintWriter writer;
    private Socket socket;
    private Client client;
    ObjectOutputStream forobj;
    ObjectInputStream getobj ;
    JFrame frame;
    
    
    // riya che variable 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables

    public WriteThread(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
 
        
        try {
            // currently no need of it 
            // OutputStream output = socket.getOutputStream();
            // writer = new PrintWriter(output, true);
            
            forobj = new ObjectOutputStream(socket.getOutputStream());
            // getobj = new ObjectInputStream(socket.getInputStream());


        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public void run() {
    	
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	
    	
    	
        //</editor-fold>

        /* Create and display the form */
        // java.awt.EventQueue.invokeLater(new Runnable() {
        //     public void run() {
        //         new log().setVisible(true);
        //     }
        // });
    	
//    	java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new loginpage().setVisible(true);
//            }
//        });

    	
    	
    	
        // ####################################################################
        // Kachara 
        // ####################################################################
        
//        System.out.println("Kachara code execution started !! " );

    	frame = new JFrame("Login Window");
        // Setting the width and height of frame
//        frame.setSize(350, 200);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        /* Creating panel. This is same as a div tag in HTML
//         * We can create several panels and add them to specific 
//         * positions in a JFrame. Inside panels we can add text 
//         * fields, buttons and other components.
//         */
//        JPanel panel = new JPanel();    
//        // adding panel to frame
//        frame.add(panel);
//        /* calling user defined method for adding components
//         * to the panel.
//         */
//        placeComponents(panel);
    	initComponents();
        frame.setVisible(true);
 
//        Console console = System.console();
 
        // String userName = console.readLine("\nEnter your PRN : ");
        // client.setUserName(userName);
        
        // String password = console.readLine("\nEnter your Password : ");
        
        // writer.println(password); 

        // Date date = new Date();  
        // SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        // String strDate = formatter.format(date);  
        // System.out.println("Date Format with MM/dd/yyyy : "+strDate);
        
        // formatter = new SimpleDateFormat("hh:mm:ss");
        // String strtime = formatter.format(date);  
        // System.out.println("TIme is  "+strtime);

        // BasicInfo initial = new BasicInfo(userName, strDate, strtime,"password",password);

        // try {
        //     forobj.writeObject(initial);
        // } 
        // catch (Exception e) {
        //     System.out.println("s0mething went wrong :" + e.getMessage());
        // }
        
        // ####################################################################
        // Kachara 
        // ####################################################################
        
        // code to listen everything that server says 
//        String clientMessage;        
//    
//        do {
//        	try {
//                BasicInfo rcvinfo = (BasicInfo)getobj.readObject();    
//                System.out.println(rcvinfo.prn);
//                System.out.println(rcvinfo.date);
//                System.out.println(rcvinfo.time);
//                System.out.println(rcvinfo.time);
//                System.out.println(rcvinfo.key);
//                System.out.println(rcvinfo.value);
//                clientMessage = rcvinfo.value ; 
//            } catch (Exception e) {
//                clientMessage = "bye";
//                System.out.println("exception in getting object  " + e.getMessage());
//            }
//        } while (!clientMessage.equals("bye"));
// 
//        try {
//            socket.close();
//        } catch (IOException ex) {
//            System.out.println("Server closed " + ex.getMessage());
//        }
        
        // code to listen everything that server says ends here 
        
    }

    public void initalmessage(String userName , String password){


        client.setUserName(userName);
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        String strDate = formatter.format(date);  
        System.out.println("Date Format with MM/dd/yyyy : "+strDate);
        
        formatter = new SimpleDateFormat("hh:mm:ss");
        String strtime = formatter.format(date);  
        System.out.println("TIme is  "+strtime);

        BasicInfo initial = new BasicInfo(userName, strDate, strtime,"password",password);

        try {
            forobj.writeObject(initial);
            frame.setVisible(false);
            client.lauch_frame_for_afterLogin();
            
        } 
        catch (Exception e) {
            System.out.println("s0mething went wrong :" + e.getMessage());
        }

    }


    private void send_Message(String key , String value){

    	
    	String userName = client.getUserName();
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        String strDate = formatter.format(date);  
        System.out.println("Date Format with MM/dd/yyyy : "+strDate);
        
        formatter = new SimpleDateFormat("hh:mm:ss");
        String strtime = formatter.format(date);  
        System.out.println("TIme is  "+strtime);

        BasicInfo cilentmsg = new BasicInfo(userName, strDate, strtime,key,value);
        try {
            forobj.writeObject(cilentmsg);
        } 
        catch (Exception e) {
            System.out.println("s0mething went wrong :" + e.getMessage());
        }

    }
    
    
    private void lauch_frame_for_login() {
    		System.out.println("Kachara code execution started !! " );

      	   	JFrame frame = new JFrame("My First Swing Example");
      	   	// Setting the width and height of frame
      	   	frame.setSize(350, 200);
      	   	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel();    
            // adding panel to frame
            frame.add(panel);
            /* calling user defined method for adding components
             * to the panel.
             */
            placeComponents(panel);
            frame.setVisible(true);
    	
    }
    
    
    private void placeComponents(JPanel panel) {

        /* We will discuss about layouts in the later sections
         * of this tutorial. For now we are setting the layout 
         * to null
         */
        panel.setLayout(null);

        // Creating JLabel
        JLabel userLabel = new JLabel("User");
        /* This method specifies the location and size
         * of component. setBounds(x, y, width, height)
         * here (x,y) are cordinates from the top left 
         * corner and remaining two arguments are the width
         * and height of the component.
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /* Creating text field where user is supposed to
         * enter user name.
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // Same process for password label and text field.
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /*This is similar to text field but it hides the user
         * entered data and displays dots instead to protect
         * the password like we normally see on login screens.
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // Creating login button
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String userName = userText.getText();
                String password = passwordText.getText();
                initalmessage(userName, password);
                // TODO Auto-generated method stub
            }
         });
       
        panel.add(loginButton);
       
    }
    
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JButton();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 0, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 0, 102));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comp-removebg-preview (3).png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Walchand College of Engineering");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wce_light (1) (1).png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userlab.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(120, 0, 120));
        jLabel3.setText("PRN Number");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(120, 0, 120));
        jLabel6.setText("Password");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(120, 0, 120));
        jLabel7.setText("Login");
//        jLabel7.addActionListener( new ActionListener() {
//
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//            	System.out.println("Clicked it ") ;
//
//                String userName = "Soniya ";
//                String password = "soniya ";
//                initalmessage(userName, password);
//                // TODO Auto-generated method stub
//            }
//         });

        jTextField1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 0, 102)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPasswordField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 0, 102)));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        kGradientPanel2.setkEndColor(new java.awt.Color(102, 0, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(102, 0, 102));
        kGradientPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel2MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Login");
        
        
        jLabel10.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	System.out.println("Clicked it ") ;

                String userName = jTextField1.getText();
                String password = jPasswordField1.getText();
                initalmessage(userName, password);
                // TODO Auto-generated method stub
            }
         });
        

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jPasswordField1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 69, Short.MAX_VALUE)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel1)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );

        frame.pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void kGradientPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel2MouseClicked
        // TODO add your handling code here:
    	
        
    }//GEN-LAST:event_kGradientPanel2MouseClicked



}