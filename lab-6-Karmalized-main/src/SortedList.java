import java.util.Arrays;

public class SortedList extends IntegerList {

	public SortedList() {
		super();
	}
	
	public SortedList(int capacity) {
		super(capacity);
	}
	
	public void add(int integer) {
		if(super.size() == 0)
			super.insert(0,integer);
		else {
		int[] copyList = new int[super.size()+1];
		for(int i = 0; i < super.size(); i++) {
			copyList[i] = super.get(i);
		}
		copyList[copyList.length-1] = integer;
		Arrays.sort(copyList);
		for(int i = 0; i < copyList.length; i++) {
			if(copyList[i] == integer) {
				super.insert(i, integer);
				break;
			}
		}
		}
	}
	
	public void insert(int index, int integer) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}
