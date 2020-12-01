//	Lecture 14
//	���������� �̿��Ͽ� ������׷����� ���� ū ������ ���簢�� ���� ���ϱ�
//	�Է�
//	ó���� ������׷��� ���� ���� N�� �Էµ˴ϴ�.
//	������ �� ���õ��� �������� N�� �Է��մϴ�.
//	���� ��� {	3, 2, 6, 7 }�� ������ ������ 4���� ������ �ִ� ������׷���
//	4 3 2 6 7
//	�� �Է��� �־����ϴ�.
//	�̿� ���� �亯�� ���簢���� ���̸� ����ϸ� �˴ϴ�.
//	12
import java.util.Scanner;
public class Main {
	//	���������� ���� �Լ�
	//	�迭 v���� ���� (a, b) �������� �ִ� ũ���� ���簢�� ���� ��ȯ
	//	�ִ� ũ�� = ���� ���� �� �ִ��� & ���� ���� �����ִ� �� �� �ִ�
	static int histo(int[] v, int a, int b) { // a, b�� �迭�� �ε�����!
		if (a==b) return v[a] ; // �ϳ����� �� �ɰ����� -> ���簢�� ���� ��ȯ
		int c = (a+b) / 2 ;
		int left = histo(v,a,c);
		int right = histo(v,c+1,b);
		
		int result; // ���� ������ �ִ�
		if(left>=right) result = left;
		else result = right;
		
		int i = c, j = c+1;
		int h = Math.min(v[i], v[j]); // ������ �� ���簢���� ����
		
		while(a<i || j<b) { // �������� ������.
			if(j<b && (i == a || v[i-1] < v[j+1])) { // Ȯ���ذ��� ����
				h = Math.min(h, v[++j]);
			}
			else h = Math.min(h, v[--i]);
			// �ִ� ����
			result = Math.max(result,h*(j-i+1));
		}	
			return result;
	}
	
	//	������׷����� �ִ��� ���簢�� ���̸� ����ؼ� ����ϴ� �Լ�
	//	v : ������׷��� ���õ��� �������� �迭 ( 0 �̻��� �ڿ��� )
	//	n : ������ ����
	static int histo(int[] v, int n) {
		return histo(v, 0, n-1); // �迭 �ε��� �� 0 ~ n-1
	}
	
	public static void main(String[] args) {
		//	�Է��� ���ؼ� ��ĳ�� ������Ʈ ����
		Scanner scan = new Scanner(System.in);
		//	���� ���� N�� �Է�
		int n = scan.nextInt();
		//	n���� ������ ���� �迭�� ����
		int[] v = new int[n];
		//	n���� �迭 ������ �Էµ� ���� �ִ´�.
		for(int i = 0; i < n; i++) {
			v[i] = scan.nextInt();
		}
		//	histo() �Լ��� ȣ���ؼ� �� ����� ����
		int r = histo(v,n);
		//	��� ���
		System.out.println(r);
	}
}
