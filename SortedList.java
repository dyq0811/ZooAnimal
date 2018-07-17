import java.util.Iterator;

/** SortedList interface adapted from Carrano 16.4 and java.util.List.
    A sorted list ADT is like a list, but maintains its entries in sorted order
    (rather than in the order they were inserted or the order that the user
    specified).
    @author Anna Rafferty
    @author Jed Yang
*/
public interface SortedList<T extends Comparable<? super T>> extends Iterable<T>
{
   /** Adds item to the list in sorted order.
       @param item element to be added to the list
   */
   public void add(T item);

   /** Removes the specified element from this list, if it is present.  If this
       list does not contain the element, it is unchanged.  Returns true if
       this list contained the specified element.
       @param targetItem element to be removed from this list, if present
       @return true if this list contained the specified element
   */
   public boolean remove(T targetItem);
   
   /** Removes the element at the specified position in this list. Shifts any
       subsequent elements to the left (subtracts one from their indices).
       Returns the element that was removed from the list.
       @param i index of the element to be removed
       @return the element previously at the specified position
       @throws IndexOutOfBoundsException if the index is out of bounds.
   */
   public T remove(int i);

   /** Returns the position of the item, or -1 if item is not in the list.
       @param targetItem item
       @return The position of the item, or -1 if item is not in the list
   */
   public int indexOf(T targetItem);

   /** Returns the element at the specified position in this list.
       @param position specified position
       @return the element at the specified position in this list
       @throws IndexOutOfBoundsException if the index is out of bounds.
   */
   public T get(int position);
   
   /** Returns true if this list contains the specified element.
       @param targetItem specified element
       @return true if this list contains the specified element
   */
   public boolean contains(T targetItem);

   /** Returns the number of elements in this list.
       @return the number of elements in this list
   */
   public int size();

   /** Returns true if this list contains no elements.
       @return true if this list contains no elements
   */
   public boolean isEmpty();

   /** Removes all of the elements from this list. */
   public void clear();

   /** Returns an array version of the list.  Note that, for technical reasons,
       the type of the items contained in the list can't be communicated
       properly to the caller, so an array of Objects gets returned.
       @return an array of length size(), with the same items in it as are
            stored in the list, in the same order
   */
   public Object[] toArray();

   /** Returns an iterator over the elements in this list in proper sequence.
       (Optional.)
       @return an iterator over the elements in this list in proper sequence
       @throws UnsupportedOperationException if iterator not supported
   */
   public Iterator<T> iterator();
}
