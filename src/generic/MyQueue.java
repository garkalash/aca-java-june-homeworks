package generic;

public class MyQueue<E> extends MyCollection<E> {

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        E element;
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        element = (E) getElements()[getElements().length - 1];
        getElements()[getElements().length - 1] = null;
        shift(getElements());
        setPointer(getPointer() + 1);

        return element;
    }
    private void shift(Object[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
    }


    @Override
    public void popAll(MyCollection<E> queue) {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        while (!isEmpty()) {
            queue.push(pop());
        }
    }

}
