import java.util.HashMap;
import java.util.Map;

public class minWindow76 {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> sHashMap = new HashMap<>();
        Map<Character, Integer> tHashMap = new HashMap<>();


        char[] tArray = t.toCharArray();
        for(char c : tArray) {
            tHashMap.put(c, tHashMap.getOrDefault(c, 0)+1);
        }

        int left = 0, right = 0, size = 0;
        int minLength = s.length();
        StringBuffer sb = new StringBuffer();
        while(right < s.length()) {
            char c = s.charAt(right);
            // 左闭右开
            right += 1;
            if (tHashMap.containsKey(c)) {
                sHashMap.put(c, sHashMap.getOrDefault(c, 0)+1);
                if (sHashMap.get(c).equals(tHashMap.get(c))) {
                    size += 1;
                }
            }
            // 窗口准备收缩
            while(size == tHashMap.size()) {
                if (right-left <= minLength) {
                    minLength = right - left;
                    sb = new StringBuffer(s.substring(left, right+1));
                }
                c = s.charAt(left);
                if (sHashMap.containsKey(c)) {
                    if (sHashMap.get(c).equals(tHashMap.get(c))) {
                        size -= 1;
                    }
                    sHashMap.put(c, sHashMap.get(c)-1);
                }
                left += 1;
            }
        }
        return sb.toString();
    }
}
