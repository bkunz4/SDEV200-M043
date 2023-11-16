import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collection;

public class Exercise24_03 {
  public static void main(String[] args) {
    new Exercise24_03();
  }
  
  public Exercise24_03() {
    TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
    System.out.print("Enter five numbers: ");
    Scanner input = new Scanner(System.in);
    double[] v = new double[5];
    for (int i = 0; i < 5; i++) 
      v[i] = input.nextDouble();

    list.add(v[1]);
    list.add(v[2]);
    list.add(v[3]);
    list.add(v[4]);
    list.add(0, v[0]);
    list.add(2, 10.55);
    list.remove(3);

    java.util.ListIterator<Double> iterator1 = list.listIterator();
    System.out.print("The list in forward order: ");
    while (iterator1.hasNext())
      System.out.print(iterator1.next() + " ");

    java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
    System.out.print("\nThe list in backward order: ");
    while (iterator2.hasPrevious())
      System.out.print(iterator2.previous() + " ");
  }
} 

interface MyList<E> extends java.util.Collection<E> {
  /** Add a new element at the specified index in this list */
  public void add(int index, E e);

  /** Return the element from this list at the specified index */
  public E get(int index);

  /** Return the index of the first matching element in this list.
   *  Return -1 if no match. */
  public int indexOf(Object e);

  /** Return the index of the last matching element in this list
   *  Return -1 if no match. */
  public int lastIndexOf(E e);

  /** Remove the element at the specified position in this list
   *  Shift any subsequent elements to the left.
   *  Return the element that was removed from the list. */
  public E remove(int index);

  /** Replace the element at the specified position in this list
   *  with the specified element and returns the new set. */
  public E set(int index, E e);
  
  @Override /** Add a new element at the end of this list */
  public default boolean add(E e) {
    add(size(), e);
    return true;
  }

  @Override /** Return true if this list contains no elements */
  public default boolean isEmpty() {
    return size() == 0;
  }

  @Override /** Remove the first occurrence of the element e 
   *  from this list. Shift any subsequent elements to the left.
   *  Return true if the element is removed. */
  public default boolean remove(Object e) {
    if (indexOf(e) >= 0) {
      remove(indexOf(e));
      return true;
    }
    else
      return false;
  }

  @Override
  public default boolean containsAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean addAll(Collection<? extends E> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean removeAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean retainAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default Object[] toArray() {
    // Left as an exercise
    return null;
  }

  @Override
  public default <T> T[] toArray(T[] array) {
    // Left as an exercise
    return null;
  }
}

class TwoWayLinkedList<E> implements MyList<E> {
  private Node<E> head, tail;
  private int size;

  /** Create a default list */
  public TwoWayLinkedList() {
  }

