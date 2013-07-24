import java.io.*;
import java.sql.*;
import javax.swing.*;
import sun.jdbc.odbc.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.Random;
import javax.swing.border.*;
public class MainMenu extends JPanel implements ActionListener
{
JLabel l1=new JLabel("TRIGON BASED DUAL AUTHENTICATION");   
JButton b1=new JButton("NEW USER");
JButton b2=new JButton("EXISTING USER");
JButton b3=new JButton("EXIT");
JButton b4;
ImageIcon im;
JPanel nor, cen, sou, back;
public MainMenu()
{ 
JFrame fr=new JFrame("Trigon Based Dual Authentication  "); 
Container c=fr.getContentPane();
back = new JPanel();
nor = new JPanel();
cen = new JPanel();
sou = new JPanel();
im=new ImageIcon("tri.jpg");
b4=new JButton("TRIGON",im);
back.setLayout(new BorderLayout());
nor.setLayout(new FlowLayout());
cen.setLayout(new FlowLayout());
sou.setLayout(new FlowLayout());


b4.setActionCommand("TRIGON");  
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this); 
b4.addActionListener(this); 
nor.add(l1); 

 
b4.setBounds(50,50,600,400);
c.add(b4); 
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
 Sample h=new Sample(); 
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
MainMenu s=new MainMenu();
s.setSize(500,500);
s.setVisible(true); 
}
}