package Workshop2;

public class IntArrayBasedList implements IntList {
	
	int max_size = 10; 
	int INITIAL_VALUE = -1; 

	Integer[] datastorage; 
	
	
	public IntArrayBasedList() {
		datastorage = new Integer[max_size]; 
		
		for(int i=0;i<max_size;i++) {
			datastorage[i] = INITIAL_VALUE;
		}
		
	}
	
	
	@Override
	public boolean insert(int pos, int value) {
		
		if(pos<1000 && pos>=0) {
			 if(find(pos))
				return false; 
			datastorage[pos] = value; 
			return true; 
			
		}
		
		return false;
	}
	
	@Override
	public boolean find(int pos) {
		if(datastorage[pos]!=INITIAL_VALUE)
			return true;
		return false; 
	}
	
	@Override
	public boolean remove(int pos) {
		return false; 
	}

}
