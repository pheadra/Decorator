package com.headfirst.decorator;

import com.headfirst.pattern.Beverage;

public class Whip extends Beverage {

	Beverage beverage;
	public Whip(Beverage beverage) {
		this.beverage = beverage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + "휘핑! ";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 0.40 + beverage.cost();
	}

}
