package hashmap_impl;

import java.util.Arrays;

public class HashPitMap<K, V> implements PitMap<K, V> {

    private static final int SIZE = 13;
    private int size = 0;

    @SuppressWarnings("unchecked")
    private Entry<K, V>[] table = new Entry[SIZE];

    private static class Entry<K, V> {
	private final K key;
	private V value;
	private Entry<K, V> next;

	Entry(final K key, final V value) {
	    this.key = key;
	    this.value = value;
	} 

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((key == null) ? 0 : key.hashCode());
	    result = prime * result + ((value == null) ? 0 : value.hashCode());
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
	    Entry<K,V> other = (Entry<K,V>) obj;
	    
	    if (key == null) {
		if (other.key != null) {
		    return false;
		}
	    } else {
		if (!key.equals(other.key)) {
		    return false;
		}
	    }

	    if (value == null) {
		if (other.value != null) {
		    return false;
		}
	    } else {
		if (!value.equals(other.value)) {
		    return false;
		}
	    }
	    return true;
	}
    }

    private int getBucketIndex(K key) {
	if(key==null){
	    return 0;
	}
	return Math.abs( key.hashCode() % SIZE);
    } 
    
    @Override
    public void put(final K key, final V value) {
	final int bucketIndex = getBucketIndex(key);
	Entry<K, V> entry = table[bucketIndex];

	// Check if there is an entry with the same Key already in the current bucket
	// If it is there, then we replace it's value with the new one
	for (; entry != null; entry = entry.next) {
	    if(key == entry.key){ // true if both null or the same object
		entry.value = value;
		return;
	    }
	    else if (entry.key!=null && entry.key.equals(key)) {
		entry.value = value;
		return;
	    }
	}
	// If it is not then we add/put it there
	Entry<K, V> newEntry = new Entry<>(key, value);
	newEntry.next = table[bucketIndex]; // Put it at the beginning of the Entry Items Linked List
	table[bucketIndex] = newEntry; // Add it to the bucket
	size++;
    } 
    
    @Override
    public V get(final K key){
	Entry<K,V> entry = table[ getBucketIndex(key) ];
	
	while(entry != null){
	    if(key == entry.key){
		return entry.value;
	    }
	    if(entry.key != null && entry.key.equals(key)){
		return entry.value;
	    }
	    entry = entry.next;
	}
	return null;
    }    
    
    @SuppressWarnings("unchecked")
    @Override
    public void clear() { 
	table = new Entry[SIZE];
	size = 0;
    }

    @Override
    public boolean containsKey(final K key) {
	final int bucketIndex = getBucketIndex(key);
	Entry<K, V> entry = table[bucketIndex];

	for (; entry != null; entry = entry.next) {
	    if (entry.key.equals(key)) { 
		return true;
	    }
	}
	return false;
    }

    @Override
    public boolean containsValue(final V value) {
	for(int i = 0; i < SIZE; i++){
	    Entry<K,V> entry = table[i];
	    while(entry != null){
		if(entry.value.equals(value)){
		    return true;
		}
		entry = entry.next;
	    }
	}
	return false;
    } 

    @Override
    public boolean isEmpty() {
	return size == 0;
    } 

    @Override
    public void remove(final K key) {
	final int bucketIndex = getBucketIndex(key);
	Entry<K, V> entry = table[bucketIndex];

	if(key == entry.key){
	    table[bucketIndex] = entry.next; // Link to the next Item after deleted one
	    size--;
	}
	if(entry.key!=null && entry.key.equals(key)){
	    table[bucketIndex] = entry.next;  
	    size--;
	}
	
	for (; entry != null; entry = entry.next) {
	    if (entry.next!=null && entry.next.key.equals(key)) { 
		entry.next = entry.next.next; // Link to the next Item after deleted one
		size--;
	    }
	}
    }

    @Override
    public int size() {
	return size;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + size;
	result = prime * result + Arrays.hashCode(table);
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
	HashPitMap<K,V> other = (HashPitMap<K,V>) obj;
	
	if (size != other.size){
	    return false;
	}
	if (!Arrays.equals(table, other.table)){
	    return false;
	}
	return true;
    }
}
