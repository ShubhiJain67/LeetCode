#include stdio
using namespace  std;

int main(int argc, char const *argv[])
{
    /* code */
    printSubStr("abcd",0,"");
    return 0;
}

// with return type
vector<string> SubSeq(string str){
    if(str.length()==1){
        vector<String> res=new vec
    }
    char ch=str[0];
    vector<string> result=SubSeq(str.substring(1,str.length-1));
    for(int i=0;i<result.size();i++){
        result.pushBack(ch+result[i]);
    }
    return result;

}



// without return type
void printSubSeq(String str,int index,String subStr){
    if(index==str.length){
        cout>>subStr>>" ";
    }
    printSubStr(str,index+1,subStr);
    printSubStr(str,index+1,subStr+str[index]);


}


