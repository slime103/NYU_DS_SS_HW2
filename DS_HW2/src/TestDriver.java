import java.util.Arrays;
import java.util.Random;

public class TestDriver {

	public static int isReversed(String s1, String s2) {
		
		//System.out.println("Is \"" + s1 + "\" the same as \"" + s2 + "\" reversed?");
		
		s1 = s1.replaceAll("\\s+", "");
		s2 = s2.replaceAll("\\s+", "");
		
		if (s1.length() == s2.length()) {
			
			s1 = s1.toLowerCase();
			s2 = s2.toLowerCase();
			
			//System.out.println(s1 + "," + s2);
			
			for (int i = 0; i < s1.length()-1;i++) {
				if (!(s1.charAt(i) == s2.charAt(s1.length()-1-i))) {
					System.out.println("no");
					return 0;
				}
			}
			
			//System.out.println("yes");
			return 1;
		}
		//System.out.println("no");
		return 0;
	}
	
	public static String shortestOfThreeWords(String s) {
		String temp = "";
		String[] eachWord = s.split(" ");
		for (int i = 0; i < eachWord.length-1; i+=3) {
			if (eachWord[i].length() <= eachWord[i+1].length()) {
				if (eachWord[i].length() <= eachWord[i+2].length()) {
					temp += eachWord[i] + " ";
				}
				else {
					temp += eachWord[i+2] + " ";
				}
			}
			else if (eachWord[i+1].length() <= eachWord[i+2].length()) {
				temp += eachWord[i+1] + " ";
			}
			else {
				temp += eachWord[i+2] + " ";
			}
		}
		return temp;
	}
	
	public static int maxInt(int[] arr, int start, int end) {
		
		if (start == end) {
			return arr[start];
		}
		
		int mid = (end+start)/2;
		
		int a = maxInt(arr,mid+1,end);
		int b = maxInt(arr,start,mid);
	
		if (a >= b) {
			return a;
		}
		else {
			return b;
		}
	}
	
	public static int binaryOnes(int n) {
		if (n == 0) {
			return 0;
		}
		return n%2 + binaryOnes(n/2);
	}
	
	public static int binaryZeros(int n) {
		if (n == 0) {
			return 0;
		}
		int remainder;
		if (n%2 == 0) {
			remainder = 1;
		}
		else {
			remainder = 0;
		}
		return remainder + binaryZeros(n/2);
	}
	
	public static boolean palindrome(String s, int start, int end) {
		if (start == end) {
			return true;
		}
		if (end < start) {
			return true;
		}
		if (s.charAt(start) == s.charAt(end)) {
			return palindrome(s,start+1,end-1);
		}
		else {
			return false;
		}
	}
	
	public static void printArray(int[] arr) {
		System.out.print("Array Values: ");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void swapInt(int[] arr, int a, int b) {
		arr[a] += arr[b];
		arr[b] = arr[a] - arr[b];
		arr[a] -= arr[b];
	}
	
	public static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1-i; j++) {
				if (arr[j] > arr[j+1]) {
					swapInt(arr,j,j+1);
				}
			}
		}
	}
	
	public static void bubble(int[] arr, int start, int n) {
		if (start < arr.length-1-n) {
			if (arr[start] > arr[start+1]) {
				swapInt(arr,start,start+1);
			}
			bubble(arr,start+1,n);
		}
	}
	
	public static void bubbleSortRecursive(int[] arr, int start) {
		if (start == arr.length-1) {
			return;
		}
		if (start < arr.length-1) {
			bubble(arr, 0, start);
			bubbleSortRecursive(arr, start+1);
		}
	}
	
	public static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					swapInt(arr,j,i);
				}
			}
		}
	}
	
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			while (j >= 0 && temp < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		int mid = (end+start)/2;
		if (start != end) {
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1,end);
			merge(arr, start, mid, end);
		}
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		int[] a = new int[mid-start+1];
		int[] b = new int[end-mid];
		
		int temp = 0;
		for(int i = start; i <= mid; i++) {
			a[temp] = arr[i];
			temp++;
		}
		
		temp = 0;
		for(int i = mid + 1; i <= end; i++) {
			b[temp] = arr[i];
			temp++;
		}
		
		int i = 0, j = 0;
		int k = start;
		
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				arr[k] = a[i];
				i++;
			}
			else {
				arr[k] = b[j];
				j++;
			}
			k++;
		}
		
		while (i < a.length) {
				arr[k] = a[i];
				i++;
				k++;
		}
		
		while (j < b.length) {
			arr[k] = b[j];
			j++;
			k++;
		}
	}
	
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if (left > right) {
			return;
		}
		Random rand = new Random();
		int pivot = rand.nextInt(right+1-left) + left+1;
		int index = partition(arr, left, right, pivot);
		quickSort(arr, left, index);
		quickSort(arr, index+1, right);
	}
	
	public static int partition(int[] arr, int left, int right, int pivot) {
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (arr[left] < arr[right]) {
				swapInt(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Reverse Testing
		String aba1 = "bats";
		String aba2 = "staB";
		String aba3 = " bats";
		String aba4 = "rata";
		
		System.out.println(isReversed(aba1,aba2));
		System.out.println(isReversed(aba2,aba3));
		System.out.println(isReversed(aba1,aba4));
		
		//Sentence Testing
		String sentence = "Hello my Dear, have you been waiting for me this whole time?";
		
		System.out.println(sentence);
		System.out.println(shortestOfThreeWords(sentence));
		
		//Max Testing
		int[] arr = new int[12];
		
		System.out.print("Array Values: ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
			System.out.print(arr[i] + ", ");
		}
		
		System.out.println("Max Int = " + maxInt(arr,0,11));
		
		//Binary Zero Testing
		for (int i = 0; i < 10; i++)
			System.out.println(i + " " + binaryZeros(i));
		
		//Palidrome
		String p = "kayak";
		String q = "coconut";
		System.out.println("Is " + p + " a palindrome?");
		System.out.println(palindrome(p,0,p.length()-1));
		System.out.println("Is " + q + " a palindrome?");
		System.out.println(palindrome(q,0,q.length()-1));
		
		//Sorting
		int[] sortyBoi = { 4 , 77 , 98 , 30 , 20 , 50 , 77 , 22 , 49 , 2 };
		
		printArray(sortyBoi);
		int[] bubbleSorted = Arrays.copyOf(sortyBoi, sortyBoi.length);
		bubbleSort(bubbleSorted);
		printArray(bubbleSorted);
		
		int[] bubbleSortedR = Arrays.copyOf(sortyBoi, sortyBoi.length);
		bubbleSortRecursive(bubbleSortedR, 0);
		printArray(bubbleSortedR);
		
		int[] selected = Arrays.copyOf(sortyBoi, sortyBoi.length);
		selectionSort(selected);
		printArray(selected);
		
		int[] inserted = Arrays.copyOf(sortyBoi, sortyBoi.length);
		insertionSort(inserted);
		printArray(inserted);
		
		int[] merged = Arrays.copyOf(sortyBoi, sortyBoi.length);
		mergeSort(merged, 0, merged.length-1);
		printArray(merged);
		
		int[] quick = Arrays.copyOf(sortyBoi, sortyBoi.length);
		quickSort(quick);
		printArray(quick);
		
	}

}
