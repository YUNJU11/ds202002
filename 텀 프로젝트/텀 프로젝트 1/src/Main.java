import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("N과 구간 a,b를 입력하세요.");
		
		int N = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		// N개의 데이터를 랜덤함수로 생성
		int []arr = new int[N];
		System.out.print("생성된 데이터: ");
		for(int i = 0; i < N; i++) {
	            arr[i]=r.nextInt(); 
	            System.out.print(arr[i]+" ");
	        }
		
		//a,b구간의 최소값, 최대값, 합계를 구한다
		int max = arr[a-1]; //최대값
		int min = arr[a-1]; //최소값
		int sum = 0;
		
		for(int i = (a-1);i <= (b-1) ;i++) {
		    // 최대값 구하기
			if(max<arr[i]) {
			max = arr[i];
		    }
			// 최소값 구하기		
		    if(min>arr[i]) {
			min = arr[i];
		    }
		    // 합계 구하기
		    sum += arr[i];
		}
		
		//출력한다.
		System.out.println(" ");
		System.out.println("최소값: "+min+", 최댓값: "+max+", 합계:"+sum);
		}
	}
