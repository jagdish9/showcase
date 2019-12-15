package EightTutorials.FunctionalInterface;

@FunctionalInterface
interface TestAndDemo {
    void op();
    // void po();

    default void test() {
        System.out.println("--I am default method--");
    }

    @Override
    public String toString();
}

public class FunctionalInterface1 {

    public static void main(String[] args) {

        TestAndDemo testAndDemo = new TestAndDemo() {
            @Override
            public void op() {
                System.out.println("I am implemented operation");
            }

            @Override
            public String toString(){
                return "FunctionalInterface";
            }
        };

        testAndDemo.op();
        System.out.println(testAndDemo.toString());

        System.out.println("----------------------------");
        TestAndDemo testAndDemo1 = () -> System.out.println("I am the implemented " +
                "operation using lambda expression");

        testAndDemo1.op();
        testAndDemo1.test();
        testAndDemo1.toString();
    }
}
