package com.demo;

import java.util.Objects;

public class MyArrayList<E> {
	private E arr[] = null;
	private int count = 0;

	public MyArrayList(int size) {
		arr = (E[]) new Object[size];
	}

	public MyArrayList() {
		this(10);
	}

	private boolean isFull() {
		return count == arr.length;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	private E[] grow() {
	    int newCapacity = arr.length == 0
	            ? 1
	            : arr.length + Math.max(1, arr.length >> 1);

	    return java.util.Arrays.copyOf(arr, newCapacity);
	}

	public void add(E element) {
	    if (isFull()) {
	        arr = grow();
	    }

	    arr[count++] = element;
	}

	public int size() {
		return count;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size(); i++) {//
			sb.append(arr[i]);
			sb.append(",");
		}
		if (size() != 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");

		return sb.toString();
	}

	public void trimToSize() {
		arr = java.util.Arrays.copyOf(arr, count);
	}

	// Modified method logic
	public void add(int index, E element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException(
					"Index: " + index + ", Size: " + size() + " (index should be >= 0 and <= " + size() + ")");
		} else if (index == size()) {
			add(element);
		} else {
			if (isFull()) {
				arr = grow();
			}
			for (int i = size() - 1; i >= index; i--) {
				arr[i + 1] = arr[i];
			}
			arr[index] = element;
			count++;
		}
	}

	// new added method

	public E remove(int index) {
	    if (index < 0 || index >= size()) {
	        throw new IndexOutOfBoundsException(
	            "Index: " + index + ", Size: " + size()
	        );
	    }

	    E temp = arr[index];

	    for (int i = index; i < size() - 1; i++) {
	        arr[i] = arr[i + 1];
	    }

	    arr[--count] = null;

	    return temp;
	}
	
	public void clear() {
	    java.util.Arrays.fill(arr, 0, count, null);
	    count = 0;
	}

	public boolean contains(E element) {
		for (int i = 0; i < size(); i++) {
			if (Objects.equals(arr[i], element)) {
				return true;
			}
		}
		return false;
	}

	public int indexOf(E element) {
		for (int i = 0; i < size(); i++) {
			if (Objects.equals(arr[i], element)) {
				return i;
			}
		}

		return -1;
	}

	public int lastIndexOf(E element) {
		for (int i = size() - 1; i >= 0; i--) {
			if (Objects.equals(arr[i], element)){
				return i;
			}
		}

		return -1;
	}

	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size()
					+ " (index should be >= 0 and < " + size() + ")");
		}
		return arr[index];
	}

	public E set(int index, E element) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size()
					+ " (index should be >= 0 and < " + size() + ")");
		}
		E temp = arr[index];
		arr[index] = element;
		return temp;
	}
}
