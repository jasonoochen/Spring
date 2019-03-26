package jason.spring.beans;

import java.util.*;

public class test {
	int version;
	int[] val;
	Map<Integer, int[]> ss;
	public test(int size) {
		val = new int[size];
		version = 0;
		ss = new HashMap<>();
	}
	public int get(int version, int index) {
		return ss.get(version)[index];
	}
	public void set(int index, int value) {
		val[index] = value;
	}
	public void snapshot() {
		ss.put(version, val.clone());
		version++;
	}
	public static void main(String[] args) {
		test t = new test(5);
		t.set(1, 1);
		t.snapshot();
		t.set(1, 2);
		t.snapshot();
		System.out.println(true || false && false || false);
	}

}
