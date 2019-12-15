package das;

import java.util.*;

public class CharacterOccurence {

    public Map<Character, Integer> displayOccurence(String inputStr) {

        Map<Character, Integer> _map = new HashMap<>();
        List<Character> _ls = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            if(inputStr.charAt(i) != ' ') {
                _ls.add(inputStr.charAt(i));
            }
        }

        for (Character ch : _ls) {
            int count = 0;
            if (!_map.containsKey(ch)) {
                for (Character ch1 : _ls) {
                    if (ch == ch1) {
                        count++;
                    }
                }
                _map.put(ch, count);
            }
        }

        return _map;
    }

    public void displayFinalResult(Map<Character, Integer> map){

        for(Map.Entry<Character, Integer> mapEntry : map.entrySet()){
            Character mapKey = mapEntry.getKey();
            Integer mapValue = mapEntry.getValue();
            System.out.println(mapKey+ " occured "+mapValue+ " times");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give any string");
        String inputStr = scan.nextLine();
        CharacterOccurence co = new CharacterOccurence();
        Map<Character, Integer> resultMap = co.displayOccurence(inputStr);
        co.displayFinalResult(resultMap);
        scan.close();
    }
}
