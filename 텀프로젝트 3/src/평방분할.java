import java.util.Random;
import java.util.Scanner;

public class 평방분할 {

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
		
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		// N과 K를 입력받습니다.
		System.out.println("N(데이터 개수)와 K(구간 개수)를 입력하세요.");
		
		System.out.print("N: ");
		int N = scan.nextInt(); // 데이터 개수
		System.out.print("K: ");
		int K = scan.nextInt(); // 구간 개수
		
		// N개의 데이터를 랜덤함수로 생성
		System.out.print("랜덤으로 생성된 데이터: ");
		int[]arr = new int[N];
		for(int i = 0; i < N; i++) {
				 arr[i]=r.nextInt();
				 System.out.print(arr[i]+", ");
				 }
		System.out.println(" ");
		System.out.println(" ");
		
		// 전체 구간을 루트n개씩 나눠 각 블록의 합을 저장하는 배열 block
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
			
			System.out.println("구간"+(j+1)+": "+(a+1)+"번째부터"+(b+1)+"번째 데이터");
			System.out.println("최솟값= "+totalmin);
			System.out.println("최댓값= "+totalmax);
			System.out.println("합계= "+totalsum);
			System.out.println(" ");
		}
	}
}
