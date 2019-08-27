/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cspackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author FAZLE RAKIB
 */
public class Client {
    public static void main(String[] args) throws IOException {
        int number,temp;
        String line,line2;
        Scanner sc = new Scanner(System.in);
        String
        Socket s = new Socket("10.100.168.159",9999);
        Scanner sc1 = new Scanner(s.getInputStream());
        System.out.println("Enter :");
        line = sc.nextLine();
        PrintStream p = new PrintStream(s.getOutputStream());
        p.println(line);
        line2 = sc1.nextLine();
        System.out.println(line2);
    }
}
/*
input = new DataInputStream(System.in);
        out = new DataOutputStream(socket.getOutputStream());
        
        String line = "";
        while(!line.equals("Over"))
        {
            line = input.readUTF();
            out.writeUTF(line);
        }
        input.close();
        out.close();
        socket.close();
*/
/*
private Socket socket = null;
    private DataInputStream input  = null;
    private DataOutputStream out = null;
    
    public Client(String address,int port) throws IOException{
        socket = new Socket(address,port);
        System.out.println("Conneted to Server...");
        String line;
        Scanner sc = new Scanner(System.in);
        line = sc.nextLine();
        PrintStream p = new PrintStream(socket.getOutputStream());
        p.println(line);
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Here");
        Client client = new Client("127.0.0.1",1342);
        
    }
*/