
import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.sql.*;

//import org.json.simple.*;
//import org.json.simple.parser.*;
import java.awt.*;  

 

public class ChatServer {
    private int port;
    private Set<String> userNames = new HashSet<>();
    private Set<UserThread> userThreads = new HashSet<>();
    private JFrame frame;
    ServerWindow window ;
 
    public ChatServer(int port) {
        this.port = port;
        frame = new JFrame("Server Side GUI : ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 720);
        frame.setVisible(true);
        frame.setLayout(new GridLayout() );
//        try {
//			window = new ServerWindow();
//			window.frame.setVisible(true);
//		} catch (Exception e) {
//            System.out.println("FFFFF" + e.getMessage());
//
//			e.printStackTrace();
//		}
        

    }
 
    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
 
            System.out.println("Chat Server is listening on port " + port);
 
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");
//                UserThread newUser = new UserThread(socket, this);
//                userThreads.add(newUser);
//                newUser.start();
// 
                
            }
 
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Syntax: java ChatServer <port-number>");
            System.exit(0);
        }
 
        int port = Integer.parseInt(args[0]);
       try
       {
            String name="something ";
            System.out.println(name);
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

           Date date = new Date();  
           SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
           String strDate = formatter.format(date);  
           System.out.println("Date Format with MM/dd/yyyy : "+strDate);
           
           formatter = new SimpleDateFormat("hh:mm:ss");
           String strtime = formatter.format(date);  
           System.out.println("TIme is  "+strtime);
           
           // String sql="INSERT INTO allentries VALUES(' " +rcvinfo.prn+" ' , '" +rcvinfo.date+"' , '" + rcvinfo.time +"' , '" + rcvinfo.key +"' , '" +rcvinfo.value+"');";
           String sql="INSERT INTO allentries VALUES('ADMIN' , '"+strDate+"' , '"+strtime+"' , 'admin' , 'active');";

           Statement st=conn.createStatement();
           int rs = st.executeUpdate(sql);
           System.out.println(rs);
           System.out.println("FFFFFFFFFFFF");
           
       }
       catch(Exception ex)
       {
           System.out.println("thjafn af");        	
           System.out.println(ex.getMessage());
       }
       
        


       
        ChatServer server = new ChatServer(port);


        
        server.execute();
    }
 
    /**
     * Delivers a message from one user to others (broadcasting)
     */
    void broadcast(String message, UserThread excludeUser) {
        for (UserThread aUser : userThreads) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }

    

    void setUI(){
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();

        for (String user : userNames){
            System.out.println(user);
            frame.add(new JButton(user));
        }
        frame.validate();

    }
 
    /**
     * Stores username of the newly connected client.
     */
    void addUserName(String userName) {
//        userNames.add(userName);
//        window.add_user(userName, "active");        
//        
        Panel panel=new Panel(); 
        panel.setLayout(new BorderLayout(0, 0)); 
        panel.setBounds(40,80,200,200);    
        panel.setBackground(Color.lightGray);  

        Label b1=new Label("USER ACTIVE");     
        b1.setBounds(50,100,80,30);    
        b1.setBackground(Color.green);   
        panel.add(b1,BorderLayout.SOUTH);

        Label b2 =new Label("PRN is " + userName);     
        b2.setBounds(50,100,80,30);    
        b2.setBackground(Color.yellow);
        panel.add(b2,BorderLayout.NORTH);
        JLabel jLabel1 = new javax.swing.JLabel();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons8_Contacts_25px.png.png"))); // NOI18N
        
        frame.add(panel);
        

    }
 
    /**
     * When a client is disconneted, removes the associated username and UserThread
     */
    void removeUser(String userName, UserThread aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }
 
    Set<String> getUserNames() {
        return this.userNames;
    }
 
    /**
     * Returns true if there are other users connected (not count the currently connected user)
     */
    boolean hasUsers() {
        return !this.userNames.isEmpty();
    }
}