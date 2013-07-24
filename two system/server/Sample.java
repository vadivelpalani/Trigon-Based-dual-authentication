import java.net.*;
import java.io.*;
 import java.io.*;
import java.sql.*;
import javax.swing.*;
import sun.jdbc.odbc.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.Random;
import javax.swing.border.*;

public class Sample
{
static final int port=9999;
static final int packetsize=1024;
public static void main(String args[])throws IOException
{
DatagramPacket packet1,packet2,packet3,packet4,packet5,packet6,packet7;
DatagramSocket socket;
byte[] data1;
byte[] data2;
byte[] data3;
byte[] data4;
byte[] data5;
byte[] data6;
byte[] data7;
String msg="ok"; 

String uname,pass,s,sn,fa,di;
int recvsize;
InetAddress address;
int clientport;
socket=new DatagramSocket(port); 
data1=new byte[packetsize];
packet1=new DatagramPacket(data1,packetsize);

data2=new byte[packetsize];
packet2=new DatagramPacket(data2,packetsize);

data3=new byte[packetsize];
packet3=new DatagramPacket(data3,packetsize);

data4=new byte[packetsize];
packet4=new DatagramPacket(data4,packetsize);

data5=new byte[packetsize];
packet5=new DatagramPacket(data5,packetsize);

data6=new byte[packetsize];
packet6=new DatagramPacket(data6,packetsize);
System.out.println("To receive packets or port:"+port);

socket.receive(packet1);
socket.receive(packet2);
socket.receive(packet3);
socket.receive(packet4);
socket.receive(packet5);
socket.receive(packet6);
 
 
recvsize=packet1.getLength();
uname=new String(data1,0,recvsize);
System.out.println("Username:"+uname.trim());
 
recvsize=packet2.getLength();
pass=new String(data2,0,recvsize);
//System.out.println("Message from adddress:"+pass.trim());

recvsize=packet3.getLength();
s=new String(data3,0,recvsize);
//System.out.println("Message from adddress:"+s.trim());

recvsize=packet4.getLength();
sn=new String(data4,0,recvsize);
//System.out.println("Message from adddress:"+sn.trim());

recvsize=packet5.getLength();
fa=new String(data5,0,recvsize);
//System.out.println("Message from adddress:"+fa.trim());

recvsize=packet6.getLength();
di=new String(data6,0,recvsize);
//System.out.println("Message from adddress:"+di.trim());


try
{
System.out.println("you are in ");
String name;
String name1=uname;
System.out.println("username="+name1);
String query = "select * from ass";
String query2 = "select * from bs";
String query4 = "select * from details";

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("Jdbc:Odbc:pentagon");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
int exist=0;

while (rs.next())
{
name = rs.getString(1);
//System.out.println("Inside while");
if(name.equals(name1))
{
System.out.println("found");
exist=1;
break;
}

//else
// System.out.println(name);
}

if(exist==1)
{
System.out.println("already exist try again ");
System.exit(0);}
else{
double a = prime();
double b = prime();
System.out.println("a = "+a+" b = " + b);
double pro =  a * b;
double vari = a - b;
//System.out.println("product value="+pro);
//System.out.println("variance="+vari);
double degree = getDegree(pass);
if(degree >90D)
{
degree = 180D - degree;
}
double angle = (degree) * (Math.PI/180D);
double h = b * Math.sin(angle);
double reminderSide = Math.abs(a - Math.sqrt((Math.pow(b, 2) - Math.pow(h, 2))));
double c = Math.sqrt((Math.pow(h, 2) + Math.pow(reminderSide, 2)));
double cStar = Math.pow(c, 2);
double alpha = (2*pro) - cStar;
 
//System.out.println("Alpha value="+alpha); 
String query1="insert into ass values('"+name1+"','"+alpha+"')";
stmt.executeUpdate(query1);
String query3="insert into bs values('"+name1+"','"+pro+"','"+vari+"')";
stmt.executeUpdate(query3);
String query5="insert into details values('"+name1+"','"+s+"','"+sn+"','"+fa+"','"+di+"')";
stmt.executeUpdate(query5); 
System.out.println("Registered Successfully");  

}
con.close();
}

catch(Exception sql)
{
System.out.println("Sql exception :"+sql);
}
 
}
 

public static double getDegree(String pword)
{
double pas = 0.0;
String s = pword; pword = new String("");
for (int i=0; i<s.length();i++)
{
pword=pword+(int)s.charAt(i);
}        String halfDigit = pword.substring(0,pword.length()*3/4);
double deg = Double.parseDouble(halfDigit);
deg = deg % 180;
pword = pword.replace(halfDigit, ""+((int)deg));
halfDigit = pword.substring(0,3);
deg = Integer.parseInt(halfDigit);
if(deg<180)
{
pword = pword.replace(pword.substring(3), "."+pword.substring(3));
}
else
pword = pword.replace(pword.substring(2), "."+pword.substring(2));
pas = Double.parseDouble(pword);
System.out.println("Pi : "+pas);
return pas;
}



public static double prime()
{
int number=0,nope=0;
Random r = new Random();
number =Math.abs( r.nextInt());
number=number%1000000;
//System.out.println(number);
if(number%2 == 0)
number = number+1;
boolean status = true;
while((number -= 2)>0)
{//System.out.println(number);
status = true;
if (number == 1 || number == 2)
return number;
for (int i=2; i<(int)(number/2); i++)
{
if(number%i == 0)
status = false;
if(!status)
i = number;
}
if(status)
break;
}
return number;
}
}
