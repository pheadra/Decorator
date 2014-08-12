package com.cache.decorator;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}

public class ExpensiveFunction implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String arg) throws InterruptedException {
		// TODO Auto-generated method stub
		// 엄청 오래 하는 작
		
		return new BigInteger(arg);
	}
	
}


class Memorizer1<A, V> implements Computable<A, V>{

	private final Map<A ,V> cache = new ConcurrentHashMap<A, V>();

	private final Computable<A, V> c;
	
	public Memorizer1(Computable<A, V> c){
		this.c = c;
	}
	
	@Override
	public synchronized V compute(A arg) throws InterruptedException {
		// TODO Auto-generated method stub
		V result = cache.get(arg);
		if(result == null) {
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}	
}


class main {
	public static void main(String args[]) throws InterruptedException{
		
		Memorizer1<String, BigInteger> memorizer= new Memorizer1<String, BigInteger>(new ExpensiveFunction());
		memorizer.compute("10");
		
	}
}

