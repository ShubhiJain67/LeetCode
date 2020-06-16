class Solution {
    public String validIPAddress(String IP) {
        if(IP == null) return "Neither";
        String [] v4a = IP.split("\\.",-1);
        String [] v6a = IP.split("\\:",-1);
        if(v4a.length > 1 && v6a.length > 1)
            return "Neither";
        
        if(v6a.length > 1)
           return validateIPv6(v6a) ? "IPv6" : "Neither";
        else if(v4a.length > 1)
            return validateIPv4(v4a) ? "IPv4" : "Neither";
    return "Neither";
    }
    private boolean validateIPv4(String[]ip){
        if(ip.length != 4) return false;
        for(String s:ip){ 
            if(!s.matches("[0-9]+") || s.length()>1  && s.charAt(0) == '0') return false;
            if(s.length()>3 || Integer.parseInt(s) > 255 || Integer.parseInt(s)<0) return false;
        }
        return true;
    }
    private boolean validateIPv6(String[]ip){
        if(ip.length != 8) return false;
        for(String s:ip){
            if(s.isEmpty() || s.length() > 4) return false;
            for(char c:s.toCharArray()){
                if(Character.isDigit(c)) continue;
                if(!((c >= 'a' && c<= 'f') || (c >= 'A' && c<= 'F'))) return false;
            }
        }
       return true; 
    }
    
}