//File:Animal.java
package zoo;
public class Animal
{
public void sound()
{
System.out.println("Animal makes a sound");
}
}
//File:Soundable.java
package zoo;

public interface soundable
{
void makesound();
}
//File:Dog.java
package zoo;

public class Dog extends Animal implements soundable
{
@Override
public void sound()
{
System.out.println("Dog barks");
}
@Override
public void makesound()
{
System.out.println("DOg makes a sound");
}
}
//File:Cat.java
package zoo;
public class Cat implements soundable
{
@Override
public void makesound()
{
System.out.println("cat meows");
}
}
//File:Main.java
import zoo.*;

public class Main
{
public static void main(String[]args)
{
Animal animal=new Animal();
animal.sound();
DOg dog=new DOg();
dog.sound();
dog.makesound();
Cat cat=new Cat();
cat.makesound();
Soundable soundable=new Dog();
soundable.makesound();
soundable=new Cat();
soundable.makesound();
}
}





