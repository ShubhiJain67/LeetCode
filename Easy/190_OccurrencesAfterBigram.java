class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> sb = new ArrayList<>();
		//fs and sec is used to judge whether first/second is appeared already
        boolean fs = false, sec = false;
        for(String s : text.split(" "))
        {
            if(sec && fs) 
            {
                fs = false;
                sec = false;
                sb.add(s);
            }
            if(s.equals(first) ) 
            {
                fs = true;
            }
            else if(s.equals(second) && fs && !sec) 
            {
                sec = true;
            }
            else
            {
                fs = false;
                sec = false;
            }
        }
        return sb.toArray(new String[sb.size()]);
    }
}