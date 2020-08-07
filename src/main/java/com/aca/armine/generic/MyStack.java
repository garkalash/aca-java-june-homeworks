package com.aca.armine.generic;

public class MyStack<E> extends MyCollection<E>{

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        E element;
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        element = (E)getElements()[getPointer()+ 1];
        getElements()[getPointer() + 1] = null;
        setPointer(getPointer()+ 1);
        return element;
    }

    @Override
    public void popAll(MyCollection<E> stack) {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        while (!isEmpty()) {
            stack.push(pop());
        }

    }
}
