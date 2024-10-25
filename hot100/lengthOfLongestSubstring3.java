
import java.util.HashMap;

public class lengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left, right, maxLength;
        left = right = maxLength = 0;
        while(right< s.length()) {
            if(!hashMap.containsKey(s.charAt(right))) {
                hashMap.put(s.charAt(right), right);
                right+=1;
                // 更新子串的长度
                int curLength = right-left;
                maxLength = Math.max(maxLength, curLength);
            }
            else {
                // 回溯
                // int curLength = right-left;
                // maxLength = Math.max(maxLength, curLength);
                
                // 这里的目的是找到那个重复的字符，剔除
                while(hashMap.containsKey(s.charAt(right))) {
                    hashMap.remove(s.charAt(left));
                    left += 1;
                }
            }
        }
        return maxLength;

    }

    public static void main(String[] args) {
        lengthOfLongestSubstring3 test = new lengthOfLongestSubstring3();
        String s = "abcabcbb";
        // String s = "ab";
        System.out.println(test.lengthOfLongestSubstring(s));
        // System.out.println("666");
    }
}
