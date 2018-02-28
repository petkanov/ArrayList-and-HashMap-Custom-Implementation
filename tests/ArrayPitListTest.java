package com.egt.interactive.tests.additional.arrlist_impl;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.egt.interactive.tasks.additional.arrlist_impl.ArrayPitList;
import com.egt.interactive.tasks.additional.arrlist_impl.PitList;


public class ArrayPitListTest {
    
    private PitList<Integer> list;
     
    @Test
    public void testAdd(){
	list = new ArrayPitList<>();
	
	final int testValue = 924;
	
	list.add(24); 
	list.add(testValue);
	
	final int lastValue = list.get( list.size()-1);
	
	Assert.assertEquals(lastValue, testValue);
    } 
    
    @Test
    public void testAddAtIndexLocation(){
	list = new ArrayPitList<>();
	
	final int testValue = 924;
	final int index = 1;
	
	final int first  = 12;
	final int middle = 13;
	final int last   = 14;
	
	list.add(first); 
	list.add(middle); // Index 1, after insertion should be with index 2
	list.add(last); 
	int currentValue = list.get(index);
	Assert.assertEquals(currentValue, middle);
	
	list.add(index, testValue); // now it should be moved right
	currentValue = list.get(index); // here is new added value
	Assert.assertEquals(currentValue, testValue);
	
	currentValue = list.get(index+1); // here should be old moved right value
	Assert.assertEquals(currentValue, middle);
    } 
    
    @Test
    public void testClear(){
	list = new ArrayPitList<>();
	
	list.add(1); 
	list.add(3); 

	list.clear();
	
	Assert.assertTrue(list.size()==0);
    } 
    
    @Test
    public void testContains(){
	list = new ArrayPitList<>();
	
	final int testValue = 924;
	
	final int first  = 12;
	final int middle = 13;
	final int last   = 14;
	
	list.add(first); 
	list.add(middle); 
	list.add(last); 

	Assert.assertTrue(list.contains(middle));
	
	Assert.assertFalse(list.contains(testValue));
    } 
    
    @Test
    public void testGet(){
	list = new ArrayPitList<>();
	
	final int testValue = 924;
	
	final int first  = 12;
	final int middle = 924; // index 1
	final int last   = 14;
	
	list.add(first); 
	list.add(middle); 
	list.add(last); 
	
	final int actual = list.get(1);
	Assert.assertEquals(actual, testValue);
	
    } 
    
    @Test
    public void testIndexOf(){
	list = new ArrayPitList<>();
	final int testValue = 924;
	
	final int first  = 12;
	final int middle = testValue; // index 1
	final int last   = 14;
	
	list.add(first); 
	list.add(middle); 
	list.add(last); 
	
	final int actual = list.indexOf(testValue);
	Assert.assertEquals(actual, 1);
    } 
    
    @Test
    public void testIsEmpty(){
	list = new ArrayPitList<>();
	
	final int first  = 12;
	final int last   = 14;
	
	list.add(first); 
	list.add(last); 
	
	Assert.assertFalse(list.isEmpty());
    } 
    
    @Test
    public void testRemoveAtIndex(){
	list = new ArrayPitList<>();
	
	final int first  = 12;
	final int second   = 13;
	
	list.add(first); 
	list.add(second); 
	
	final int removeAtIndex = 0;
	final int currentSize = list.size();
	final int removed = list.remove(removeAtIndex);
	
	Assert.assertEquals(removed, first);
	Assert.assertEquals((int)list.get(removeAtIndex), second); // second element should have been moved left
	Assert.assertEquals(list.size(), currentSize-1);
    } 
    
    @Test
    public void testRemoveValue(){
	list = new ArrayPitList<>();
	final int testValue = 222;
	
	final int first  = 12;
	final int middle = testValue; // index 1
	final int last   = 14;
	
	list.add(first); 
	list.add(middle); 
	list.add(last); 
	
	list.remove((Integer)testValue);
	final int currentValueAtIndex = list.get(1); // here should be moved 'last'
	Assert.assertEquals(currentValueAtIndex, last);
    } 
    
    @Test
    public void testSet(){
	list = new ArrayPitList<>();
	final int testValue = 99;
	
	final int first  = 12;
	final int middle = 13; // index 1
	final int last   = 14;
	
	list.add(first); 
	list.add(middle); 
	list.add(last); 
	
	list.set(1, testValue);
	Assert.assertEquals((int)list.get(1), testValue);
    } 
    
    @Test
    public void testSize(){
	list = new ArrayPitList<>();
	
	list.add(12); 
	list.add(2); 
	Assert.assertEquals(list.size(), 2);
	
	list.add(345); 
	Assert.assertEquals(list.size(), 3);
	
	list.remove(0); 
	list.remove((Integer)2 ); 
	Assert.assertEquals(list.size(), 1);
	
	list.clear();
	Assert.assertEquals(list.size(), 0);
    } 
}


