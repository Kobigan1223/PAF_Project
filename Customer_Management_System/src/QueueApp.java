import java.util.Scanner;

public class QueueApp {
  public static void main(String[] args)
  {

	  QueueX mainQueue=new QueueX(5);    //create a array object with size 5
	  Scanner sc = new Scanner(System.in);
	  int inputStr;

	  for(int i=1;i<5;i++)
	  	{
		  	System.out.println("Enter Transaction ID "+ i +":");
		  	inputStr =sc.nextInt();
		  	mainQueue.insert(inputStr);
	  	}

//PC 1 Queue - Even Number
QueueX EvenQueue=new QueueX(5); 

//PC 1 Queue - odd Number
QueueX oddQueue=new QueueX(5); 

int value ;

while(!mainQueue.isEmpty());  //checking our main queue is full or empty
{
    value=mainQueue.remove();
	if(value %2==0)   //check id is even
		{
			EvenQueue.insert(value);  //if is it even it will added in to even queue
		}
	else               //check id is odd
		{
			oddQueue.insert(value);  //if is it odd it will added in to odd queue
		}
}


  //pc1 transaction id's
System.out.print("pc 1");
while(!EvenQueue.isEmpty())
	{
	System.out.println("Transaction"+EvenQueue.remove());
	}

//pc2 transaction id's
System.out.println("pc 1");
while(!oddQueue.isEmpty())
	{
	System.out.println("Transaction"+oddQueue.remove());
	}
}
  }