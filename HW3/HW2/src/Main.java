import java.util.Scanner;
// 큐
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//	큐 만들기
		int k = 1024;
		int Queue[] = new int[k];
		int head = 0; int tail = 0;
		
		int N = scan.nextInt();
		for(int i = 0 ; i < N ; i++) {
			String line = scan.next();
			
			
			switch(line) {
			case "push": int num = scan.nextInt();
						 Queue[tail] = num;
						 tail = (tail+1)%k;
						 break;
			case "pop" : if ( head == tail ) {
						 System.out.println("-1");
						 } else {
						 int h = Queue[head];
						 System.out.println(h);
						 head = (head+1)%k;
						 }
						 break;
			case "size": int size = (tail - head + k)%k;
						 System.out.println(size);
						 break;
			case "empty": if (head==tail) {
						  System.out.println(1);
							} else System.out.println(0);
						  break; 
			case "front": if(head==tail) {
						  System.out.println("-1");
							} else {
							System.out.println(Queue[head]);
						}
						 break;
			case "back" :if(head==tail) {
						System.out.println("-1");
						} else {
						System.out.println(Queue[tail-1]);
						}
						break;
			}}}}
			