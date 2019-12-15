package das;

public class PolymorphismShow {

    public void show(Object o){
        System.out.println("object argument method called");
    }

    public void show(String s){
        System.out.println("string argument method called");
    }
    public static void main(String[] args) {
        PolymorphismShow pms = new PolymorphismShow();
        pms.show(null);
        pms.show(new Object());
    }
}
