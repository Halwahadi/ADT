import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class ADT {
	
	public static void main(String [] args) throws IOException {
		File f = new File("alphaOutput.txt");
		BufferedWriter output = new BufferedWriter(new FileWriter(f));
		List<String> l = new LinkedList<String>();
		Scanner reader;
		
		// TODO 1. Read file and place into linked list
		
		try {
			reader = new Scanner(new File("alphaWords.txt"));
			while (reader.hasNext()){
				String str = reader.nextLine();
				l.add(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//TODO 2. Add items from list to array
		
		String[] a = new String[l.size()];
		for(int i = 0; i< l.size(); i++) {
			a[i] = l.get(i);
		}
		
		//TODO 3. Put array into new file "alphaOutPut.txt". Beginning line "Words from Array"
		
		try {
			output.write("Words from Array\n");
			for(int i = 0; i < a.length; i++) {
				output.write(a[i]);
				output.newLine();
			}
			//output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//TODO 4. add array elements randomly to a set
		Set<String> s = new HashSet<String>();
		for(String i : a) {
			s.add(i);
		}
		
		
		output.newLine();
		
		
		//TODO 5. Put set into 'alphaOutput.txt' Starting with "Words from Set"
		try {
			Iterator<String> i = s.iterator();
			output.write("Words from Set\n");
			while(i.hasNext()) {
				output.write(i.next());
				output.newLine();
			}
			//output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//TODO 6. Add elements from set to priority queue sequentially
		PriorityQueue <String> pq = new PriorityQueue<String>();
		for(String i: s) {
			pq.add(i);
		}
		
		
		output.newLine();
		
		
		//TODO 7. put priority queue on output text file with header "Words from Priority Queue"
		try {
			output.write("Words from Priority Queue\n");
			for(Iterator<String> i = pq.iterator(); i.hasNext();) {
				output.write(pq.poll());
				output.newLine();
			}
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
		
}
