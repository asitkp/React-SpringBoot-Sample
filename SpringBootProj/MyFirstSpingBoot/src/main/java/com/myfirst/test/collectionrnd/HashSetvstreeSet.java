package com.myfirst.test.collectionrnd;

import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public class HashSetvstreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet ts=new TreeSet();
		ts.add(3);
		ts.add(20);
		ts.add(15);
		
		System.out.println(ts);
		
		
		HashSet hs=new HashSet();
		
		hs.add(3);
		hs.add(20);
		hs.add(15);
		
		System.out.println(hs);
		
		TreeSet<Person> tsp=new TreeSet<Person>(
                (left, right) -> left.address.compareTo(right.address));
                //String.compare(left.address, right.address));
		
		Person p1=new Person("asit","uttarpara",38);
		Person p2=new Person("abcd","Deshra",23);
		Person p3=new Person("pqrs","Deshra",27);
		tsp.add(p1);
		tsp.add(p2);
		tsp.add(p3);
		
		for (Person prsn : tsp) 
            System.out.print(prsn.name 
                             + ", "); 
		

	}

}
