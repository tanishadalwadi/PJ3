/**
    A class of stacks whose entries are stored in an array.
    Implement all methods in ArrayStack class using resizable 
    array strategy, i.e. use doubleArray() 

    Main Reference : text book or class notes
    Must throw StackException during exception events in methods:
	peek(), pop(), ArrayStack(int initialCapacity)
    Do not change or add data fields 
    Do not add new methods

*/

package pj3.PJ3;
import java.util.Arrays;

public class ArrayStack<T> implements StackInterface<T>
{
  private T[] stack;    // Array of stack entries
  private int topIndex; // Index of top entry
  private static final int DEFAULT_CAPACITY = 50;
  private boolean initialized = false;
  private static final int MAXIMUM_CAPACITY = 20000;
  /* Construct a stack with DEFAULT_CAPACITY */
  public ArrayStack()
  {
   	this(DEFAULT_CAPACITY);
  } // end default constructor
	
       
  /* Construct a stack with the given initialCapacity */
  /* Throw StackException if initialCapacity <= 0     */

  public ArrayStack(int initialCapacity)
  {
     // checkCapacity(initialCapacity);
      if(initialCapacity <= 0){
          throw new StackException("Exception");
      }
      T[] newstack= (T[])new Object[initialCapacity];
      stack = newstack; 
      topIndex = -1;
      //initialized= true;
      
      	// add stataments
  } // end constructor
  
  private void checkCapacity(int initialCapacity) {
       if (initialCapacity > MAXIMUM_CAPACITY )
       {
            throw new StackException("Capacity is more than maximum.");
       }     
   }
@Override
  public void push(T newEntry)
  {
       topIndex++;   
       if (topIndex >= stack.length) // if array is full,  
           doubleArray (); // expand array       
       stack [topIndex] = newEntry; 
       
      
      	// add stataments
  } // end push

  /* Throw StackException if stack is empty */
 @Override
  public T peek()
  {
      
        if (empty())
        {
            throw new StackException("Stack is empty");
            
        }
        // add stataments

       
        
          return stack[topIndex];
        
  } // end peek

  /* Throw StackException if stack is empty */
  @Override
  public T pop()
  {
      if (empty())
      {
          throw new StackException("Stack is empty");
      }
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
      	// add stataments
       
  } // end pop
  @Override
  public boolean empty()
  {
     // boolean flag = true;
         //if( topIndex== -1)
         //{
             return topIndex < 0;
         //}

      	// add stataments

  } // end empty
	
@Override
  public int size()
  {
      return topIndex +1;
        
  } // end size 
@Override
  public void clear()
  {
      T[] noArray= (T[])new Object[DEFAULT_CAPACITY];
      stack = noArray;
      topIndex = -1;
      
 	// add stataments
  } // end clear
  
  // toString() returns a list of data in Stack, separate them with ','
  @Override
  
  public String toString()
  {
        String s = "[";
        String result = "";

//      for (int i=0; i < stack.length; i++) 
//         result = result + stack[i].toString() + "\n";
        if(empty()){
            result = "[]";
        }
        else{
            for(T i: stack){
                if(i != null){
                    s += i + ",";
                }
            }
            result = s.substring(0,s.length()-1);
            result = "]";
        }
      return result;
      	// add stataments
  }

  // double the size of array using Arrays.copyOf()
  private void doubleArray()
  {
       if ( topIndex >= stack.length - 1 ) // If array is full, double its size
           {
           int newLength = 2 * stack.length ;
           checkCapacity( newLength ) ;
           stack = Arrays.copyOf( stack, newLength ) ;
       }
      	// add stataments
  } // end doubleArray


  /****************************************************
     Do not modify: Stack test
  ****************************************************/
  public static void main (String args[])
  {
        System.out.println("\nYour Test output:\n");
	StackInterface<Integer> s = new ArrayStack<Integer>(10);
	if (s.empty()) 
            System.out.println("OK: stack is empty");
	else
            System.out.println("Error: stack is not empty");

	if (s.size() == 0) 
            System.out.println("OK: stack size is 0");
	else
            System.out.println("Error: stack size is " + s.size());

	s.push(10);
	s.push(30);
	s.push(50);
        System.out.println("Push 3 data: 10, 30, 50");
        System.out.println("Print stack " + s);
        System.out.println("size = " + s.size());
	if (s.size() == 3) 
            System.out.println("OK: stack size is 3");
	else
            System.out.println("Error: stack size is " + s.size());

	if (s.peek() == 50) 
            System.out.println("OK: peek stack top is 50");
	else
            System.out.println("Error: peek stack top is " + s.size());

	if (!s.empty()) 
            System.out.println("OK: stack is not empty");
	else
            System.out.println("Error: stack is empty");

        System.out.println("Pop 2 data: 50, 30");
        s.pop();
        System.out.println("Print stack " + s);
	int data=s.pop();
        System.out.println("Print stack " + s);
	if (data == 30) 
            System.out.println("OK: stack pop data is 30");
	else
            System.out.println("Error: stack pop data is " + data);

        System.out.println("Clear stack");
        s.clear();
        System.out.println("Print stack " + s);

	if (s.empty()) 
            System.out.println("OK: stack is empty");
	else
            System.out.println("Error: stack is not empty");

	if (s.size() == 0) 
            System.out.println("OK: stack size is 0");
	else
            System.out.println("Error: stack size is " + s.size());

	s.push(7);
	s.push(37);
	s.push(58);
        System.out.println("Push 3 data: 7, 37, 58");
        System.out.println("Print stack " + s);

	if (s.size() == 3) 
            System.out.println("OK: stack size is 3");
	else
            System.out.println("Error: stack size is " + s.size());

	if (!s.empty()) 
            System.out.println("OK: stack is not empty");
	else
            System.out.println("Error: stack is empty");
        s.clear();

        System.out.println("========================");
        try {
            System.out.println("\nContruct a stack with negative capacity");
	    StackInterface<Integer> s2 = new ArrayStack<Integer>(-3);
        } 
        catch (StackException e) {
            System.out.println("StackException : " + e.getMessage());
        }

        try {
            System.out.println("\nPeek empty stack");
	    s.peek();
        } 
        catch (StackException e) {
            System.out.println("StackException : " + e.getMessage());
        }

        try {
            System.out.println("\nPop empty stack");
	    s.pop();
        } 
        catch (StackException e) {
            System.out.println("StackException : " + e.getMessage());
        }
  }

} // end ArrayStack
