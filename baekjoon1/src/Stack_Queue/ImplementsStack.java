package Stack_Queue;

import java.util.EmptyStackException;

class Stack<T>{
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    //멤버변수 선언. stack은 맨 위에 올라간 주소만 알고 있으면 됨
    //stack의 top 노드를 가리키는 노드
    private Node<T> top;

    //함수 구현
    //pop
    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        //맨 위의 데이터를 반환하기 전에 그 다음 주소를 top으로 만들어줘야함
        //데이터 백업하고
        T item = top.data;
        //다음 애를 top으로 만들어줌
        top = top.next;
        return item;
    }

    //push
    public void push(T item) {
        //push할 T 타입의 아이템을 하나 받아서 노드를 생성
        Node<T> t = new Node<T>(item);
        //top 앞에 받은 노드를 위치시킴
        t.next = top;
        //받은 노드가 top이 됨
        top = t;
    }

    //peek
    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        //null이 아니면 현재 top이 가리키고 있는 데이터 반환
        return top.data;
    }

    //isEmpty
    public boolean isEmpty() {
        return top == null;
    }

}

public class ImplementsStack {
    public static void main(String[] args) {
        //Integer 타입의 데이터를 넣는 stack 만들기
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
