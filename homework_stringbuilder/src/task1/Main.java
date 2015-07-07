package task1;

public class Main {

	public static void main(String[] args) {
		
		char[] characters = {'a', 'j', 'l', 'a'};
		CampStringBuilder csb = new CampStringBuilder(characters);
		String str = " el tabari";
		
		csb.append(str);
		
		char[] characters1 = {'o', 'm', 'a', 'r'};
		CampStringBuilder csb1 = new CampStringBuilder(characters1);
		String str1 = "el tabari ";

		csb1.prepend(str1);
		
		System.out.println(csb);
		System.out.println(csb1);
	}

}