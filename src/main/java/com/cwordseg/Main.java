package com.cwordseg;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		BufferedReader bReader = new BufferedReader(
				new InputStreamReader(new FileInputStream("src/main/resources/dic/not.txt")));
		String s;
		while ((s = bReader.readLine()) != null) {
			if (s.equals("不")) {
				System.out.println("what fuck!!");
			}
			System.out.println(s);
		}
	}

}
