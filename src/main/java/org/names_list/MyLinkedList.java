package org.names_list;


/**
 * Class org.names_list.MyLinkedList
 * author Igor Novikov
 * 11.10.24
 */

public class MyLinkedList<E> {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if(tail == null) {                          // Якщо список порожній, перший і останній елемент це дані
            head = newNode;                         // Ссылка первый элемент = data
            tail = newNode;                         // Посилання на останній елемент = data
        } else {
            tail.next = newNode;                    // Останній елемент посилається на новий елемент як наступний
            newNode.prev = tail;                    // Новий елемент посилається на останній у списку як минулий
            tail = newNode;                         // Останній у списку тепер новий елемент
        }
        this.size++;
    }

    public void add(int index, E data) {
        this.checkIndex(index);
        Node<E> itemOld = this.getIndexItem(index);
        Node<E> itemNew = new Node<>(data);

        if (itemOld.prev != null) {                 // У зрушеного був prev
            itemOld.prev.next = itemNew;            // Елемент перед новим має посилатися на новий елемент
            itemNew.prev = itemOld.prev;            // Prev зсувається веде на новий елемент
        } else {
            head = itemNew;                         // Новий елемент перший
        }

        itemOld.prev = itemNew;                     // Prev минулого веде на новий
        itemNew.next = itemOld;                     // Next нового на старий

        if (itemOld.next == null) {                 // Минулий був останнім
            tail = itemOld;                         // Таким і залишаємо його
        }
        this.size++;
    }


    public E get(int index) {                       // Поверне елемент за індексом
        this.checkIndex(index);                     // Валідація index
        Node<E> item = getIndexItem(index);         // Отримуємо посилання на елемент
        return item.data;                           // Повернемо дані
    }

    public boolean destroy(int index) {             // Видаляє елемент за індексом
        this.checkIndex(index);                     // Валідація index
        Node<E> item = getIndexItem(index);         // Отримуємо посилання на елемент

        if (item.prev != null) {                    // Є посилання на минулий елемент
            item.prev.next = item.next;             // Посилання на наступний елемент із видаленого, присвоюємо минулому
        } else {
            head = item.next;                       // Видаляємо перший елемент, тепер першим буде наступний після нього
        }

        if (item.next != null) {                    // Якщо існує посилання на наступний
            item.next.prev = item.prev;             // Посилання на минуле наступного буде вести на посилання prev з видаленого
        } else {
            tail = item.prev;                       // Наступних ні, останнім буде prev з видаленого
        }

        this.size--;                                // Розмір став на 1 менше
        return true;
    }


    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.size; i++) {
            Node<E> item = getIndexItem(i);
            sb.append(item.data);
            if (i < this.size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* Private Methods */

    private void checkIndex(int index) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(); // Якщо індекс менше 0 або розмір більше або дорівнює size
        }
    }

    private Node<E> getIndexItem(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
