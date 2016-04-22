public class SnaekLinkedListTester {
    public static void main(String[] args) {
        SinglyLinkedList snaek = new SnaekLinkedList();
        Position refPos = new Position(15, 10);
        for (int i = 0; i < 10; i++) {
            snaek.addFront(new Position(refPos.getX() - i, refPos.getY()));
        }

        for (Position p : snaek) {
            System.out.println(p);
        }
        System.out.println();

        System.out.println(snaek.size());
        while (!snaek.isEmpty()) {
            System.out.print(snaek.removeEnd() + ", ");
            System.out.println(snaek.size());
        }
        System.out.println();

        snaek.addEnd(new Position(4, 20));
        System.out.println(snaek.getFront());
        System.out.println(snaek.size());
        System.out.println(snaek.removeFront());
        System.out.println(snaek.size() + ", " + snaek.isEmpty());
        System.out.println(snaek.removeFront());
        System.out.println(snaek.removeEnd());
        System.out.println(snaek.size());
        System.out.println(snaek.getFront());
        System.out.println(snaek.getEnd());
    }
}