/** Implementation of a generic linked list.
    @author Jed Yang, 2018-02-02
    @author Yingqi Ding, 2018-04-29
 */
public class SortedListTester
{
   /** Demo and test of SortedList methods. */
   public static void main(String[] args)
   {
      //Create a test list
      SortedList<ZooAnimal> list = create_list_check_indexOf_add();

      //CHECK every method
      check_get(list);
      check_size_twoRemoves(list);
      check_contains(list);
      check_add_indexOf(list);
      check_toArray(list);
      check_clear(list);
   }

   public static SortedList<ZooAnimal> create_list_check_indexOf_add()
   {
      //In Part C, change CarlSortedList<ZooAnimal> to SortedLinkedList.
      SortedList<ZooAnimal> list = new SortedLinkedList(); 
      ZooAnimal a1 = new ZooAnimal("Lola", "lemur", 2005, "zooPics/lemur.jpg");
      ZooAnimal a2 = new ZooAnimal("Leanne", "koala", 2000,"zooPics/koala2.jpg");
      ZooAnimal a3 = new ZooAnimal("Sophie", "giraffe", 2010, "zooPics/giraffe.jpg");
      ZooAnimal a4 = new ZooAnimal("Kevin", "koala", 2007, "zooPics/koala.jpg");
      ZooAnimal a5 = new ZooAnimal("Ozzie", "loris", 2008, "zooPics/loris.jpg");
      ZooAnimal a6 = new ZooAnimal("Tapan", "giraffe", 1996, "zooPics/giraffe2.jpg");
      ZooAnimal a7 = new ZooAnimal("Leanne", "koala", 2011, "zooPics/koala3.jpg");

      //CHECK: size() when the list is empty
      System.out.println("List should be empty here. isEmpty() returns " + list.isEmpty());
      System.out.println();

      //CHECK: remove() when the item is not in the list
      if (list.remove(a1) != false)
      {
         System.out.println("remove(a1) from empty list should be false");
      }

      //CHECK: add() when the item should be added to the middle of the list
      list.add(a1);
      list.add(a2);
      //CHECK: add() when the item should be added to the head of the list
      list.add(a3);
      list.add(a4);
      //CHECK: add() when the item should be added to the end of the list
      list.add(a5);
      list.add(a6);
      list.add(a7);
      displayTextZoo(list);

      //CHECK: indexOf() when the item is at the end of the list
      System.out.println("List should return 6 for index of a5(Ozzie), indexOf(a5) returns " + list.indexOf(a5));
      //CHECK: indexOf() when the item is in the middle of the list
      System.out.println("List should return 2 for index of a4(Kevin), indexOf(a4) returns " + list.indexOf(a4));

      return list;
   }

   public static void check_get(SortedList<ZooAnimal> list)
   {
      ZooAnimal a3 = new ZooAnimal("Sophie", "giraffe", 2010, "zooPics/giraffe.jpg");
      ZooAnimal a4 = new ZooAnimal("Kevin", "koala", 2007, "zooPics/koala.jpg");
      ZooAnimal a5 = new ZooAnimal("Ozzie", "loris", 2008, "zooPics/loris.jpg");

      //CHECK: get() when the index is out of boundary
      try
      {
         list.get(10);
      }
      catch(IndexOutOfBoundsException e)
      {
         System.out.println();
         System.err.println("IndexOutOfBoundsException is catched as expected");
      }

      //CHECK: get() when the item is the head of the list
      if (!list.get(0).equals(a3))
      {
         System.out.println("Get head item goes wrong.");
      }
      //CHECK: get() when the item is in the middle of the list
      if (!list.get(2).equals(a4))
      {
         System.out.println("Get middle item goes wrong.");
      }

      //CHECK: get() when the item is at the end of the list
      if (!list.get(list.size() - 1).equals(a5))
      {
         System.out.println("Get the end item goes wrong.");
      }
   }

