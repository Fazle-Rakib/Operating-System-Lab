/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cspackage;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author FAZLE RAKIB
 */
public class Server {
    public static void main(String[] args) throws IOException {
        String line,line1;
        ServerSocket s1 = new ServerSocket(9999);
        Socket ss = s1.accept();
        Scanner sc = new Scanner(ss.getInputStream());
        line = sc.nextLine();
        System.out.println(line);
        line1 = "get Message!";
        PrintStream p = new PrintStream(ss.getOutputStream());
        p.println(line1);
    }
}
/*10.100.168.155*/
/*
 private Socket socket = null;
    private ServerSocket server1 = null;
    private DataInputStream input  = null;
    public Server(int port) throws IOException{
        server1 = new ServerSocket(port);
        System.out.println("Server started");
        System.out.println("Waiting for Client....");
        socket = server1.accept();
        System.out.println("Client Accepted");
        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String line = "";
        while(!line.equals("Over"))
        {
            line = input.readUTF();
            System.out.println("line");
        }
        //socket.close();
        //input.close();
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server(1342);
    }
*/