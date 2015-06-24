//MA314 Ex 7.2 Ilham
public class Josephus {

	public static void main(String[] args)
	{
		//Evaluates J(m,n), where J is the Josephus function on NxN and
		//m is the first argument, n is the second argument given to 
		//the program
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		int temp;
		Queue queue = new Queue(m);
		for (int i = 1; i <= m ; i++)
			queue.enqueue(i);
		for (int i = 1; i<=m-1; i++)
		{
			for (int j = 1; j<= n-1; j++)
			{
				temp = queue.dequeue();
				queue.enqueue(temp);
			}
			queue.dequeue();
		}
		System.out.println(queue.dequeue());			
		
	}

}

class Queue
//Array based queue
{
 private int[] contents; // integer queue
 private int head, tail; // head points to entry at head
                 // tail points to first empty entry
 private boolean empty, full;

 public Queue()
 { // If no size is given when constructor is invoked, use 100.
     contents = new int[100];
     head = 0;
     tail = 0;
     empty = true;
     full = false;
 }

 public Queue(int size)
 { // With this constructor, the size of the array is specified.
     contents = new int[size];
     head = 0;
     tail = 0;
     empty = true;
     full = false;
 }

 public boolean isEmpty()
 {
     return empty;
 }

 public boolean isFull()
 {
     return full;
 }

 public void show()
 {
     if (head < tail)
     {
         for (int i=head; i < tail; i++)
             System.out.print(contents[i] + " ");
     }
     else 
         if (!empty)
         {
             for (int i=head; i < contents.length; i++)
                 System.out.print(contents[i] + " ");
             for (int i=0; i < tail; i++)
                 System.out.print(contents[i] + " ");
         }
     System.out.println();

 }

 public void clear()
 {
     while (!empty)
         System.out.print(dequeue() + " ");
     head = 0;
     tail = 0;
     empty = true;
     full = false;
 }

 public void enqueue(int value)
 {
     empty = false;
     contents[tail++]=value;
     if (tail == contents.length)
         tail = 0; // wrap around
     if (head == tail)
         full = true;
 }

 public int dequeue()
 {
     full = false;
     int temp = contents[head++];
     if (head == contents.length)
         head = 0; // wrap around
     if (head == tail)
         empty = true;
     return temp;
 }
}

