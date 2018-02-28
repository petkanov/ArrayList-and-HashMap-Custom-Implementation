package com.egt.interactive.tasks.additional.arrlist_impl;

import java.util.Arrays;

public class ArrayPitList<T> implements PitList<T> {

    final private static int  INITIAL_VOLUME = 3; 
    final private static float RESIZE_FACTOR = 1.5f;
    
    private Object[] elements;
    private int size = 0;
    
    public ArrayPitList(){
	elements = new Object[INITIAL_VOLUME];
    }
    
    @Override
    public void add(final T value) {
	if(size == elements.length){
	    resize();
	}
	elements[size++] = value;
    }

    @Override
    public void add(final int index, final T value) {
	validateIndex(index);
	
	if (size == elements.length) {
	    final Object[] arrNew = new Object[(int) (elements.length * RESIZE_FACTOR)];

	    int i = 0;
	    while (i < index) {
		arrNew[i] = elements[i];
		i++;
	    }

	    arrNew[index] = value;

	    while (i < size) {
		arrNew[i + 1] = elements[i];
		i++;
	    }
	    elements = arrNew;
	    size++;
	} else {
	    int i = size;
	    while (i-- > index) {
		elements[i + 1] = elements[i];
	    }
	    elements[index] = value;
	    size++;
	}
    }

    @Override
    public void clear() {
	elements = new Object[INITIAL_VOLUME];
	size = 0;
    }

    @Override
    public boolean contains(final T value) {
	for (Object o : elements) {
	    if (o != null && o.equals(value)) {
		return true;
	    }
	}
	return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(final int i) {
	return (T)elements[i]; 
    }

    @Override
    public int indexOf(final T value) {
	int itemIndex = 0;
	
	for(Object o : elements){ 
	    if(o!=null && o.equals(value)){
		return itemIndex;
	    }
	    itemIndex++;
	}
	return -1;
    }

    @Override
    public boolean isEmpty() {
	return size==0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(final int index) {
	validateIndex(index);
	
	final Object obj = elements[index];
	
	for (int i = index; i < size-1; i++) {  
	    elements[i] = elements[i+1];
	}
	size--;System.out.println("ASDASDASDAS");
	return (T)obj;
    }

    @Override
    public boolean remove(final Object value) {
	if(value == null){
	    return false;
	}
	@SuppressWarnings("unchecked")
	T extracted = (T) value;
	
	if (contains(extracted)) {
	    remove( indexOf(extracted) );
	    return true;
	}
	return false;
    }

    @Override
    public void set(final int i, final T value) {
	validateIndex(i);
	elements[i] = value;
    }

    @Override
    public int size() {
	return size;
    }
    
    @Override
    public String toString() {
	final StringBuilder string = new StringBuilder("[");
	for (int i = 0; i < size; i++) {
	    string.append(elements[i].toString()+(i==size-1 ? "" : ", ") );
	}
	string.append("]");
        return string.toString();
    } 

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Arrays.hashCode(elements);
	result = prime * result + size;
	return result;
    }

    
    @Override
    public boolean equals(Object obj) {
	if (this == obj){
	    return true;
	}
	if (obj == null){
	    return false;
	}
	if (getClass() != obj.getClass()){ 
	    return false;
	}
	
	@SuppressWarnings("unchecked")
	PitList<T> other =  (PitList<T>) obj;
	
	if(size != other.size()){  
	    return false;
	}
	
	for(int i = 0; i < size; i++){
	    if(!elements[i].equals(other.get(i))){
		return false;
	    }
	}
	return true;
    } 
    
    private void validateIndex(final int index){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException("No such index " + index);
	}
    }
    
    private void resize(){ 
	final Object[] arrNew = new Object[(int) (elements.length*RESIZE_FACTOR)];
	for (int i = 0; i < elements.length; i++) {
	    arrNew[i] = elements[i];
	}
	elements = arrNew;  
    }
}
