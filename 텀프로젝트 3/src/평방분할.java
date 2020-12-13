import java.util.Random;
import java.util.Scanner;

public class ������ {

	// [a,b] ������ ���ϱ�
	public static int query_sum(int arr[],int sum[], int a, int b, int sqrt_N) {
		int ret = 0;
		
		// ������ �ָ��ϰ� �����ִ� ���� (���ƺ��� �� �� 2��)
		// ���� ���ʿ� �ָ��ϰ� �����ִ� ������ ���Ҹ� ��� �����ش�.
		while((a % sqrt_N) != 0) {
			ret += arr[a++];
		}
		// ���� �����ʿ� �ָ��ϰ� �����ִ� ������ ���Ҹ� ��� �����ش�.
		while(((b+1)%sqrt_N) != 0) {
		ret += arr[b--];
		}
		// ������ ������ ���Ե� ����
		while(a<=b) {
			ret += sum[a/sqrt_N];
			a += sqrt_N;
		}
		return ret;
	}
	
	// [a,b] ���� �ִ� ���ϱ�
	public static int query_max(int arr[],int max[], int a, int b, int sqrt_N) {
		int left = arr[a];
		int right = arr[b];
		int ret = 0;
		
		// ���� ���ʿ� �ָ��ϰ� �����ִ� ������ ���� �� �ִ�
		while((a % sqrt_N) != 0) {
			left = left > arr[a] ? left : arr[a];
			a++;
		}
		// ���� �����ʿ� �ָ��ϰ� �����ִ� ������ ���� �� �ִ�
		while(((b+1)%sqrt_N) != 0) {
			right = right > arr[b] ? right : arr[b];
			b--;
			}
		// ��ü �ִ�
		ret = left > right ? left : right ;
		while(a<=b) {
			ret = max[a/sqrt_N] > ret ? max[a/sqrt_N] : ret ;
			a += sqrt_N;
		}
		return ret;
	}
	
	// [a,b] ���� �ּҰ� ���ϱ�
	public static int query_min(int arr[],int min[], int a, int b, int sqrt_N) {
		int left = arr[a];
		int right = arr[b];
		int ret = 0;
		
		// ���� ���ʿ� �ָ��ϰ� �����ִ� ������ ���� �� �ּڰ�
		while((a % sqrt_N) != 0) {
			left = left < arr[a] ? left : arr[a];
			a++;
		}
		// ���� �����ʿ� �ָ��ϰ� �����ִ� ������ ���� �� �ּڰ�
		while(((b+1)%sqrt_N) != 0) {
			right = right < arr[b] ? right : arr[b];
			b--;
			}
		// ��ü �ּڰ�
		ret = left < right ? left : right ;
		while(a<=b) {
			ret = min[a/sqrt_N] < ret ? min[a/sqrt_N] : ret ;
			a += sqrt_N;
		}
		return ret;
	}
		
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		// N�� K�� �Է¹޽��ϴ�.
		System.out.println("N(������ ����)�� K(���� ����)�� �Է��ϼ���.");
		
		System.out.print("N: ");
		int N = scan.nextInt(); // ������ ����
		System.out.print("K: ");
		int K = scan.nextInt(); // ���� ����
		
		// N���� �����͸� �����Լ��� ����
		System.out.print("�������� ������ ������: ");
		int[]arr = new int[N];
		for(int i = 0; i < N; i++) {
				 arr[i]=r.nextInt();
				 System.out.print(arr[i]+", ");
				 }
		System.out.println(" ");
		System.out.println(" ");
		
		// ��ü ������ ��Ʈn���� ���� �� ����� ���� �����ϴ� �迭 block
		int sqrt_N = (int)Math.sqrt(N)+1; // ������ ó�� ���� ���� ���� +1 ����
		int[]sum = new int[sqrt_N];	// ��
		int[]max = new int[sqrt_N]; // �ִ�
		int[]min = new int[sqrt_N]; // �ּ�
		
		// ��ó�� - �������� ��,�ּ�,�ִ븦 �̸� ���
		for(int i = 0 ; i < N ; i++) {
			// ��
			sum[i/sqrt_N] += arr[i];
			// �ִ�
			max[i/sqrt_N] = arr[i]>max[i/sqrt_N] ? arr[i] : max[i/sqrt_N];
			// �ּ� ---> min�� �� 0���� ä���������ϱ� �翬�� ��� �迭�� 0���� ������!
			min[i/sqrt_N] = arr[i]<min[i/sqrt_N] ? arr[i] : min[i/sqrt_N];
		}
		
		//	K���� ������ �������� ����
		for(int j = 0; j < K; j++){
		//	���� [a,b] ����
			int rand1 = 0, rand2 = 0;
			int a,b;
					
			while(rand1 == rand2) {
				rand1 = r.nextInt(N);	// 0 ~ N-1 ���� ���� �� ��ȯ
				rand2 = r.nextInt(N);
					}
					
			if( rand1 < rand2 ) {
				a = rand1;
				b = rand2;
				} else {
				a = rand2;
				b = rand1;
				}
			
			int totalsum = query_sum(arr,sum,a,b,sqrt_N);
			int totalmax = query_max(arr,max,a,b,sqrt_N);
			int totalmin = query_min(arr,max,a,b,sqrt_N);
			
			System.out.println("����"+(j+1)+": "+(a+1)+"��°����"+(b+1)+"��° ������");
			System.out.println("�ּڰ�= "+totalmin);
			System.out.println("�ִ�= "+totalmax);
			System.out.println("�հ�= "+totalsum);
			System.out.println(" ");
		}
	}
}
