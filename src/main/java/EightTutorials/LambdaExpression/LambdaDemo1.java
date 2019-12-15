package EightTutorials.LambdaExpression;

interface A{
    void show();
}
class Xyz implements  A{
    public void show(){
        System.out.println("Hello");
    }
}

public class LambdaDemo1 {
    public static void main(String[] args) {
        A obj = new Xyz();
        obj.show();

        A obj_1 = new A(){
            public void show(){
                System.out.println("Hello 1");
            }
        };
        obj_1.show();

        A obj_2 = () -> System.out.println("Hello 2");
        obj_2.show();

    }
}
