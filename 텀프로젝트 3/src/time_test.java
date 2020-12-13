
import java.util.Scanner;
import java.util.Random;

public class time_test {
	// [a,b] 구간합 구하기
		public static int query_sum(int arr[],int sum[], int a, int b, int sqrt_N) {
			int ret = 0;
			
			// 구간에 애매하게 걸쳐있는 묶음 (많아봐야 양 끝 2개)
			// 구간 왼쪽에 애매하게 걸쳐있는 묶음의 원소를 모두 더해준다.
			while((a % sqrt_N) != 0) {
				ret += arr[a++];
			}
			// 구간 오른쪽에 애매하게 걸쳐있는 묶음의 원소를 모두 더해준다.
			while(((b+1)%sqrt_N) != 0) {
			ret += arr[b--];
			}
			// 구간에 완전히 포함된 묶음
			while(a<=b) {
				ret += sum[a/sqrt_N];
				a += sqrt_N;
			}
			return ret;
		}
		
		// [a,b] 구간 최댓값 구하기
		public static int query_max(int arr[],int max[], int a, int b, int sqrt_N) {
			int left = arr[a];
			int right = arr[b];
			int ret = 0;
			
			// 구간 왼쪽에 애매하게 걸쳐있는 묶음의 원소 중 최댓값
			while((a % sqrt_N) != 0) {
				left = left > arr[a] ? left : arr[a];
				a++;
			}
			// 구간 오른쪽에 애매하게 걸쳐있는 묶음의 원소 중 최댓값
			while(((b+1)%sqrt_N) != 0) {
				right = right > arr[b] ? right : arr[b];
				b--;
				}
			// 전체 최댓값
			ret = left > right ? left : right ;
			while(a<=b) {
				ret = max[a/sqrt_N] > ret ? max[a/sqrt_N] : ret ;
				a += sqrt_N;
			}
			return ret;
		}
		
		// [a,b] 구간 최소값 구하기
		public static int query_min(int arr[],int min[], int a, int b, int sqrt_N) {
			int left = arr[a];
			int right = arr[b];
			int ret = 0;
			
			// 구간 왼쪽에 애매하게 걸쳐있는 묶음의 원소 중 최솟값
			while((a % sqrt_N) != 0) {
				left = left < arr[a] ? left : arr[a];
				a++;
			}
			// 구간 오른쪽에 애매하게 걸쳐있는 묶음의 원소 중 최솟값
			while(((b+1)%sqrt_N) != 0) {
				right = right < arr[b] ? right : arr[b];
				b--;
				}
			// 전체 최솟값
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
			int sqrt_N = (int)Math.sqrt(N)+1; // 오른쪽 처리 에러 막기 위해 +1 해줌
			int[]sum = new int[sqrt_N];	// 합
			int[]max = new int[sqrt_N]; // 최대
			int[]min = new int[sqrt_N]; // 최소
			
			// 전처리 - 묶음들의 합,최소,최대를 미리 계산
			for(int i = 0 ; i < N ; i++) {
				// 합
				sum[i/sqrt_N] += arr[i];
				// 최대
				max[i/sqrt_N] = arr[i]>max[i/sqrt_N] ? arr[i] : max[i/sqrt_N];
				// 최소 ---> min은 다 0으로 채워져있으니까 당연히 모든 배열에 0ㅇ이 들어가겠찌!
				min[i/sqrt_N] = arr[i]<min[i/sqrt_N] ? arr[i] : min[i/sqrt_N];
			}
			
			//	K개의 구간을 랜덤으로 생성
			for(int j = 0; j < K; j++){
			//	구간 [a,b] 설정
				int rand1 = 0, rand2 = 0;
				int a,b;
						
				while(rand1 == rand2) {
					rand1 = r.nextInt(N);	// 0 ~ N-1 사이 랜덤 수 반환
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
			
					// N개의 데이터를 랜덤함수로 생성
					Random r = new Random();
					int[]arr = new int[N];
					for(int i = 0; i < N; i++) {
						 arr[i]=r.nextInt();
					}
				
					//	K개의 구간을 랜덤으로 생성
					for(int j = 0; j < K; j++){
						//	구간 [a,b] 설정
						int rand1 = 0, rand2 = 0;
						int a,b;
						
						while(rand1 == rand2) {
							rand1 = r.nextInt(N);	// 0 ~ N-1 사이 랜덤 수 반환
							rand2 = r.nextInt(N);
						}
						
						if( rand1 < rand2 ) {
							a = rand1;
							b = rand2;
						} else {
							a = rand2;
							b = rand1;
						}
						
						// 임의의 배열 생성 후 [a,b] 옮기기
						int arr_burble[] = new int[b-a+1];
						int arr_burble_len = arr_burble.length;
						
						for(int k = a; k <= b; k++) {
							arr_burble[k-a]=arr[k];
						}
						
						// 버블 정렬 이용해서 정렬
						for(int p = 0; p < arr_burble_len - 1 ; p++ ) {
							for (int m = 0; m < arr_burble_len - p - 1 ; m++) {
								if(arr_burble[m] > arr_burble[m+1]) {
									int temp = arr_burble[m+1];
									arr_burble[m+1] = arr_burble[m];
									arr_burble[m] = temp;
								}
							}
						}
						
						// 최대,최소,합계 구하기 -> 정렬된 배열의 첫번째: 최소, 마지막:최대
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
	
		//	K개의 구간을 랜덤으로 생성
		for(int j = 0; j < K; j++){
			//	구간 [a,b] 설정
			int rand1 = 0, rand2 = 0;
			int a,b;
			
			while(rand1 == rand2) {
				rand1 = r.nextInt(N);	// 0 ~ N-1 사이 랜덤 수 반환
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
		
		// N 고정 K 변화
		System.out.println("N 고정 , K 변화");
		for(int K = 1000 ; K <= 20000; K += 1000) {
			t1 = System.currentTimeMillis();
			sqrt_solution(100000,K);
			t1 = System.currentTimeMillis() - t1;
			System.out.println(t1);
		}
		
		// N 변화 K 고정
		System.out.println(" ");
		System.out.println("N 변화 , K 고정");
		for(int N = 100000; N <= 300000; N += 10000) {
			t2 = System.currentTimeMillis();
			sqrt_solution(N,1000);
			t2 = System.currentTimeMillis() - t2;
			System.out.println(t2);
		}
	} 
}
