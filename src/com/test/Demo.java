package com.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*class A2{
	public int x=0;
	public A2(){
	}
}*/
public class Demo {
	public static void main(String[] args){
		StringBuffer s1=new StringBuffer(10);
		s1.append("123456789123456789");
		System.out.println(s1.length());
		System.out.println(s1.capacity());//10*2+2
		
		/*List  Listlist1 = new ArrayList();
	    Listlist1.add(0);
	    List Listlist2 = Listlist1;
	    System.out.println(Listlist1.get(0) instanceof Integer);
	    System.out.println(Listlist2.get(0) instanceof Integer);*/
		
      /* A2 a=new A2();
       final A2 s=a;
       System.out.println(s.x);
       a.x++;
       System.out.println(s.x);*/
    }
}