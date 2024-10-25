
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAnagrams438 {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> s_hashmap = new HashMap<>();
        HashMap<Character, Integer> p_hashmap = new HashMap<>();

        List<Integer> res = new ArrayList<>();

        char[] p_array = p.toCharArray();
        for(char c : p_array) {
            p_hashmap.put(c, p_hashmap.getOrDefault(c, 0)+1);
        }

        int left = 0, right = 0;
        int size = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            // 左闭右开
            right += 1;
            // 记录可行解
            // 这里有一个过滤，仅记录p中的字符
            if (p_hashmap.containsKey(c)) {
                s_hashmap.put(c, s_hashmap.getOrDefault(c, 0) + 1);
                if (s_hashmap.get(c).equals(p_hashmap.get(c))) {
                    size +=1;
                }
            }
            // 如果存在可行解
            while (size == p_hashmap.size()) {
                if (right-left == p.length()) {
                    res.add(left);
                }
                // 通过收缩窗口的方式寻找解
                
                c = s.charAt(left);
                if (s_hashmap.containsKey(c)) {
                    if(s_hashmap.get(c).equals(p_hashmap.get(c))) {
                        size -= 1;
                    }
                    s_hashmap.put(c, s_hashmap.get(c)-1);
                }
                left += 1;
                
            }// while
        }// while

        return res;

    }

    public static void main(String[] args) {
        findAnagrams438 test = new findAnagrams438();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(test.findAnagrams(s, p));
    }
}
