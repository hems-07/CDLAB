package javaLab;

import java.io.*;
import java.net.*;
public class ClientElection {
	  public static void main(String args[])throws Exception{  

		    Socket s=new Socket("localhost",3333);  
		    DataOutputStream dout=new DataOutputStream(s.getOutputStream());  

		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		    String str="",str2="";  
		    while(!str.equals("stop")){  
		      str=br.readLine();  
		      dout.writeUTF(str);  
		      dout.flush();  
		      str2=new DataInputStream(s.getInputStream()).readUTF(); 
		      System.out.println("Server says: "+str2);
		    }

		    dout.close();  
		    s.close();  
		  }
}

import java.io.*;
import java.net.*;
public class ServerElection {
	  public static void main(String args[])throws Exception { 

		    ServerSocket ss = new ServerSocket(3333);
		    Socket s = ss.accept();
		    DataInputStream din=new DataInputStream(s.getInputStream());  
		    DataOutputStream dout=new DataOutputStream(s.getOutputStream());

		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		    String str="",str2="";
		    while(!str.equals("stop")){
		      str=din.readUTF();
		      if(Integer.parseInt(str) >= 18){
		         str2="You are eligible to vote";  
		      }else{
		         str2="You are not eligible to vote";
		      }
		      dout.writeUTF(str2); 
		      dout.flush();
		    }
		    din.close();
		    s.close();
		    ss.close();
		  }
}
