package project01;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Text {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		System.out.println(x+y);
	}
}
