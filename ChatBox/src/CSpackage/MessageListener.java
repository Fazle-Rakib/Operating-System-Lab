package CSpackage;


import CSpackage.writeableGui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rakib
 */
public class MessageListener extends Thread{
    private ServerSocket server;
    private String name,nam;
    private int port = 8877;
    private writeableGui gui;
    public MessageListener(writeableGui gui,int port,String s) throws IOException
    {
        this.gui = gui;
        this.port = port;
        server = new ServerSocket(port);
        this.nam = s;
    }
    public void Host(String s)
    {
        this.name = s;
    }
    public MessageListener(){
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run(){
        Socket clientSocket;
        try {
            while((clientSocket = server.accept()) != null)
            {
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();
                if(line !=null)
                {
                    gui.write("Friend : "+line);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
