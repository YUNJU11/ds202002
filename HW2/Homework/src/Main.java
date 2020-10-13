import java.util.Scanner;

public class Main {
	
	public static boolean isValid (String s) {
		
		char[] stack = new char[31024];
		int top = -1;
		
		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			if (ch == '(')	stack[++top] = ch;
			else {
				if(top == -1 || stack[top] !='(') return false;
				
				top--;
			}
			
		}
		return top == -1;
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		for(int i = 0 ; i< n ; i++) {
			String s = scan.next();
			
			if(isValid(s)) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
