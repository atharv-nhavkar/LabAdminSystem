 
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

 

public class UserThread extends Thread {
    private Socket socket;
    private Server server;
    private PrintWriter writer;
 
    public UserThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }
 
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
            OutputStream output = socket.getOutputStream();
            ObjectInputStream getobj = new ObjectInputStream(socket.getInputStream());

            writer = new PrintWriter(output, true);

            String userName = null;
 
            try {
                BasicInfo rcvinfo = (BasicInfo)getobj.readObject();    
                System.out.println(rcvinfo.prn);
                System.out.println(rcvinfo.date);
                System.out.println(rcvinfo.time);
                System.out.println(rcvinfo.time);
                System.out.println(rcvinfo.key);
                System.out.println(rcvinfo.value);

                try
                {
                    // String name="";
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
                    String sql="INSERT INTO allentries VALUES(' " +rcvinfo.prn+" ' , '" +rcvinfo.date+"' , '" + rcvinfo.time +"' , '" + rcvinfo.key +"' , '" +rcvinfo.value+"');";
                    // String sql="INSERT INTO allentries VALUES('2019bteit00032' , '07-10-2021' , '14.27' , 'password' , 'atharv');";

                    Statement st=conn.createStatement();
//                    int rs = st.executeUpdate(sql);
//                    System.out.println(rs);
                    // ek function call honar je Moodle DB madhun password ani PRN check karel If they are valid tr send client a callback ki Values valid aahet ! 
                    // assuming that the credentials are correct : 
                    sql="INSERT INTO allentries VALUES(' " +rcvinfo.prn+" ' , '" +rcvinfo.date+"' , '" + rcvinfo.time +"' , '" + "login" +"' , '" + "SUCCESS" + "');";
                    // String sql="INSERT INTO allentries VALUES('2019bteit00032' , '07-10-2021' , '14.27' , 'password' , 'atharv');";
                    st=conn.createStatement();
                    int rs = st.executeUpdate(sql);
                    System.out.println(rs);     
                    server.addUserName(rcvinfo.prn,rcvinfo.date,rcvinfo.time);
                    // server.setUI();
                    String serverMessage = "New user connected: " + userName;
                    System.out.println(serverMessage);
                    conn.close();
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
                userName = rcvinfo.prn;

            } catch (Exception e) {
                userName = null;
                System.out.println("exception in getting object  " + e.getMessage());
            }
            

            // printUsers();
 
//            if(userName != null){
//                server.addUserName(userName);
//                // server.setUI();
//                String serverMessage = "New user connected: " + userName;
//                System.out.println(serverMessage);
//    
//            }

            // server.broadcast(serverMessage, this);
 


            String clientMessage;
 
            do {
 
 
                    // clientMessage = reader.readLine();
                    // System.out.println(clientMessage);

                    try {
                        BasicInfo rcvinfo = (BasicInfo)getobj.readObject();    
                        System.out.println(rcvinfo.prn);
                        System.out.println(rcvinfo.date);
                        System.out.println(rcvinfo.time);
                        System.out.println(rcvinfo.time);
                        System.out.println(rcvinfo.key);
                        System.out.println(rcvinfo.value);
                        clientMessage = rcvinfo.value ; 
                    } catch (Exception e) {
                        clientMessage = "bye";
                        System.out.println("exception in getting object  " + e.getMessage());
                    }
            
                // String path = System.getProperty("user.dir") + "\\test.txt";
                
                // try {
                //     Files.write(Paths.get(path), clientMessage.getBytes(), StandardOpenOption.APPEND);
                // } catch (IOException e) {
                //     System.out.println("Error in UserThread: " + e.getMessage());
                // }
        

                // serverMessage = "[" + userName + "]: " + clientMessage;
                // server.broadcast(serverMessage, this);
 
            } while (!clientMessage.equals("bye"));
 
            if(userName != null){
            	try
                {
                    // String name="";
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        
                    } catch (Exception e) {
                        System.out.println("gotcha ");
                        System.out.println(e.getMessage());
                        System.out.println("gotcha ");
                        //TODO: handle exception
                    } 
                    
                    Date date = new Date();  
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
                    String strDate = formatter.format(date);  
                    System.out.println("Date Format with MM/dd/yyyy : "+strDate);
                    
                    formatter = new SimpleDateFormat("hh:mm:ss");
                    String strtime = formatter.format(date);  
                    System.out.println("TIme is  "+strtime);
                    
                    
                    String connUrl="jdbc:mysql://localhost/animal?";
                    Connection conn=DriverManager.getConnection(connUrl,"root","password");
                    String sql="INSERT INTO allentries VALUES(' " + userName +" ' , '" + strDate +"' , '" + strtime +"' , '" + "logout" +"' , '" + "SUCCESS" +"');";
                    // String sql="INSERT INTO allentries VALUES('2019bteit00032' , '07-10-2021' , '14.27' , 'password' , 'atharv');";

                    Statement st=conn.createStatement();
                    int rs = st.executeUpdate(sql);
                    System.out.println(rs);                    
                    conn.close();
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }

                server.removeUser(userName, this);
                socket.close();
                String serverMessage = userName + " has quitted.";
                System.out.println(serverMessage);
            }


            
 
        } catch (IOException ex) {
            System.out.println("Error in UserThread: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    /**
     * Sends a list of online users to the newly connected user.
     */
    void printUsers() {
        if (server.hasUsers()) {
            writer.println("Connected users: " + server.getUserNames());
        } else {
            writer.println("No other users connected");
        }
    }
 
    /**
     * Sends a message to the client.
     */
    void sendMessage(String message) {
        writer.println(message);
    }
}