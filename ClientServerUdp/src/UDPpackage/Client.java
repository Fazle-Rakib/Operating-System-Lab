/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPpackage;

/**
 *
 * @author rakib
 */
import java.io.*;  // Imported because we need the InputStream and OuputStream classes
import java.io.BufferedReader;
import java.net.*; // Imported because the Socket class is needed
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Client
{
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Name : ");
		String name = scanner.nextLine();
		
		System.out.print("Source Port : ");
		int sourcePort = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Destination IP : ");
		String destinationIP = scanner.nextLine();
		
		System.out.print("Destination Port : ");
		int destinationPort = Integer.parseInt(scanner.nextLine());
		
		Channel channel = new Channel();
		channel.bind(sourcePort);
		channel.start();
		
		System.out.println("Binded.");
		
		InetSocketAddress address = new InetSocketAddress(destinationIP, destinationPort);
		
		while(true)
		{
			String msg = scanner.nextLine();
			
			if(msg.isEmpty())
				break;
			
			msg = name + " : " + msg;
			
			channel.sendTo(address, msg);
			System.out.println(msg);
		}

		scanner.close();
		channel.stop();
		
		System.out.println("Closed.");
	}
}
