//	Lecture 14
//	분할정복을 이용하여 히스토그램에서 가장 큰 넓이의 직사각형 넓이 구하기
//	입력
//	처음에 히스토그램의 샘플 갯수 N이 입력됩니다.
//	다음에 각 샘플들의 도수들이 N개 입력합니다.
//	예를 들어 {	3, 2, 6, 7 }의 도수를 가지는 4개의 샘플이 있는 히스토그램은
//	4 3 2 6 7
//	로 입력이 주어집니다.
//	이에 대한 답변을 직사각형의 넓이를 출력하면 됩니다.
//	12
import java.util.Scanner;
public class Main {
	//	분할정복을 위한 함수
	//	배열 v에서 범위 (a, b) 구간에서 최대 크기의 직사각형 넓이 반환
	//	최대 크기 = 양쪽 구간 중 최대합 & 양쪽 구간 걸쳐있는 답 중 최대
	static int histo(int[] v, int a, int b) { // a, b는 배열의 인덱스값!
		if (a==b) return v[a] ; // 하나까지 다 쪼개버림 -> 직사각형 넓이 반환
		int c = (a+b) / 2 ;
		int left = histo(v,a,c);
		int right = histo(v,c+1,b);
		
		int result; // 양쪽 구간의 최댓값
		if(left>=right) result = left;
		else result = right;
		
		int i = c, j = c+1;
		int h = Math.min(v[i], v[j]); // 넓히기 전 직사각형의 높이
		
		while(a<i || j<b) { // 언제까지 넓히냐.
			if(j<b && (i == a || v[i-1] < v[j+1])) { // 확장해가는 과정
				h = Math.min(h, v[++j]);
			}
			else h = Math.min(h, v[--i]);
			// 최댓값 갱신
			result = Math.max(result,h*(j-i+1));
		}	
			return result;
	}
	
	//	히스토그램에서 최대의 직사각형 넒이를 계산해서 출력하는 함수
	//	v : 히스토그램의 샘플들의 도수들의 배열 ( 0 이상의 자연수 )
	//	n : 샘플의 개수
	static int histo(int[] v, int n) {
		return histo(v, 0, n-1); // 배열 인덱스 값 0 ~ n-1
	}
	
	public static void main(String[] args) {
		//	입력을 위해서 스캐너 오브젝트 생성
		Scanner scan = new Scanner(System.in);
		//	샘플 개수 N을 입력
		int n = scan.nextInt();
		//	n개의 공간을 갖는 배열을 생성
		int[] v = new int[n];
		//	n개의 배열 공간에 입력된 값을 넣는다.
		for(int i = 0; i < n; i++) {
			v[i] = scan.nextInt();
		}
		//	histo() 함수를 호출해서 그 결과를 저장
		int r = histo(v,n);
		//	결과 출력
		System.out.println(r);
	}
}
