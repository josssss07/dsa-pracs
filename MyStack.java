//practical 2:to create user defined stack data structure
package edu;

import java.util.Scanner;

public class MyStack {
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public MyStack(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	public void push(long j) {
		stackArray[++top] = j;
	}
	public long pop() {
		long y=stackArray[top];
		--top;
		return y;
	}
	public long peek() {
		return stackArray[top];
	}
	public boolean isEmpty() {
		return (top == -1); //if stack is empty, top is -1
	}
	public boolean isFull() {
		return (top == maxSize - 1);
	}
	
	public static void main(String [] args) {
		System.out.println(" **********Stack Demo**********");
		Scanner sc = new Scanner(System.in);
		System.out.println( "Enter the total element sof stack ");
		int max = sc.nextInt();
		MyStack st = new MyStack(max);
		
		for(int i=0;i<max;i++) {
			System.out.println(" Enter element :"+(i+1));
			long v=sc.nextLong();
			st.push(v);
		}
		for(int i=0;i<max;i++) {
			System.out.print(st.pop());
		}
		
	
	}
}
