package com.tmb.automation.pages.platform1;

public class TestSubstring {

	public TestSubstring() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ref = "Ref : YAOQ";
		ref = ref.substring(ref.indexOf(":")+2, ref.length());
		System.out.println(ref);
	}

}
