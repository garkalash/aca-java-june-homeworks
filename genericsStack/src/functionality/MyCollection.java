package functionality;

import exceptions.MemoryOutOfBounds;

import java.util.List;

public interface MyCollection<T> {
        Integer getSize();
        void push(T item);
        T pop() throws MemoryOutOfBounds;
        boolean isEmpty();
        void pushAll(List<? extends T> list);
        void popAll(List<? super T> it);
}
