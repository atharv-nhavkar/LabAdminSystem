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

    	
    	
    	
        // ####################################################################
        // Kachara 
        // ####################################################################
        
        System.out.println("Kachara code execution started !! " );

    	frame = new JFrame("My First Swing Example");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Creating panel. This is same as a div tag in HTML
         * We can create several panels and add them to specific 
         * positions in a JFrame. Inside panels we can add text 
         * fields, buttons and other components.
         */
        JPanel panel = new JPanel();    
        // adding panel to frame
        frame.add(panel);
        /* calling user defined method for adding components
         * to the panel.
         */
        placeComponents(panel);
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

    private void initalmessage(String userName , String password){


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


}