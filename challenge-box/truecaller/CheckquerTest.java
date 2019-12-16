package challenges.truecaller;

public class CheckquerTest {
    public static void main(String[] args) {
        int tot = 0;

        // create a 10 * 10 chess board
        ChequerBoard board = new ChequerBoard(10);


        Cell src = new Cell(0, 0);
        tot += board.findPaths(src);

        Cell[] carr = board.getCarr();

        System.out.println(tot);
        for (int k=0; k<100; k++) {
            System.out.printf(" for [%d, %d] =>", carr[k].x, carr[k].y);
            System.out.println(carr[k].path);
        }
    }
}
