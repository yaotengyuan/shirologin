package com.yaotengyuan.exception;

public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BusinessException(Object Obj) {
		super(Obj.toString());
	}
	public void Business() {
	   System.out.println("111111");
	}
public void Business1() {
	   System.out.println("111222222111");
	}
	public void Business2() {
	   System.out.println("33333333799");
	}
}