  /** Create a list from an array of objects */
  public TwoWayLinkedList(E[] objects) {
    for (E e : objects)
      add(e);
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    } else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
    return null;
    } else {
      return tail.element;
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      } else {
        result.append("]"); // Insert the closing ] in the string
      }
    }

    return result.toString();
  }

  /** Clear the list */
  public void clear() {
    head = tail = null;
    size = 0; // set size to 0 since the list is empty
  }

  /** Return true if this list contains the element o */
  public boolean contains(Object e) {
    System.out.println("Implementation left as an exercise");
    return true;
  }

   /** Return the element from this list at the specified index */
  public E get(int index) {
    System.out.println("Implementation left as an exercise");
    return null;
  }

  /**
  * Return the index of the head matching element in this list. Return -1 if
  * no match.
  */
  public int indexOf(Object e) {
    System.out.println("Implementation left as an exercise");
    return 0;
  }

  /**
  * Return the index of the last matching element in this list Return -1 if
  * no match.
  */
  public int lastIndexOf(Object e) {
    System.out.println("Implementation left as an exercise");
    return 0;
  }

   /**
  * Replace the element at the specified position in this list with the
  * specified element.
  */
  public E set(int index, E e) {
    System.out.println("Implementation left as an exercise");
    return null;
  }

  private class LinkedListIterator implements java.util.ListIterator<E> {
    private Node<E> current = head; // Current index

    public LinkedListIterator() {
    }

    public LinkedListIterator(int index) {
      if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      for (int nextIndex = 0; nextIndex < index; nextIndex++)
        current = current.next;
    }

    public void setLast() {
      current = tail;
    }

    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public E next() {
      E e = current.element;
      current = current.next;
      return e;
    }

    @Override
    public void remove() {
      System.out.println("Implementation left as an exercise");
    }

    @Override
    public void add(E e) {
      System.out.println("Implementation left as an exercise");
    }

    @Override
    public boolean hasPrevious() {
      return current != null;
    }

    @Override
    public int nextIndex() {
       System.out.println("Implementation left as an exercise");
       return 0;
    }

    @Override
    public E previous() {
       E e = current.element;
       current = current.previous;
       return e;
    }

    @Override
    public int previousIndex() {
       System.out.println("Implementation left as an exercise");
       return 0;
    }

    @Override
    public void set(E e) {
         current.element = e; // TODO Auto-generated method stub
    }
  }

  private class Node<E> {
     E element;
     Node<E> next;
     Node<E> previous;

     public Node(E o) {
       element = o;
     }
  }

  @Override
  public int size() {
     return size;
  }

  public ListIterator<E> listIterator() {
    return new LinkedListIterator();
  }

  public ListIterator<E> listIterator(int index) {
    return new LinkedListIterator(index);
  }

  @Override
  public Iterator<E> iterator() {
       // TODO Auto-generated method stub
       return null;
  }

     // BEGIN REVEL SUBMISSION
     /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<>(e);
    if (head == null) {
      tail = newNode; // update tail to point to node
    }
    else // non-empty list
    {
      newNode.next = head; // update next of node to head
      head.previous = newNode; // update previous of head to node
    }
    head = newNode; // update head to point to node
    size++; // increment size by 1

  }

  /** Add an element to the end of the list */
  public void addLast(E e) {

    // create a new Node for value e
    Node<E> newNode = new Node<>(e);
    if(head == null) // empty list
      head = newNode; // update head to point to node
    else // non-empty list
    {
      newNode.previous = tail; // update previous of node to tail
      tail.next = newNode; // update next of tail to node
    }

    tail = newNode; // update tail to point to node
    size++; // increment size by 1
  }

  /** Add a new element at the specified index in this list The index of the head element is 0 */
  public void add(int index, E e) {

    if(index == 0) // insert at head
      addFirst(e);
    else if(index == size) // insert at tail
      addLast(e);
    // insert in middle
    else if(index > 0 && index < size) {

      // create a new node for value e
      Node<E> node = new Node<E>(e);

      Node<E> current = head; // set current to head

      // loop over the list until the node at index is reached
      while(index > 0) {
         current = current.next;
         index--;
      }

      // insert node before current
      node.next = current; // update next of node to current
      node.previous = current.previous; // update previous of node to previous of current
      current.previous.next = node; // update next of node previous to current to node 
      current.previous = node; // update previous of current to node
      size++; // increment size by 1
    }
  }

         /**
          * Remove the head node and return the object that is contained in the
          * removed node.
          */
  public E removeFirst() {
    if(head != null) // non-empty list
    {
      E element = head.element; // set element to element at head
      
      head = head.next; // update head to next node
      if(head == null) // list is empty after removal
        tail = null; // update tail to null
      else // list is not empty, update previous of head to null
        head.previous = null;

      size--; // decrement size by 1
      return element; // return element
    }
    else // list is empty, return null
      return null;
  }

          /**
          * Remove the last node and return the object that is contained in the
          * removed node.
          */
  public E removeLast() {
    if(head != null) // non-empty list
    {
      E element = tail.element; // set element to element at tail
      
      tail = tail.previous; // update tail to node previous of tail
      if(tail == null)  // list is empty after removal
        head = null; // update head to null
      else // list is not empty, update next of tail to null
        tail.next = null;

      size--; // decrement size by 1
      return element; // return element
    }
    else // list is empty, return null
      return null;
  }

         /**
          * Remove the element at the specified position in this list. Return the
          * element that was removed from the list.
          */
  public E remove(int index) {
    if(index == 0) // remove head
      return removeFirst(); 
    else if(index == size-1) // remove tail
      return removeLast();
    // remove middle element
    else if(index > 0 && index < size-1) {
      Node<E> current = head; // set current to head

      // loop to get the node at index
      while(index > 0) {
        current = current.next;
        index--;
      }

             // remove current node
      current.previous.next = current.next; // update next of node previous to current to node next to current
      current.next.previous = current.previous; // update previous of node next to current to node previous to current
      size--; // decrement size by 1
      return current.element; // return the element of current node
    }
    else // invalid index, return null
      return null;
  }
}