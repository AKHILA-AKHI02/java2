class Y
{
int n=10;
}
class x extends Y
{
int n=20;
void display()
{
System.out.println(n);
System.out.println(super.n);
}
}
class Test
{
public static void main(String[]args)
{
x obj=new x();
obj.display();
}
}

