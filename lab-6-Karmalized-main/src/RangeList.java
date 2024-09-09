
public class RangeList extends IntegerList {
	public RangeList() {
		super();
	}
	
	public RangeList(int lowerBound, int upperBound) throws IllegalArgumentException {
		super();
		if(lowerBound > upperBound) {
			throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
		} else {
			for(int i = lowerBound; i <= upperBound; i++)
			super.insert(super.size(),i);
		}
	}
	
	public void add(int lowerBound, int upperBound) throws IllegalArgumentException {
		if(lowerBound > upperBound) {
			throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
		}
		if(super.size() == 0) {
			for(int i = lowerBound; i <= upperBound; i++)
				super.insert(super.size(),i);
		} else {
			if(lowerBound < super.get(0)) {
				int placeholder = super.get(0)-1;
				for(int i = placeholder; i > lowerBound; i--) {
					super.insert(0, i);
				}
				super.insert(0, lowerBound);
				System.out.println(super.toString());
			}
				if(upperBound > super.get(super.size()-1)) {
				for(int i = super.get(super.size()-1)+1; i < upperBound; i++) {
						super.insert(super.size(), i);
				}
				super.insert(super.size(),upperBound);
				System.out.println(super.toString());
			}
		}
	}
	
	public void remove(int lowerBound, int upperBound) throws IllegalArgumentException {
		if(lowerBound > upperBound) {
			throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
		}
		if(super.size() == 0) {
			throw new UnsupportedOperationException("Cannot remove range from an empty list.");
		}
		if(upperBound > super.get(super.size()-1) || lowerBound < super.get(0)) {
			throw new IllegalArgumentException("Lower and/or upper bounds are out of the current list range.");
		} else {
			for(int i = lowerBound; i < upperBound; i++) {
				super.remove(super.indexOf(i));
			}
			super.remove(super.indexOf(upperBound));
		}
	}
	
	public void add(int integer) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public void insert(int index, int integer) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}
