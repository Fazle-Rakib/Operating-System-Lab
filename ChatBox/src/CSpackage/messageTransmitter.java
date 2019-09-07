package CSpackage;

import CSpackage.MessageListener;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rakib
 */

public class messageTransmitter extends Thread{
    private String message,hostname,user;
    private int port;
    
    public messageTransmitter(){}
    public messageTransmitter(String mes,String host,int port){
        this.message = mes;
        this.hostname = host;
        this.port = port;
    }
    
    public void run(){
        try {
            Socket s = new Socket(hostname,port);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(messageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
