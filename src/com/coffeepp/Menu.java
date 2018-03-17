package com.coffeepp;

public class Menu {
	public void test1(int a, String b) {
		Logger l = new Logger();
		l.enter(this, "test1", Integer.toString(a), b);
		
		a = this.test2();
		
		l.exit(this, "test1", "void");
	}

	public int test2() {
		Logger l = new Logger();
		l.enter(this, "test2");
		
		l.exit(this, "test2", Integer.toString(5));
		
		return 5;
	}
	@Override
	public String toString() {
		return "Menu";
	}
}
