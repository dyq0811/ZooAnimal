import java.util.Iterator;
import java.util.Arrays;

/**
 * Implementation of a generic linked list.
 * @author Jed Yang, 2018-02-02
 * @author Yingqi Ding, 2018-04-29
 */

public class SortedLinkedList implements SortedList<ZooAnimal>
{
   private static class Node
   {
      private ZooAnimal data;   // data of the item
      private Node next;        // link to next node

      public Node(ZooAnimal data)
      {
         this(data, null);
      }

      public Node(ZooAnimal data, Node nextNode)
      {
         this.data = data;
         this.next = nextNode;
      }
   }

   // instance variables, private
   private Node head;
   private int count;

   public SortedLinkedList()
   {
      head = null;
      count = 0;
   }

   /** Adds item to the list in sorted order.
       Complexity: O(n)
       @param item element to be added to the list
    */
   public void add(ZooAnimal item)
   {
      Node itemNode = new Node(item);
      if (head == null)
      {
         head = itemNode;
      }
      else
      {
         Node cur = head;
         Node beforeCur = null;
         while (cur.data.compareTo(item) < 0)
         {
            beforeCur = cur;
            cur = cur.next;
            if (cur == null)
            {
               beforeCur.next = itemNode;
               count++;
               return;
            }
         }

         itemNode.next = cur;
         if (beforeCur == null)
         {
            head = itemNode;
         }
         else
         {
            beforeCur.next = itemNode;
         }
      }
      count++;
   }

   /** Removes the specified element from this list, if it is present.  If this
       list does not contain the element, it is unchanged.  Returns true if
       this list contained the specified element.
       Complexity: O(n)
       @param targetItem element to be removed from this list, if present
       @return true if this list contained the specified element
    */
   public boolean remove(ZooAnimal targetItem)
   {
      if (count == 0)
      {
         return false;
      }

      Node cur = head;
      Node beforeCur = null;
      while (!cur.data.equals(targetItem))
      {
         beforeCur = cur;
         cur = cur.next;
         if (cur == null)
         {
            return false;
         }
      }

      count--;
      if (beforeCur == null)
      {
         head = cur.next;
         return true;
      }
      beforeCur.next = cur.next;
      return true;
   }

   /** Removes the element at the specified position in this list. Shifts any
       subsequent elements to the left (subtracts one from their indices).
       Returns the element that was removed from the list.
       Complexity: O(n)?
       @param i index of the element to be removed
       @return the element previously at the specified position
       @throws IndexOutOfBoundsException if the index is out of bounds.
    */
   public ZooAnimal remove(int i)
   {
      if (i < 0 || i >= count)
      {
         throw new IndexOutOfBoundsException("Index should be between 0 and count - 1");
      }

      Node cur = head;
      //Node beforeCur = null;
      for (int n = i; n > 0; n--)
      {
         //beforeCur = cur;
         cur = cur.next;
      }
      //beforeCur.next = cur.next
      //return cur.data;
      ZooAnimal temp = cur.data;
      remove(cur.data);
      return temp;
   }

   /** Returns the position of the item, or -1 if item is not in the list.
       Complexity: O(n)
       @param targetItem item
       @return The position of the item, or -1 if item is not in the list
    */
   public int indexOf(ZooAnimal targetItem)
   {
      if (count == 0)
      {
         return -1;
      }

      Node cur = head;
      int index = 0;
      while (!cur.data.equals(targetItem))
      {
         cur = cur.next;
         if (cur == null)
         {
            return -1;
         }
         index++;
      }
      return index;
   }

   /** Returns the element at the specified position in this list.
       Complexity: O(n)
       @param position specified position
       @return the element at the specified position in this list
       @throws IndexOutOfBoundsException if the index is out of bounds.
    */
   public ZooAnimal get(int position)
   {
      if (position < 0 || position >= count)
      {
         throw new IndexOutOfBoundsException("Index should be between 0 and size of the list - 1");
      }

      Node cur = head;
      for (int n = position; n > 0; n--)
      {
         cur = cur.next;
      }
      return cur.data;
   }

   /** Returns true if this list contains the specified element.
       Complexity: O(n)
       @param targetItem specified element
       @return true if this list contains the specified element
    */
   public boolean contains(ZooAnimal targetItem)
   {
      if (count == 0)
      {
         return false;
      }

      Node cur = head;
      while(!cur.data.equals(targetItem))
      {
         cur = cur.next;
         if (cur == null)
         {
            return false;
         }
      }
      return true;
   }

   /** Returns the number of elements in this list.
       Complexity: O(1)
       @return the number of elements in this list
    */
   public int size()
   {
      return count;
   }

   /** Returns true if this list contains no elements.
       Complexity: O(1)
       @return true if this list contains no elements
    */
   public boolean isEmpty()
   {
      if (count == 0)
      {
         return true;
      }
      return false;
   }

   /** Removes all of the elements from this list.
       Complexity: O(1)
    */
   public void clear()
   {
      head = null;
      count = 0;
   }

   /** Returns an array version of the list.  Note that, for technical reasons,
       the type of the items contained in the list can't be communicated
       properly to the caller, so an array of Objects gets returned.
       Complexity: O(n)
       @return an array of length size(), with the same items in it as are
               stored in the list, in the same order
    */
   public Object[] toArray()
   {
      if (count == 0)
      {
         System.err.println("The list is empty.");
      }

      Object[] array = new Object[count];
      Node cur = head;
      for (int i = 0; i < count; i++)
      {
         array[i] = cur.data;
         cur = cur.next;
      }
      return array;
   }

   /** Returns an iterator over the elements in this list in proper sequence.
       Not used. (Optional)
       @return an iterator over the elements in this list in proper sequence
       @throws UnsupportedOperationException if iterator not supported
    */
   public Iterator<ZooAnimal> iterator()
   {
      throw new UnsupportedOperationException("iterator() is not implemented!");
   }
}