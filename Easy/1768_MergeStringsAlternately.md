## Python
```
class Solution(object):
    def mergeAlternately(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: str
        """
        result = ""
        for i in range(0, max(len(word1), len(word2))):
            if i < len(word1):
                result += word1[i] 
            if i < len(word2):
                result += word2[i]
        return result
```

## GoLang
```
func mergeAlternately(word1 string, word2 string) string {
    result := ""
    maxLen := len(word1)
    if len(word2) > maxLen {
        maxLen = len(word2)
    }

    for i := 0; i < maxLen; i++ {
        if i < len(word1) {
            result += string(word1[i])
        }
        if i < len(word2) {
            result += string(word2[i])
        }
    }

    return result
}

```


## Java 
```
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int maxLen = Math.max(word1.length(), word2.length());

        for (int i = 0; i < maxLen; i++) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }
}
```


## C++
```
class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        string result;
        int len1 = word1.length(), len2 = word2.length();
        int maxLen = max(len1, len2);

        for (int i = 0; i < maxLen; i++) {
            if (i < len1) {
                result += word1[i];
            }
            if (i < len2) {
                result += word2[i];
            }
        }

        return result;
    }
};

```
