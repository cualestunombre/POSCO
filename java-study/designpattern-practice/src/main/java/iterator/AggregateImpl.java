package iterator;


public class AggregateImpl<T> implements Aggregate<T> {
    
    private T[] data = null;
    
    public AggregateImpl(T[] data) {
        this.data = data;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl();
    }
    
    // 클래스 내부 클래스(클래스 내부 클래스 개념)
    private class IteratorImpl implements Iterator<T>{
        
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < data.length;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return data[currentIndex++];
            }
            throw new IndexOutOfBoundsException("Iterator has no more elements");
        }
        
    }
}
