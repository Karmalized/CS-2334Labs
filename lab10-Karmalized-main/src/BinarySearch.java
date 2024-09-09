import java.util.LinkedList;
import java.util.List;

public class BinarySearch {

	/**
	 * Search a sorted list of strings using binary search. Return a list of
	 * the indices of the strings checked during the search in the order they
	 * are checked. If the target string is not found, append -1 to the end of
	 * the list. Otherwise, the last element is the index of the target.
	 *
	 * @param strings  the list to be searched
	 * @param target  the string to be searched for
	 * @param fromIdx  the index of the first string in the range of strings to
	 *                 be searched (inclusive)
	 * @param toIdx  the index of the last string in the range of strings to be
	 *               searched (inclusive)
	 * @return a list of the indices of the strings checked during the search.
	 *         If the target is not in the list, the last element is -1.
	 */
	public static List<Integer> binarySearch(List<String> strings,
			String target, int fromIdx, int toIdx) {
		List<Integer> IdxList = new LinkedList<Integer>();
		int midIdx = (fromIdx + toIdx)/2;
		
		if(strings.get(midIdx).equals(target) == true) {
			IdxList.add(midIdx);
			return IdxList;
		}
		if(fromIdx > toIdx) {
			IdxList.add(-1);
			return IdxList;
		}
		if(target.compareTo(strings.get(midIdx)) > 0) {
			IdxList.add(midIdx);
			 IdxList.addAll(binarySearch(strings,target,midIdx+1,toIdx));
		}
		if(target.compareTo(strings.get(midIdx)) < 0) {
			IdxList.add(midIdx);
			IdxList.addAll(binarySearch(strings,target,fromIdx,midIdx-1));
		}
		
		return IdxList;
	}
}
