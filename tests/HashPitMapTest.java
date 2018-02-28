package com.egt.interactive.tests.additional.hashmap_impl;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.egt.interactive.tasks.additional.hashmap_impl.HashPitMap;
import com.egt.interactive.tasks.additional.hashmap_impl.PitMap;


public class HashPitMapTest {

    
    private PitMap<Integer, String> map;

    @Test
    public void testClearMethod(){
	map = new HashPitMap<>();
	
	map.put(12, "one");
	map.put(2, "two");
	
	map.clear();
	
	Assert.assertEquals( map.size(), 0);
    } 
    
    @Test
    public void testContainsKey(){
	map = new HashPitMap<>();
	
	final int key = 5;
	final int falseKey = 9;
	
	map.put(key, "one");
	
	Assert.assertTrue( map.containsKey(key));
	Assert.assertFalse( map.containsKey(falseKey));
    } 

    @Test
    public void testContainsValue(){
	map = new HashPitMap<>();
	
	final String value = "true value";
	final String falseValue = "false value";
	
	map.put(1, value);
	
	Assert.assertTrue( map.containsValue(value));
	Assert.assertFalse( map.containsValue(falseValue));
    } 

    @Test
    public void testGetPut(){
	map = new HashPitMap<>();
	
	final String value = "true value";
	final int key = 3;
	
	Assert.assertEquals(map.get(key), null);

	map.put(key, value);
	
	Assert.assertEquals(map.get(key), value);
    } 

    @Test
    public void testIsEmpty(){
	map = new HashPitMap<>();
	
	Assert.assertTrue(map.isEmpty());
	
	final String value = "true value";
	final int key = 3;
	
	map.put(key, value);
	
	Assert.assertFalse(map.isEmpty());
    } 
    
    @Test
    public void testRemove(){
	map = new HashPitMap<>();
	
	final String value = "true value";
	final int key = 3;
	
	map.put(key, value);
	Assert.assertEquals(map.get(key), value);
	
	map.remove(key);
	Assert.assertEquals(map.get(key), null);
	
	// Now we put 3 elements so they end up in the same Linked List line
	// so when we delete middle one the first and last are linked
	// If they are not, then the last one will be lost
	map.clear();
	map.put(15, "first");
	map.put(28, "middle");
	map.put(41, "last");
	
	map.remove(28);
	Assert.assertEquals(map.get(41), "last");
	
    } 
    
    @Test
    public void testSize(){
	map = new HashPitMap<>();
	
	map.put(1, "vlaue");
	map.put(2, "some value");
	Assert.assertEquals(map.size(), 2);
	
	map.put(1, "some other value"); // the same key but different value
	Assert.assertEquals(map.size(), 2); // size stays the same
	
	map.remove(1);
	Assert.assertEquals(map.size(), 1);
    } 
}


