import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.*;

// import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.layout.StackPane;
// import javafx.stage.Stage;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.JPasswordField;
// import javax.swing.JTextField;

 
/**
 * This is the chat client program.
 * Type 'bye' to terminte the program.
 *
 * @author www.codejava.net
 */
public class Client {
    private String hostname;
    private int port;
    private String userName;
    private JFrame frame ;
    
    ObjectOutputStream forobj;
    ObjectInputStream getobj ;
 
    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }
 
    public void execute() {
    	
	        try {
	            Socket socket = new Socket(hostname, port);
	            System.out.println(socket.isConnected());
	            new ReadThread(socket, this).start();
	            new WriteThread(socket, this).start();
	            
	            
	        } catch (UnknownHostException ex) {
	            System.out.println("Server not found: " + ex.getMessage());
	        } catch (IOException ex) {
	            System.out.println("I/O Error: " + ex.getMessage());
	        }
    	
    }
 
    void setUserName(String userName) {
        this.userName = userName;
    }
 
    String getUserName() {
        return this.userName;
    }
 
 
    public static void main(String[] args) {
    	
//        if (args.length < 2) return;
 
        String hostname = "localhost";
        int port = 8080;

        Client client = new Client(hostname, port);
        client.execute();

    }


    private void send_Message(String key , String value){

    	
    	String userName = "someusername !! ";
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
    
    void lauch_frame_for_afterLogin() {
		System.out.println("Kachara code execution started !! " );
  	   	frame = new JFrame("My First Swing Example");
  	   	// Setting the width and height of frame
  	   	frame.setSize(350, 200);
  	   	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        // adding panel to frame
        frame.add(panel);
        JLabel userLabel = new JLabel("Processing Your Credentails !!");
        
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        frame.setVisible(true);
	
    }
    
    
    void closeframe() {
        frame.setVisible(false);
    }

   

}