
 import java.io.*;
import java.sql.*;
import javax.swing.*;
import sun.jdbc.odbc.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.Random;
import javax.swing.border.*;
import java.net.*;
public class Sample extends JPanel implements ActionListener
{
static final int packetsize=1024;
static BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
JLabel l1=new JLabel("USERNAME:");
JLabel l2=new JLabel("PASSWORD:");
JLabel l3=new JLabel("SEX:");
JLabel l4=new JLabel("YOUR SCHOOL NAME:");
JLabel l5=new JLabel("YOUR FAVOURITE MOVIE:");
JLabel l6=new JLabel("YOUR FAVOURITE DISH:");
JTextField t1=new JTextField(10);
JPasswordField t2=new JPasswordField(10);
JTextField t3=new JTextField(10);
JTextField t4=new JTextField(10);
JTextField t5=new JTextField(10);
JTextField t6=new JTextField(10);
JButton b1=new JButton("REGISTER");
JButton b2=new JButton("NEXT");
JButton b3=new JButton("EXIT");
JPanel nor, cen, sou, back;
public Sample()
{
JFrame fr=new JFrame(" User Registration");
Container c=fr.getContentPane();
back = new JPanel();
nor = new JPanel();
cen = new JPanel();
sou = new JPanel();
back.setLayout(new BorderLayout());
nor.setLayout(new FlowLayout());
cen.setLayout(new FlowLayout());
sou.setLayout(new FlowLayout());
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);

nor.add(l1);
nor.add(t1);

nor.add(l2);
t2.setEchoChar('*');
nor.add(t2);

nor.add(l3);
nor.add(t3);

cen.add(l4);
cen.add(t4);

cen.add(l5);
cen.add(t5);

cen.add(l6);
cen.add(t6);

sou.add(b1);
sou.add(b2);
sou.add(b3);
back.setBorder(new BevelBorder(BevelBorder.LOWERED));
back.add(nor, BorderLayout.NORTH);
back.add(cen, BorderLayout.CENTER);
back.add(sou, BorderLayout.SOUTH);
c.add(back);
setLocation(225, 240);
fr.setSize(500,500);
fr.setVisible(true);
fr.show();
}
public void actionPerformed(ActionEvent e)
{
String s=e.getActionCommand();
String s1=t1.getText();
String s2=t2.getText();
String s3=t3.getText();
String s4=t4.getText();
String s5=t5.getText();
String s6=t6.getText();

if(s.equals("REGISTER"))
{
disp(s1,s2,s3,s4,s5,s6);

}

if(s.equals("NEXT"))
{
NextPage h=new NextPage(); 
h.show();
}
if(s.equals("EXIT"))
{
System.exit(0);
}
}
 


public void disp(String m1,String m2,String m3,String m4,String m5,String m6)
{
DatagramPacket packet;
byte[] data1;
byte[] data2; 
byte[] data3;
byte[] data4;
byte[] data5;
byte[] data6;
byte[] data7;
DatagramSocket socket;
int port=9999;
String s="172.25.1.170";
String messagereturn;
 

try
{
InetAddress address=InetAddress.getByName(s);
if(m1.length()==0)
{
System.exit(0);
}
socket=new DatagramSocket();
data1=m1.getBytes();
packet=new DatagramPacket(data1,data1.length,address,port);
socket.send(packet);

data2=m2.getBytes();
packet=new DatagramPacket(data2,data2.length,address,port);
socket.send(packet);

data3=m3.getBytes();
packet=new DatagramPacket(data3,data3.length,address,port);
socket.send(packet); 

data4=m4.getBytes();
packet=new DatagramPacket(data4,data4.length,address,port);
socket.send(packet);

data5=m5.getBytes();
packet=new DatagramPacket(data5,data5.length,address,port);
socket.send(packet);

data6=m6.getBytes();
packet=new DatagramPacket(data6,data6.length,address,port);
socket.send(packet);
JOptionPane.showMessageDialog(this,"Registering.............");

 
}

catch(IOException ioe)
{System.out.println("Could not receive:"+ioe.getMessage());
System.exit(0);
}
}
 
 
public static void main(String args[])
{

Sample s=new Sample();
s.setSize(500,500);
s.setVisible(true);
 
}
}