   public static void check_size_twoRemoves(SortedList<ZooAnimal> list)
   {
      ZooAnimal a1 = new ZooAnimal("Lola", "lemur", 2005, "zooPics/lemur.jpg");
      ZooAnimal a3 = new ZooAnimal("Sophie", "giraffe", 2010, "zooPics/giraffe.jpg");
      ZooAnimal a5 = new ZooAnimal("Ozzie", "loris", 2008, "zooPics/loris.jpg");

      //CHECK: size() when the list is not empty
      if (list.size() != 7)
      {
         System.out.println("Size of list should be 7");
      }

      //CHECK: remove(index) when the item is the head of the list
      if (!list.remove(0).equals(a3))
      {
         System.out.println("remove the head is wrong");
      }
      //Add it back for following checks
      list.add(a3);

      //CHECK: remove(index) when the item is the endd of the list
      if (!list.remove(list.size() - 1).equals(a5))
      {
         System.out.println("remove the end is wrong");
      }
      //Add it back for following checks
      list.add(a5);

      //CHECK: remove(index) when the item is the middle of the list
      if (!list.remove(5).equals(a1))
      {
         System.out.println("remove the middle is wrong");
      }
      //Add it back for following checks
      list.add(a1);

      //CHECK: remove(item) when the item is in the middle list
      if (list.remove(a1) != true)
      {
         System.out.println("remove a1 (Lola) should be true");
      }

      System.out.println();
      System.out.println("List after removing a1 (Lola):");
      displayTextZoo(list);

      //CHECK: size() after an item is removed from the list
      if (list.size() != 6)
      {
         System.out.println("Size of list should be 6");
      }

      //CHECK: remove(item) when the item is not in the list
      if (list.remove(a1) != false)
      {
         System.out.println("remove a1 (Lola) should be false");
      }
   }

   public static void check_contains(SortedList<ZooAnimal> list)
   {
      ZooAnimal a3 = new ZooAnimal("Sophie", "giraffe", 2010, "zooPics/giraffe.jpg");
      ZooAnimal teddy = new ZooAnimal("Teddy", "cat", 2013, "zooPics/koala.jpg");

      //CHECK: contains() when the item is not in the list
      System.out.println("List should not contain teddy, contains(teddy) returns " + list.contains(teddy));
      //CHECK: contains() when the item is in and is not in the list
      System.out.println("List should contain a3 (Sophie), contains(a3) returns " + list.contains(a3));
   }

   public static void check_add_indexOf(SortedList<ZooAnimal> list)
   {
      ZooAnimal a3 = new ZooAnimal("Sophie", "giraffe", 2010, "zooPics/giraffe.jpg");
      ZooAnimal a4 = new ZooAnimal("Kevin", "koala", 2007, "zooPics/koala.jpg");
      ZooAnimal a5 = new ZooAnimal("Ozzie", "loris", 2008, "zooPics/loris.jpg");
      ZooAnimal teddy = new ZooAnimal("Teddy", "cat", 2013, "zooPics/koala.jpg");

      System.out.println();
      //CHECK: indexOf() when the item is not in the list
      System.out.println("List should return -1 for index of teddy, indexOf(teddy) returns " + list.indexOf(teddy));

      //CHECK: add() when the item should be added to the head of the list
      list.add(teddy);
      if (list.size() != 7)
      {
         System.out.println("Size of list should be 7");
      }
      System.out.println();
      System.out.println("List after adding teddy:");
      displayTextZoo(list);

      //CHECK: indexOf() when the item is the head of the list
      System.out.println();
      System.out.println("List should return 0 for index of teddy, indexOf(teddy) returns " + list.indexOf(teddy));
   }

   public static void check_toArray(SortedList<ZooAnimal> list)
   {
      System.out.println();
      System.out.println("Check the method toArray():"); 
        Object[] array = list.toArray();
        for (int i = 0; i < list.size(); i++)
        {
            if (array[i] instanceof ZooAnimal)
            {
                ZooAnimal animal = (ZooAnimal) array[i];
                System.out.print(animal.getName() + " ");
            }
        }
      System.out.println();
   }

   public static void check_clear(SortedList<ZooAnimal> list)
   {
      list.clear();
      if (list.size() != 0)
      {
         System.out.println("The size of the list should be zero.");
      }

      if (!list.isEmpty())
      {
         System.out.println("The list should be empty.");
      }
   }

   /** Display the sorted animal text. 
    *  @param animalList  the arrayList that contains all the ZooAnimal instance.
    */
   public static void displayTextZoo(SortedList<ZooAnimal> animalList)
   {
      for(int i = 0; i < animalList.size(); i++)
      {  
         ZooAnimal a = animalList.get(i);
         int age = 2018 - a.getBirthYear();
         System.out.print(a.getName() + " ");
         System.out.print(a.getSpecies() + " ");
         System.out.println(age);
      }
   }
}
