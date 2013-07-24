import java.io.*;
import java.sql.*;
import javax.swing.*;
import sun.jdbc.odbc.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.Random;
import javax.swing.border.*;
public class Mainpro extends JPanel implements ActionListener
{
JLabel l1=new JLabel("TRIGON BASED DUAL AUTHENTICATION");   
 
JButton b1=new JButton("NEW USER");
JButton b2=new JButton("EXISTING USER");
JButton b3=new JButton("EXIT");
JPanel nor, cen, sou, back;
public Mainpro()
{ 
JFrame fr=new JFrame("Trigon Based Dual Authentication  "); 
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
if(s.equals("NEW USER"))
{
Sas h=new Sas(); 
h.show();
}
if(s.equals("EXISTING USER"))
{
NextPage h=new NextPage(); 
h.show();
}
if(s.equals("EXIT"))
{
System.exit(0);
}
}
public static void main(String args[])
{
Mainpro s=new Mainpro();
s.setSize(500,500);
s.setVisible(true); 
}
}