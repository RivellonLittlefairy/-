#include <iostream>
using namespace std;
void helper(int num[],int* p){
	cout<< "�����С" << sizeof(num)  <<endl;
	cout<< "ָ���С" << sizeof(p)  <<endl;
} 
int main(){
	int a[5]={1,2,3,4,5};
	int* p=a;
	cout<< "�����ַ" << &a  <<endl;
	cout<< "ָ�����" << p[2]  <<endl;
	cout<< "ָ���ַ" << &p  <<endl;
	cout<< "�����С" << sizeof(a)  <<endl;
	cout<< "ָ���С" << sizeof(p)  <<endl;
	cout<< "ָ��ָ��" <<  *++p <<endl;
	helper(a,p); 

} 
