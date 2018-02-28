/*import libraries for reader class 
 * /
import java.io.*;
import java.util.*;
import java.lang.*;
//Reader class to take input from user
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}

/* node is a single unit in queue
 * data member: integer value
 */
 
class node{
    int value;
    node next;
}

/* class queue implements queue data structure
 * has two node units as front and rear initially
 * integer max gives the maximum capacity of queue
 * r and f are used as indexes for rear and front of queue;
 * 		to determine number of elements in queue
 */
public class queue{
    static node front;
    static node rear;
    static int r=0,f=0;
    static int max;
    
    /* add function pushes new node to rear of queue if number of nodes does not exceed max
     * integer val is passed to add function as parameter
     * new node consisting of integer val is the new rear of queue
     * also displays the queue at the end
     */
    public static void add(int val){
        if (r==0){
            r++;
            node temp=new node();
            temp.value=val;
            rear=temp;
            front=rear;
            rear.next=null;
        }
        else if (r<max-1){
            r++;
            node temp=new node();
            temp.value=val;
            rear.next=temp;
            rear=temp;
            System.out.println(rear.value);
            rear.next=null;
        }
        disp();
    }
  
  	/* deletes the front node of the queue 
  	 * next node is the new front node of the queue
  	 * displays the queue at the end 
  	 */
    public static void del(){
        if (f!=r){
            f++;
            front=front.next;
        }
        disp();
    }
  
  	/* iterates through the queue from front to rear and displays the value stored in node
  	 */
    public static void disp(){
        node it=front;
        while(it!=null){
            System.out.print(it.value+" ");
            it=it.next;
        }
        System.out.println();
    }
  
  	/* main method for executing the program according to user input
  	 * 
  	 * 
  	 * 
  	 */
    public static void main(String[] args)throws IOException{
        front=null;
        rear=null;
        Reader.init(System.in);
        max=Reader.nextInt();
        int ch=Reader.nextInt();
        int v;
      	/* takes input from user, 
      	 * terminate the program if 4 is entered 
      	 * push value to queue if 1 is entered
      	 * pop value from queue if 2 is entered
      	 */
        while(ch!=4){
            if (ch==1){
                v=Reader.nextInt();
                add(v);
            }
            if (ch==2){
                del();
            }
            ch=Reader.nextInt();
        }
    }
}
