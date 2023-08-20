package ad.example.spotifyproj;

public class Test {

    public static void main(String[] args) {
        Test1 test = new Test1() {
            @Override
            public void print() {
                System.out.println("234234");
            }
        };

        Test1 test2 = new Test1() {
            @Override
            public void print() {
                System.out.println("23423411111111111111111");
            }
        };

        test.print();
       // test2.print();
    }


}
