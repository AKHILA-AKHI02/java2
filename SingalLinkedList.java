import java.util.Scanner;
class Link
 {
 private int data;
 public Link link;
 public Link(int data)
{
         this.data=data;
	     link=null;
 }
	public Link(int data,Link link)
	{
         this.data=data;
	     this.link=link;   
   }
 public String Data()
 {
	 return data+"-->";
 }
}
class SingleLinkedList
{
	private Link head;
	private int size;
	public SingleLinkedList()
	{
	 head=null;
	 size=0;
	}
	public boolean isEmpty()
	{
		return head==null;
	}
	public void addFront(int data)
	{
		if(head==null)
	       head=new Link(data,null);
	    else
		{
			Link newLink=new Link(data,head);
			newLink.link=head;
			head=newLink;
		}
	size++;
	}
	public void addLast(int data)
	{
		if(head==null)
			head=new Link(data,null);
		else
		{
			Link current=head;
			while(current.link!=null)
				current=current.link;
			Link newLink=new Link(data,null);
			current.link=newLink;
		}
		size++;
	}
	public void addAny(int data,int pos)
	{
		if(head==null)
			head=new Link(data,null);
			Link current =head;
		for(int i=1;i<pos;i++)
			current=current.link;
		    Link newLink=new Link(data,null);
			newLink.link=current.link;
			current.link=newLink;
			size++;
	}
	public void deleteAny(int pos)
	{
		if(head==null)
			return;
		Link current=head;
		for(int i=1;i<pos;i++)
			current=current.link;
		    current.link=current.link.link;
			size--;
	}
	public void deleteFront()
	{
		if(head==null)
			System.out.println("List is Empty");
		else
		{
			Link del=head;
			head=del.link;
		}
		size--;
	}
	public void deleteLast()
	{
	 if(head==null)
		 System.out.println("List is empty");
	 if(head.link==null)
		{
		 head=null;
		 size--;
		}
		Link current=head;
		while(current.link.link!=null)
			current=current.link;
		current.link=null;
		size--;
	}
	public void print()
	{
		if(head==null)
			System.out.println("List is empty..");
		    Link current=head;
			while(current.link!=null)
		    {
			 System.out.println(current.Data());
			 current=current.link;
			}
			System.out.println(current.Data()+"null");
			System.out.println();
	} 
	     public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		SingleLinkedList s=new SingleLinkedList();
		int info,pos;
		while(true)
		{
			System.out.println("Menu");
			System.out.println("/n/t/\t 1.Add Node AtFront /n/t 2.Add Node AtRear /n/t/t 3.Remove AtFront /n/t/t 4.Remove AtLast /n/t/t  5.Add node AtPosition /n/t/t 6.Remove node AtAnyPosition /n/t/t 7.Display elements in list /n/n");
			System.out.println("\n Enter your choice /n");
			int choice =sc.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Enter data part to a node ");
				        info=sc.nextInt();
					s.addFront(info);
					break;
				case 2:
					System.out.println("Enter data part to a node");
				        info=sc.nextInt();
					s.addLast(info);
					break;
				case 3:
					s.deleteFront();
			                System.out.println("\n Front node is deleted");
					break;
				case 4:
					s.deleteLast();
				        System.out.println("\n node is deleted");
					break;
				case 5:
					System.out.println("Enter the data part to the node");
				        info=sc.nextInt();
					System.out.println("Enter the position where you insert a node in list");
					pos=sc.nextInt();
					s.addAny(info,pos);
					break;
				case 6:
					System.out.println("Enter the position where you delete a node in a list");
				        pos=sc.nextInt();
					s.deleteAny(pos);
					break;
				case 7:
					System.out.println();
                    break;
				default:
					System.out.println("You are selection is not there in menu");
			}
			     System.out.println("\n\n Do you want to continue---\n press Yory for yes ||norN for(No)");
			     char ch=sc.next().charAt(0);
			      if(ch=='n'||ch=='N')
			{
				System.out.println("\n\n Thank you see you again...\n\n");
				break;
			}
		}
  }
}