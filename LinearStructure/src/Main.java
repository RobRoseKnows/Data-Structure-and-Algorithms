import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arrayList = new ArrayList<>();
		String[] strings = scanner.nextLine().split(" ");
		for(String str:strings)
			arrayList.add(Integer.valueOf(str));
		scanner.close();
		DSQueue<Integer> queue = new DSQueue<>();
		for(int e:arrayList)
			queue.enQueue(e);
		
		while(!queue.empty())
			System.out.print(queue.deQueue()+" ");
	}

}
