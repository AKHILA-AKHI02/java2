import  java.util.Scanner;
class Node
{
int data;
Node link;
}
class SingalLink
{
Node head;
public void insertF(int x)
 {
 Node  temp=new Node();
    if(temp==null)
     {
   System.out.println("no insertion");
     }
    else
     {
    temp.link=head;
    temp.data=x;
     head=temp;
      }
  }
public void print()
{
Node ptr=head;
  while(ptr!=null)
   {
    System.out.print(ptr.data+"   ");
      ptr=ptr.link;
    }
}
public static void main(String[] args)
  {
Scanner  sc=new Scanner(System.in);
SingalLink  s=new SingalLink();
System.out.println("Enter the number of elements in singalLinked List");
int n=sc.nextInt();
for(int i=0;i<n;i++)
{
  System.out.println("enter the elements"+"  "+( i+1)+":");
   int m=sc.nextInt();
    s.insertF(m);
   }
  System.out.println("display the list elements");
  s.print();
   }
}
