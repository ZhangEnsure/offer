import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        String s = "abca";
        char[] cArray = s.toCharArray();
        for(char c : cArray) {
            hashMap.put(c, hashMap.getOrDefault(c,0 )+1);
        }
        System.err.println(hashMap.size());

    }
}
