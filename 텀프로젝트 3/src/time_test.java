
import java.util.Scanner;
import java.util.Random;

public class time_test {
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
		
		static void sqrt_solution(int N, int K) {
			Random r = new Random();
			int[]arr = new int[N];
			for(int i = 0; i < N; i++) {
					 arr[i]=r.nextInt();
					 }
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
			}
		}
		
	static void base_solution(int N, int K) {
			
					// N���� �����͸� �����Լ��� ����
					Random r = new Random();
					int[]arr = new int[N];
					for(int i = 0; i < N; i++) {
						 arr[i]=r.nextInt();
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
						
						// ������ �迭 ���� �� [a,b] �ű��
						int arr_burble[] = new int[b-a+1];
						int arr_burble_len = arr_burble.length;
						
						for(int k = a; k <= b; k++) {
							arr_burble[k-a]=arr[k];
						}
						
						// ���� ���� �̿��ؼ� ����
						for(int p = 0; p < arr_burble_len - 1 ; p++ ) {
							for (int m = 0; m < arr_burble_len - p - 1 ; m++) {
								if(arr_burble[m] > arr_burble[m+1]) {
									int temp = arr_burble[m+1];
									arr_burble[m+1] = arr_burble[m];
									arr_burble[m] = temp;
								}
							}
						}
						
						// �ִ�,�ּ�,�հ� ���ϱ� -> ���ĵ� �迭�� ù��°: �ּ�, ������:�ִ�
						int min = arr_burble[0];
						int max = arr_burble[arr_burble_len-1];
						int sum = 0;
						
						for(int z = 0; z < arr_burble_len; z++ ) {
							sum += arr_burble[z];
						}
					}		
				}
	static void base_solution2 (int N, int K) {
		Random r = new Random();
		int[]arr = new int[N];
		for(int i = 0; i < N; i++) {
			 arr[i]=r.nextInt();
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
			
			int min = arr[a];
			int max = arr[a];
			int sum = 0;
			
			for(int k = a ; k <= b ; k ++) {
				min = min > arr[k] ? arr[k] : min;
				max = max < arr[k] ? arr[k] : max;
				sum += arr[k];
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long t1, t2;
		
		// N ���� K ��ȭ
		System.out.println("N ���� , K ��ȭ");
		for(int K = 1000 ; K <= 20000; K += 1000) {
			t1 = System.currentTimeMillis();
			sqrt_solution(100000,K);
			t1 = System.currentTimeMillis() - t1;
			System.out.println(t1);
		}
		
		// N ��ȭ K ����
		System.out.println(" ");
		System.out.println("N ��ȭ , K ����");
		for(int N = 100000; N <= 300000; N += 10000) {
			t2 = System.currentTimeMillis();
			sqrt_solution(N,1000);
			t2 = System.currentTimeMillis() - t2;
			System.out.println(t2);
		}
	} 
}
