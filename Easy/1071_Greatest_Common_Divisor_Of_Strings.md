## Python
```
import math

class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        if str1 + str2 != str2 + str1:
            return ""
        gcd_len = math.gcd(len(str1), len(str2))
        return str1[:gcd_len]

```

## GoLang
```
func gcdOfStrings(str1 string, str2 string) string {
    if str1+str2 != str2+str1 {
        return ""
    }
    gcdLen := gcd(len(str1), len(str2))
    return str1[:gcdLen]
}

func gcd(a, b int) int {
    if b == 0 {
        return a
    }
    return gcd(b, a%b)
}
```


## Java 
```
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```


## C++
```
class Solution {
public:
    string gcdOfStrings(string str1, string str2) {
        if (str1 + str2 != str2 + str1) return "";
        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substr(0, gcdLen);
    }

private:
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
};
```
