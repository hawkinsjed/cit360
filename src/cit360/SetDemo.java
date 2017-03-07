/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360;

import java.util.*;
public class SetDemo {

  public static void main(String args[]) { 

//List      
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
      //System.out.print("\t" + a1);
//Iterator
      //use an interator to display the contents of a1
      Iterator it1 = a1.iterator();
      while(it1.hasNext()){
          Object element = it1.next();
          System.out.print(element + ", ");
      }

//Set      
      //a set does not have duplicates
      Set<Integer> set = new HashSet<Integer>(a1); //copy arrayList into set

         System.out.println("\nSet Elements");
         System.out.println("\t" + set);
//Tree
         TreeSet sortedSet = new TreeSet<Integer>(set); //TreeSet sorts the list
         System.out.println("The sorted list is:");
         System.out.println("\t" + sortedSet);

         System.out.println("The First element of the set is: "+ (Integer)sortedSet.first());
         System.out.println("The last element of the set is: "+ (Integer)sortedSet.last());
         
         
      //Iterator
      //use an interator to display the contents of set
      Iterator it3 = set.iterator();
      while(it3.hasNext()){
          Object element = it3.next();
          System.out.print(element + ", ");
      }
         
//MAP         
      Map m1 = new HashMap(); 
                 
      //store keys and values
      m1.put("Zara", "8");
      m1.put("Mahnaz", "31");
      m1.put("Ayan", "12");
      m1.put("Daisy", "14");

      System.out.println();
      System.out.println(" Map Elements");
      System.out.print("\t" + m1); //print keys and values stored in m1
      

      //Iterator
      //use an interator to display the contents of m1
      Iterator it2 = m1.keySet().iterator();
      while(it2.hasNext()){
          Object element = it2.next();
          System.out.print(element + ", ");
        }
  }   
} 