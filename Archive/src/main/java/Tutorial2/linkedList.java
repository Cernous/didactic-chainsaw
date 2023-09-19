package Tutorial2;

public class linkedList<T> implements iList<T>{
    // Unchecked cast...
    T[] array = (T[]) new Object[1000];
    int currsize = 0;

    @Override
    public int size() {
        // returns the size of the List
        return currsize;
    }

    @Override
    public void add(T n) {
        // appends a new number into the List at the last position
        array[currsize] = n;
        currsize += 1;
    }

    @Override
    public T remove(int index) {
        // removes the item at the index from the List
        T stand = array[index];
        for(int i = index + 1; i < currsize; i++){
            array[i - 1] = array[i];
        }
        currsize -= 1;
        return stand;
    }

    @Override
    public Boolean clear() {
        // deletes all elements from the List
        currsize = 0;
        return true;
    }
}
