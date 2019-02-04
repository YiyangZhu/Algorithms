package MS;

import java.util.Iterator;

public interface Tree<E> extends Iterator<E> {
    public boolean search(E e);
    public boolean insert(E e);
    public boolean delete(E e);
    public void inorder();
    public void postorder();
    public void preorder();
    public int getSize();
    public boolean isEmpty();
}
