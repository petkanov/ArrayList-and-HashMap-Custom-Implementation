package arrlist_impl;

public interface PitList<T> {

    public void add(T value);         // Appends the specified element to the end of this list
    public void add(int i, T value);  // Adds the element on the i index and shifts the other elements
    public void clear();              // Removes all of the elements from this list
    public boolean contains(T value); // Returns true if this list contains the specified element
    public T get(int i);              // Returns the element on the i index of the list
    public int indexOf(T value);      // returns the index the value was found in the list or -1 if it was not found
    public boolean isEmpty();         // Returns true if the list is empty
    public T remove(int i);           // Removes the elements on the i index and returns it
    public boolean remove(Object value);   // Removes the first occurrence of the given value and returns true/false whether it was found
    public void set(int i, T value);  // Sets the element on the i index to the given value
    public int size();                // Returns the number of elements in the list
}
