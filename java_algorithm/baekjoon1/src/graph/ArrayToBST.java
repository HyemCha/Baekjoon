package graph;

class Tree1{
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    //트리가 시작하는 루트노드 저장
    Node root;
    //배열 정보를 받아서 트리를 만드는 일을 시작해주는 함수
    public void makeTree(int[] a){
        //재귀호출을 반복적으로 실행하기에 앞서서
        //재귀호출에 필요한 데이터를 처음으로 던져주는 일을 함
        //재귀호출이 끝나면 가장 꼭대기에 있는 루트노드를 받아 멤버 변수에 저장
        root = makeTreeR(a, 0, a.length - 1);
        //배열, 시작 인덱스, 배열의 마지막 인덱스 전달
    }
    //재귀함수
    public Node makeTreeR(int[] a, int start, int end){
        //인자로 배열정보, 시작인덱스, 끝인덱스
        if(start > end) return null;
        int mid = (start + end) / 2;
        //중간지점으로 노드 생성
        Node node = new Node(a[mid]);
        node.left = makeTreeR(a, start, mid - 1);
        node.right = makeTreeR(a, mid + 1, end);
        return node;
    }
    //트리가 잘 만들어졌는지 이진 검색을 해서 확인하는 함수
    public void seartchBTree(Node n, int find){
        //검색을 할 시작 노드와 찾을 데이터를 함수의 인자로 받음

        //찾아야 할 갑이 현재 데이터보다 작은 경우
        if(find < n.data){
            System.out.println("Data is samller than " + n.data);
            //찾는 값이 현재 노드보다 작으므로 왼쪽 노드 주소와 찾는 값으로 재귀함수 호출
            seartchBTree(n.left, find);
        } //찾는 값이 받은 노드의 데이터보다 큰지 비교
        else if (find > n.data) {
            System.out.println("Data is bigger than " + n.data);
            //찾는 값이 현재 노드보다 크로 오른쪽 서브 트리의 루트 주소를 넘김
            seartchBTree(n.right, find);
        }//데이터가 크지도 작지도 않을 때
        else{
            System.out.println("Data found!");
        }
    }
}

//배열을 트리로
public class ArrayToBST {
    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i = 0; i<a.length; i++)
            a[i] = i;

        Tree1 t = new Tree1();
        //해당 배열을 트리로 만들고 멤버변수에 저장
        t.makeTree(a);
        t.seartchBTree(t.root, 2);
    }
}
