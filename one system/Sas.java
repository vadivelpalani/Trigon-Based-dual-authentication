import java.io.*;
import java.sql.*;
import javax.swing.*;
import sun.jdbc.odbc.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.Random;
import javax.swing.border.*;
public class Sas extends JPanel implements ActionListener
{
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
public Sas()
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
register(s1,s2,s3,s4,s5,s6);
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
public double prime()
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
public void register(String uname,String pass,String s,String sn,String fa,String di)
{

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
JOptionPane.showMessageDialog(this,"Registered Successfully");  
}
con.close();

}

catch(Exception sql)
{
System.out.println("Sql exception :"+sql);
JOptionPane.showMessageDialog(this,"Please fill all details");
}}

public double getDegree(String pword)
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
 
public static void main(String args[])
{

Sas s=new Sas();
s.setSize(500,500);
s.setVisible(true);
 
}
}

