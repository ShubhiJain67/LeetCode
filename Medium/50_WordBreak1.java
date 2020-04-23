import java.util.*;
class WordBreak{
    public static void main(String[] args) {
        String[] words={"like", "samsung", "i", "ilike", "sam", "sung", "and", "man", "go", "mango"};
        String word = "ilikesamsungandmango";

        for (String w : words)
            map.add(w);

        int ans=wordBreak_(word, "");
        System.out.println(ans);
    }
    static HashSet<String> map=new HashSet<>();
    public static int wordBreak_(String str, String ans)
    {
        if (str.length() == 0)
        {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= str.length(); i++)
        {
            String smallstr = str.substring(0, i);
            if (map.conatins(smallstr)==true)
            {
                count += wordBreak_(str.substr(i), ans + smallstr + " ");
            }
        }

        return count;
    }
}