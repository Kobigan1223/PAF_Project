
public class QueueX {

	
	private int  queueArr[];
	private int maxSize;
	private int rear;
	private int front;
	private int	 noItems;
	
	public QueueX(int s) {
		
		
		maxSize = s;
		queueArr = new int[maxSize];
		rear = -1;
		front = 0;
		noItems = 0;
	}
	
	public void insert(int j)  //Remove Method
	{
		if(rear==maxSize-1)  //if the Queue is  full
		{
		  System.out.println("Queue is Full");
		}
		else                  //if the Queue is  not full
		{
		   queueArr[++rear]=j;
		   noItems++;
		}
	}
	public int remove()        //Remove Method
	{
        if(noItems==0)         //if the Queue is  empty
        {
        	System.out.println("Queue is empty");
        	return -99;
        }
        else                    //if the Queue is not empty
        {
        	noItems--;
        	return queueArr[front++];
        }
	}
	
	public boolean isEmpty()  //Check my array is empty
	{
        return (noItems ==0) ; //it will return true
		
	}
    
	public boolean isFull()  //Check my array is full
	{
		return (noItems ==maxSize);
		
	}
	
}
