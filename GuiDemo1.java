import java.awt.*;
import java.awt.Color; 
class GuiDemo1 extends Frame
{
TextField tf1,tf2;
Label l1,l2;
Button b1,b2;
public GuiDemo1()
{
tf1=new TextField();
tf2=new TextField();
l1=new Label("USERNAME");
l2=new Label ("PASSWORD");
b1=new Button("signin");
b2=new Button("signup");
l1.setBounds(100,90,90,30);
tf1.setBounds(210,90,70,30);
l2.setBounds(100,130,70,30);
tf2.setBounds(210,130,70,30);
b1.setBounds(100,260,70,40);
b2.setBounds(180,260,70,40);
add(l1);
add(tf1);
add(l2);
add(tf2);
add(b1);
add(b2);
setSize(300,300);
setLayout(null);
setVisible(true);
setBackground(Color.GREEN);
}
public static void main(String[]args)
{
new GuiDemo1();
}
}





