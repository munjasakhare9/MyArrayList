package com.demo;

import java.util.ArrayList;

public class App {
	public static void main(String[] args)

	{
		
		ArrayList al=new ArrayList();
		al.add(10);
		al.add(20);
		al.add(30);
		System.out.println(al);
		al.clear();
		System.out.println(al);
		
		MyArrayList mal=new MyArrayList();
		mal.add(100);
		mal.add(200);
		mal.add(300);
		System.out.println(mal);
		mal.clear();
		System.out.println(mal);
		
		
		
	}
}
