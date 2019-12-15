package das;

public class TryCatchFinally {

    public int show(){
        try{
            int d = 10/0;
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }
    public static void main(String[] args) {
        TryCatchFinally tcf = new TryCatchFinally();
        System.out.println(tcf.show());
    }
}
