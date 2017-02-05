/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360;

import java.util.*;
public class SetDemo {

  public static void main(String args[]) { 
      // arrayList is simple list and can have duplicates
      // unlike array size is dynamic
      List a1 = new ArrayList();
      a1.add(34);
      a1.add(22);
      a1.add(10);
      a1.add(60);  
      a1.add(30);  
      a1.add(22);  
      System.out.println("ArrayList Elements");
      System.out.print("\t" + a1);
      
      //a set does not have duplicates
      Set<Integer> set = new HashSet<Integer>(a1); //copy arrayList into set

         System.out.println("\nSet Elements");
         System.out.println("\t" + set);

         TreeSet sortedSet = new TreeSet<Integer>(set); //TreeSet sorts the list
         System.out.println("The sorted list is:");
         System.out.println("\t" + sortedSet);

         System.out.println("The First element of the set is: "+ (Integer)sortedSet.first());
         System.out.println("The last element of the set is: "+ (Integer)sortedSet.last());
  }
      
} 