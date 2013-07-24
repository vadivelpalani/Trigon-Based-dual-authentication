import java.io.*;
import java.sql.*;
import javax.swing.*;
import sun.jdbc.odbc.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.Random;
import javax.swing.border.*;
public class NextPage extends JPanel implements ActionListener
{
    
JLabel l1=new JLabel("USERNAME:");
JLabel l2=new JLabel("PASSWORD:");
JTextField t1=new JTextField(20);
JPasswordField t2=new JPasswordField(20);
JButton b2=new JButton("LOGIN");
JButton b3=new JButton("EXIT");

JPanel nor, cen, sou, back;
public NextPage()
{ 
JFrame fr=new JFrame(" User Authentication");
Container c=fr.getContentPane();
back = new JPanel();
nor = new JPanel();
cen = new JPanel();
sou = new JPanel();
back.setLayout(new BorderLayout());
nor.setLayout(new FlowLayout());
cen.setLayout(new FlowLayout());
sou.setLayout(new FlowLayout());   
b2.addActionListener(this);
b3.addActionListener(this);
nor.add(l1); 
nor.add(t1);
cen.add(l2);
t2.setEchoChar('*');
cen.add(t2);
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
int t=0;
String s1=t1.getText();
char a[]=t2.getPassword();
String s2=new String(a);  
if(s.equals("LOGIN"))
{
double al=0.0;
al=auth(s1);
authenticate(s1,s2,al);
}
if(s.equals("EXIT"))
{
System.exit(0);
}
}
public void val()
{
try
{
String query3 = "select * from details";
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("Jdbc:Odbc:pentagon");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query3);
String sx, sy, sz;
String q2 = JOptionPane.showInputDialog(this, "Enter your School name");
String q3 = JOptionPane.showInputDialog(this, "Enter your Favourite movie");
String q4 = JOptionPane.showInputDialog(this, "Enter your Favourite dish");
while (rs.next())
    {
	sx = rs.getString("school");
        sy = rs.getString("movie");
        sz = rs.getString("dish");
        if ((q2.equals(sx)) && (q3.equals(sy)) && (q4.equals(sz)) )
        {
	JOptionPane.showMessageDialog(this,"Valid verification");
	} 
else
{
JOptionPane.showMessageDialog(this,"Wrong verfication");
}
}
}
catch(Exception e)
{
System.out.println("Exception in authentication :"+e);
}	
}
public double auth(String name)
{
double ap=0.0;
try
{
String nam="";
 String query = "select * from ass";
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("Jdbc:Odbc:pentagon");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
 
int exist=0,m=0,fag=0;
while (rs.next())
{nam = rs.getString(1);
if(nam.equals(name))
{
ap = Double.parseDouble(rs.getString(2));
}
}
}
catch(Exception e)
{
System.out.println("Exception in authentication :"+e);
}
return ap;
}
public void authenticate(String name, String pword,double alp)
{
try
{
String nam="";double p=0.0,v=0.0,alpha=0.0;
alpha=alp;
String query = "select * from bs";
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("Jdbc:Odbc:pentagon");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
 
int exist=0,m=0,fag=0;
while (rs.next())
{nam = rs.getString(1);
//System.out.println("Inside while");
if(nam.equals(name))
{System.out.println("user is   :"+nam);
//System.out.println("found");
m=1;fag=1;
p = Double.parseDouble(rs.getString(2));
v = Double.parseDouble(rs.getString(3));
break;
}//else
// System.out.println(name);
}
  
if(fag==0)
{
JOptionPane.showMessageDialog(this, "You are not an authenticated user");
}
else // this is 4 above  if else
{
System.out.println("p="+p);
System.out.println("v="+v);
System.out.println("alpha="+alpha);
double ati=0.0;
v=Math.pow(v, 2);
ati=(alpha+v);
ati=(ati/(2*p));
System.out.println("ati="+ati);
String s = pword; pword = new String("");
for (int i=0; i<s.length();i++)
{
//System.out.println("ASCII value of: "+s.charAt(i) + " is:"+ (int)s.charAt(i) );
pword=pword+(int)s.charAt(i);
}
double pi,ai,x,y;
System.out.println("pword="+pword);
String lastDigit = pword.substring(pword.length()*3/4,pword.length()); // first 3digits
String halfDigit = pword.substring(0,pword.length()*3/4);
double deg = Double.parseDouble(halfDigit);
System.out.println("halfDigit1="+halfDigit);
System.out.println("deg1="+deg);
deg = deg % 180;
System.out.println("deg="+deg);
pword = pword.replace(halfDigit, ""+((int)deg));
System.out.println("halfDigit2="+pword);
halfDigit = pword.substring(0,3);
System.out.println("halfDigit3="+halfDigit);
//int fan=(int)deg;
//halfDigit=""+fan;
int pai;
int ld=Integer.parseInt(lastDigit);
halfDigit=halfDigit+ld;
pai=Integer.parseInt(halfDigit);
System.out.println("halfDigit="+pai);
double n=halfDigit.length();
if(pai>=180)
{
pi=pai/(Math.pow(10, n-2));
}
else
{
pi=pai/(Math.pow(10, n-3));
}
ai=pi/2;
System.out.println("ai="+ai);
x=Math.sin(ai)*Math.sin(ai);
y=((1-(ati))/2);
System.out.println("y1="+y);
y=Math.floor(Math.sqrt(y));y=1;
System.out.println("x="+x+"y="+y);
if(m==y)
{
 JOptionPane.showMessageDialog(this,"you are an authenticated user");
 val();
 }
else
{
JOptionPane.showMessageDialog(this,"you are not an  authenticated user");
}}}
catch(Exception e)
{
System.out.println("Exception in authentication :"+e);
}}
public static void main(String args[])
{
NextPage s=new NextPage();
s.setSize(300,300);
s.setVisible(true);
}
}














 
 
  
   
     
     
     
