/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threadSync;

import static com.threadSync.MainClass.Lock;
import static com.threadSync.MainClass.balance;
import static com.threadSync.MainClass.j;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FAZLE RAKIB
 */
class A
{
    public void getDeposite(int value) throws InterruptedException
    {
        Lock = true;
        balance -= value;
        System.out.println("Balance After Operation : " + balance);  
        Lock = false;      
    }
}
class B extends Thread
{
    A a = new A();
    int value,i;
    B(int value,int i)
    {
        this.value = value;
        this.i = i;
    }
    public void run()
    {
        while(true)
        {
            //System.out.println(Lock + " " + j + " " + i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!Lock && i == j)
            {   
               try {
               a.getDeposite(value);
               //Thread.sleep(200);
               } catch (InterruptedException ex) {
                   Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
               }
               j = j + 1;
                break;
            }
        } 
       
    }
}
public class MainClass {
    public static int balance = 100000;
    public static boolean Lock = false;
    public static int j = 1;
    public static void main(String[] args) throws InterruptedException {
        B b1 = new B(1000,1);
        B b2 = new B(500,2);
        B b3 = new B(700,3);
        B b4 = new B(800,4);
        b1.start();
        b2.start();
        b3.start();
        b4.start();
        b1.join();
        b2.join();
        b3.join();
        b4.join();
        Thread.sleep(1000);
    }
}
