package programmers_String;

import java.util.ArrayList;
import java.util.Arrays;

/*
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
*/
public class String_문자열내림차순 {
	public String solution(String s) {
		String answer = "";
		ArrayList al = new ArrayList();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < s.length(); i++) {
			al.add(s.charAt(i));
		}
		al.sort(null);
		for(int i = 0; i < al.size(); i++) {
			sb.append(al.get(i));
		}
		sb.reverse();
		answer = String.valueOf(sb);
		
		return answer;
	}
	public static void main(String[] args) {
		String_문자열내림차순 st = new String_문자열내림차순();
		String s = "AbcsqweZ";
		st.solution(s);
	}

}
