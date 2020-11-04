import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("N�� ���� a,b�� �Է��ϼ���.");
		
		int N = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		// N���� �����͸� �����Լ��� ����
		int []arr = new int[N];
		System.out.print("������ ������: ");
		for(int i = 0; i < N; i++) {
	            arr[i]=r.nextInt(); 
	            System.out.print(arr[i]+" ");
	        }
		
		//a,b������ �ּҰ�, �ִ밪, �հ踦 ���Ѵ�
		int max = arr[a-1]; //�ִ밪
		int min = arr[a-1]; //�ּҰ�
		int sum = 0;
		
		for(int i = (a-1);i <= (b-1) ;i++) {
		    // �ִ밪 ���ϱ�
			if(max<arr[i]) {
			max = arr[i];
		    }
			// �ּҰ� ���ϱ�		
		    if(min>arr[i]) {
			min = arr[i];
		    }
		    // �հ� ���ϱ�
		    sum += arr[i];
		}
		
		//����Ѵ�.
		System.out.println(" ");
		System.out.println("�ּҰ�: "+min+", �ִ�: "+max+", �հ�:"+sum);
		}
	}
