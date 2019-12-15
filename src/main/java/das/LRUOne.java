package das;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class LRUOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give no of users -->");
        int noOfUsers = scan.nextInt();
        scan.nextLine();
        Set<String> _set = new LinkedHashSet<String>();

        System.out.println("Give Users -->");
        for(int i = 0; i < noOfUsers; i++){
            String user = scan.nextLine();
            _set.add(user);
        }

        System.out.println("Give coming user details -->");
        String inputUser = scan.nextLine();

        System.out.println("Before caching list");
        for(String str : _set){
            System.out.println(str+" ");
        }

        boolean isAvailable = false;
        if(_set.contains(inputUser)){
          for(String st : _set){
              if(st.equals(inputUser)) {
                  isAvailable = true;
              }
          }
        }

        if(isAvailable){
            _set.remove(inputUser);
            _set.add(inputUser);
        }
        scan.close();
        System.out.println("Cached list");
        for(String str : _set){
            System.out.println(str+" ");
        }
    }
}
