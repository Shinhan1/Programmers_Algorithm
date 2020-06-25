package programmers_String;
/* 정규표현식
  *자주 쓰이는 패턴*
1) 숫자만 : ^[0-9]*$
2) 영문자만 : ^[a-zA-Z]*$
3) 한글만 : ^[가-힣]*$
4) 영어 & 숫자만 : ^[a-zA-Z0-9]*$
5) E-Mail : ^[a-zA-Z0-9]+@[a-zA-Z0-9]+$
6) 휴대폰 : ^01(?:0|1|[6-9]) - (?:\d{3}|\d{4}) - \d{4}$
7) 일반전화 : ^\d{2,3} - \d{3,4} - \d{4}$
8) 주민등록번호 : \d{6} \- [1-4]\d{6}
9) IP 주소 : ([0-9]{1,3}) \. ([0-9]{1,3}) \. ([0-9]{1,3}) \. ([0-9]{1,3})
*/

public class String_문자열다루기기본_정규표현식 {
	public boolean solution(String s) {
		// 정규표현식을 이용한 방법...... 공부하자
		if (s.length() == 4 || s.length() == 6)
			return s.matches("(^[0-9]*$)");
		return false;
	}

	public static void main(String[] args) {
		String_문자열다루기기본 st = new String_문자열다루기기본();
		String s = "4424";
		System.out.println(st.solution(s));
	}

}
