//	���� 1. ���ð� ť�� �̿��� ���� ����
import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		// 1. ť�� ���� ����
		//	2. ���� n �Է¹ޱ�
		int n = scan.nextInt();
		
		int Queue[] = new int[n*2];
		int head = 0, tail = 0;
		
		int Stack[] = new int[n*2];
		int top = -1;
		
		//	3. ť�� n���� ������ ���ڵ��� �ֽ��ϴ�. ������ ������ ������ 0~10000 ������ �մϴ�.
		for(int i = 0; i < n; i++) {
			Queue[tail] = rand.nextInt(10000);
			tail = (tail+1)%(n*2);
		}
		
		//	4. ť���� ���� �ϳ��� �����ϴ�.
		//	5. ���� �ֻ��� ���ڰ� ť���� ���� ���ں��� ���� ���, ���ÿ��� ���ڸ� ���� ť�� �ֽ��ϴ�.
		//	6. ������ ����ְų� ���� �ֻ��� ���ڰ� ť���� ���� ���ں��� Ŭ ������ 5. �ݺ�
		//	7. ���ÿ� ť���� ���� ���ڸ� �ֽ��ϴ�.
		//	8. ť�� ������� �ʴٸ� 4. �� ���� ������ ����մϴ�.
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
		
		//	9. ���ÿ� �ִ� �����͸� �ϳ��� �����鼭 �����͸� ����մϴ�.
		for(int i = top; i >= 0; i--) {
			System.out.print(Stack[i]+" ");
		}
	}

}
