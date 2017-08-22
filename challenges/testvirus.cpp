#include <iostream>

using namespace std;

class BlockScan
{
   int x;

   public : 
   char *s;
   char read();
   char transform();
};

char BlockScan :: read()
{
   char str[100];
   cout<<"Enter proc name ";
   cin>>str;
   s = str;
   cout<<"Process: "<<&s<<endl;
}

int main()
{ 
   BlockScan bs1,bs2;
   
   bs1.read();
   
   cout<<"Name is "<<bs1.s<<endl;
   return 0;
}