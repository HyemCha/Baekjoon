package tree;

class Tree4{
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    Node root;
    int size;
    Tree4(int size){
        this.size = size;
        root = makeBST(0, size-1);
    }

    private Node makeBST(int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1);
        node.right = makeBST(mid + 1, end);
        return node;
    }
    //1. inorder traversal를 변형한 이진 검색 트리를 확인하는 함수
    boolean isValidateBST1(){
        //노드 개수만큼 배열방을 만듦
        int[] array = new int[size];
        //시작 노드의 주소와 순서대로 담을 배열방을 넘기면서 inorder함수 호출
        inorder(root, array);
        //inorder 함수에서 저장한 배열방을 돌면서 바로 왼쪽의 데이터가 현재 데이터보다 크면 false 반환
        for(int i =1; i<array[i-1]; i++){
            if(array[i] < array[i-1]){
                return false;
            }
        }
        return true;

    }
    int index = 0;
    void inorder(Node root, int[] array){
        //노드가 null이 아닐 때까지 반복
        if(root!=null){
            inorder(root.left, array);
            array[index] = root.data;
            index++;
            inorder(root.right, array);
        }
    }

    //2. 배열을 따로 생성하지 않고 prev라는 변수에 이전 값을 넣어 값을 비교
    //정수 객체의 주소를 넘길 수 있도록 class타입으로 선언
    Integer last_printed = null;
    boolean isValidateBST2(){
        return isValidateBST2(root);
    }
    boolean isValidateBST2(Node n){
        if(n == null) return true;
        if(!isValidateBST2(n.left)) return false;
        //이전의 값이 null이 아니고 이전의 값이 현재 값보다 크면
        if(last_printed != null && n.data < last_printed){
            return false;
        }
        //문제 없이 통과됐으면
        last_printed = n.data;
        if(!isValidateBST2(n.right)) return false;
        return true;
    }

    //3. 왼쪽으로 갈 때 맥시멈 조건을, 오른쪽으로 갈 때 미니멈 조건을 자기 노드 값으로 변경
    //다음 노드를 호출할 때 마다 조건에 맞지 않으면 바로 false 반환

    //재귀함수의 인자를 초기화해서 호출
    boolean isValidateBST3(){
        return isValidateBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean isValidateBST3(Node n, int min, int max){
        //노드가 널이면 종료
        if(n == null){
            return true;
        }
        //노드값이 최소, 최대값의 영역을 벗어나면 false를 반환
        if(n.data < min || n.data > max){
            return false;
        }
        //왼쪽으로 갈 땐 최대값을 현재 값으로 대체, 오른쪽으로 갈 땐 최소값을 현재 값으로 대체해 범위를 좁혀줌
        if(!isValidateBST3(n.left, min, n.data) || !isValidateBST3(n.right, n.data, max)){
            return false;
        }
        //모든 조건 통과하면
        return true;
    }
}
public class BSTtoArray {
    public static void main(String[] args) {
        Tree4 t = new Tree4(10);
        System.out.println("Solution 1 - using inorder: " + t.isValidateBST1());
        System.out.println("Solution 2 - without array: " + t.isValidateBST2());
        System.out.println("Solution 3 - min/max: " + t.isValidateBST3());
    }
}
