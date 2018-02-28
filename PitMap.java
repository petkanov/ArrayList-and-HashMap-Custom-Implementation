package com.egt.interactive.tasks.additional.hashmap_impl;

public interface PitMap<K, V> {
    
    public void clear();               // Removes all of the mappings from this map.
    public boolean containsKey(K key); // Returns true if this map contains a mapping for the specified key.
    public boolean containsValue(V value); // Returns true if this map maps one or more keys to the specified value.
    public V get(K key);              // Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
    public boolean isEmpty();         // Returns true if this map contains no key-value mappings.
    public void put(K key, V value);  // Associates the specified value with the specified key in this map.
    public void remove(K key); 	      // Removes the mapping for the specified key from this map if present.
    public int size();                // Returns the number of key-value mappings in this map
}
