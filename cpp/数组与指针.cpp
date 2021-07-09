#include <iostream>
using namespace std;
void helper(int num[],int* p){
	cout<< "数组大小" << sizeof(num)  <<endl;
	cout<< "指针大小" << sizeof(p)  <<endl;
} 
int main(){
	int a[5]={1,2,3,4,5};
	int* p=a;
	cout<< "数组地址" << &a  <<endl;
	cout<< "指针变量" << p[2]  <<endl;
	cout<< "指针地址" << &p  <<endl;
	cout<< "数组大小" << sizeof(a)  <<endl;
	cout<< "指针大小" << sizeof(p)  <<endl;
	cout<< "指针指向" <<  *++p <<endl;
	helper(a,p); 

} 
