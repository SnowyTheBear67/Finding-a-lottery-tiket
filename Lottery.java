/* Lance Boza
 * Dr. Andrew Steinberg
 * COP3503 Summer 2022
 * Programming Assignment 1
 */
import java.util.*;
public class Lottery {
	
	private String ticket;
	
	public Lottery(Random rn) {
		int num = rn.nextInt(999999);
		ticket = String.format("%06d", num);
	}
	
	public Lottery() {
		ticket = "";
	}
	
	public static String GenerateRandomWinner(Random rn) {
		int num = rn.nextInt(999999);
		return String.format("%06d", num);
		
	}
	
	public static int GenerateSelectWinner(int index, Random rn) {
		return rn.nextInt(index);
	}

	public static void Sort(Lottery[] ticketscollection) {
		mergeSort(ticketscollection, ticketscollection.length);
	}
	
	public static void mergeSort(Lottery[] array, int length) {
		if (length < 2) 
	        return;
	    int mid = length / 2;
	    Lottery[] left = new Lottery[mid];
	    Lottery[] right = new Lottery[length - mid];

	    for (int i = 0; i < mid; i++) 
	        left[i] = array[i];
	    
	    for (int i = mid; i < length; i++) 
	        right[i - mid] = array[i];
	    
	    mergeSort(left, mid);
	    mergeSort(right, length - mid);

	    merge(array, left, right, mid, length - mid);
	}
	
	public static void merge(Lottery[] array, Lottery[] l, Lottery[] r, int left, int right) {
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if(l[i].ticket.compareTo(r[j].ticket) <= 0)
				array[k++] = l[i++];
			
			else 
				array[k++] = r[j++];
			
		}
			    
		while (i < left) 
			array[k++] = l[i++];
		
		while (j < right) 
			array[k++] = r[j++];
		
	}

	public static boolean Solution1(Lottery[] ticketscollection, String test, int i) {
		// TODO Auto-generated method stub
		for(int j = 0; j < i; j++) {
			if(Integer.parseInt(ticketscollection[j].ticket) == Integer.parseInt(test)) {
				return true;
			}
		}
		return false;
	}

	public static boolean Solution2(Lottery[] ticketscollection, int i, int j, String test) {
		if(i == j) {
			if(ticketscollection[i].ticket.equals(test)) {
				return true;
			}
			return false;
		}
		int q = (i + j) /2 ;
		if(ticketscollection[q].ticket.equals(test)) {
			return true;
		}
		else if (test.compareTo(ticketscollection[q].ticket) < 0) {
			return Solution2(ticketscollection, i, q - 1, test);
		}
		else {
			return Solution2(ticketscollection, q + 1, j, test);
		}
	}
	
	public String GetTicket() {
		return ticket;
	}
}
