public class LinkedListImpl {
        private Node headNode;
        private int size = 0;

        public LinkedListImpl() {
                headNode = null;
        }

        public void addNode(Node node) {

                if (headNode != null) {
                        this.headNode.next = this.headNode;
                        this.headNode = node;

                } else {
                        this.headNode = node;
                        this.headNode.next = null;
                }

                this.size++;
        }

        public void display() {

                Node node = headNode;
                System.out.println(node);
                while(node.next!=null) {
                        System.out.println(node.data);
                        node = node.next;

                }
        }

        public int getCount() {
                return this.size;
        }


        static class Node {

                private int data;
                private Node next;

                public Node(int data) {
                        super();
                        this.data = data;
                        this.next = null;
                }

                public void setData(int data) {
                        this.data = data;
                }

                public void setNext(Node next) {
                        this.next = next;
                }

                public Node getNext() {
                        return this.next;
                }

                public String toString() {
                        return "Node [data=" + data + ", next=" + next + "]";
                }
        }

        public static void main(String args[]) {

                LinkedListImpl.Node node = new LinkedListImpl.Node(0);
                LinkedListImpl list = new LinkedListImpl();
                list.addNode(node);

                LinkedListImpl.Node node1 = new LinkedListImpl.Node(1);
                list.addNode(node1);

                list.display();
                System.out.println(list.size);
        }

}