class Palindrome
{
    // Function to check if linked list is palindrome
    boolean isPalindrome(Node head) 
    {
        int num1=0;
        int num2=0;
        int num3=0;
        while(head!=null){
            num1=num1*10+head.data;
            head=head.next;
        }
        num2=num1;
        while(num1!=0){
            num3=num3*10+num1%10;
            num1=num1/10;
        }
        if(num3==num2) return true;
        return false;
    }    
}