package com.ds.oops;

public class OopsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Car c1= new Car();
		Car c2=new BMW();
		BMW b1=new BMW();
		System.out.println(c1.startEngine()+" "+c1.accelerate());
		System.out.println(c1.openDoor());
		System.out.println(c2.startEngine()+" "+c2.accelerate());
		System.out.println(c2.openDoor());
		System.out.println(b1.startEngine()+" "+b1.accelerate());
		System.out.println(b1.openDoor());
	}

}
