import java.util.HashMap;

public class checkInclusion567 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1HashMap = new HashMap<>();
        HashMap<Character, Integer> s2HashMap = new HashMap<>();

        char[] s1Array = s1.toCharArray();
        for(char c : s1Array) {
            s1HashMap.put(c, s1HashMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, size = 0;
        while(right < s2.length()) {
            char c = s2.charAt(right);
            right += 1;
            if (s1HashMap.containsKey(c)) {
                s2HashMap.put(c, s2HashMap.getOrDefault(c, 0)+1);
                if(s2HashMap.get(c).equals(s1HashMap.get(c))) {
                    size += 1;
                }
            }
            while (size == s1HashMap.size()) {
                if (right-left == s1.length()){
                    return true;
                }
                c = s2.charAt(left);
                if (s2HashMap.containsKey(c)) {
                    if (s2HashMap.get(c).equals(s1HashMap.get(c))) {
                        size -= 1;
                    }
                    s2HashMap.put(c, s2HashMap.get(c) - 1);
                }
                left++;
            }
        }// while
        return false;
    }// checkInclusion
}
