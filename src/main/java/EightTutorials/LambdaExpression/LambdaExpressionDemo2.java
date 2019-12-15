package EightTutorials.LambdaExpression;

interface Operation{
    void add(int a, int b);
    void subtract(int a, int b);
    void multiply(int a, int b);
    void divide(int a, int b);
}

class OperationImpl implements Operation{

    @Override
    public void add(int a, int b) {
      System.out.println(a+b);
    }

    @Override
    public void subtract(int a, int b) {
        System.out.println(a-b);
    }

    @Override
    public void multiply(int a, int b) {
        System.out.println(a*b);
    }

    @Override
    public void divide(int a, int b) {
        System.out.println(a/b);
    }
}

public class LambdaExpressionDemo2 {

    public static void main(String[] args) {

        Operation op = new OperationImpl();
        op.add(12, 5);
        op.subtract(10, 5);
        op.multiply(12, 5);
        op.divide(10, 5);

        Operation op_1 = new Operation() {
            @Override
            public void add(int a, int b) {
                System.out.println(a+b);
            }

            @Override
            public void subtract(int a, int b) {
                System.out.println(a-b);
            }

            @Override
            public void multiply(int a, int b) {
                System.out.println(a*b);
            }

            @Override
            public void divide(int a, int b) {
                System.out.println(a/b);
            }
        };

        op_1.add(12, 5);
        op_1.subtract(10, 5);
        op_1.multiply(12, 5);
        op_1.divide(10, 5);

    }
}
