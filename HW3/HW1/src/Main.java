//	문제 1. 스택과 큐를 이용한 숫자 정렬
import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		// 1. 큐와 스택 생성
		//	2. 숫자 n 입력받기
		int n = scan.nextInt();
		
		int Queue[] = new int[n*2];
		int head = 0, tail = 0;
		
		int Stack[] = new int[n*2];
		int top = -1;
		
		//	3. 큐에 n개의 랜덤한 숫자들을 넣습니다. 랜덤한 숫자의 범위는 0~10000 범위로 합니다.
		for(int i = 0; i < n; i++) {
			Queue[tail] = rand.nextInt(10000);
			tail = (tail+1)%(n*2);
		}
		
		//	4. 큐에서 숫자 하나를 꺼냅니다.
		//	5. 스택 최상위 숫자가 큐에서 꺼낸 숫자보다 작은 경우, 스택에서 숫자를 꺼내 큐에 넣습니다.
		//	6. 스택이 비어있거나 스택 최상위 숫자가 큐에서 꺼낸 숫자보다 클 때까지 5. 반복
		//	7. 스택에 큐에서 꺼낸 숫자를 넣습니다.
		//	8. 큐가 비어있지 않다면 4. 로 가서 수행을 계속합니다.
		while(tail != head) {
		int h = Queue[head];
		
		while( top>=0 && Stack[top] < h) {
			Queue[tail] = Stack[top];
			tail = (tail+1)%(n*2);
			top--;
		}
			Stack[++top] = h;
			head = (head+1)%(n*2);
		}
		
		//	9. 스택에 있는 데이터를 하나씩 꺼내면서 데이터를 출력합니다.
		for(int i = top; i >= 0; i--) {
			System.out.print(Stack[i]+" ");
		}
	}

}
