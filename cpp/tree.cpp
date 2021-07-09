#include <stdio.h> 
#include <stdlib.h>
#include <iostream> 
using namespace std;
typedef char ElemType;
//树的结点 
typedef  struct BiTNode
{
    ElemType data;
    struct BiTNode *lchild, *rchild;
}BiTNode;
//树的初始化 
void CreateBiTree(BiTNode **T)
{
    ElemType ch;
    cin >> ch;
    if (ch == '#')
        *T = NULL;  //保证是叶结点
    else
    {
        *T = (BiTNode*)malloc(sizeof(BiTNode));
        (*T)->data = ch;//生成结点
        CreateBiTree(&(*T)->lchild);//构造左子树s
        CreateBiTree(&(*T)->rchild);//构造右子树    
    }
}
//前序遍历二叉树
int PutTreeF(BiTNode **T){
	if(*T==NULL) printf("#");	
	if(!*T==NULL){
	printf("%c",(*T)->data); 
	PutTreeF(&(*T)->lchild);
	PutTreeF(&(*T)->rchild);}
	return 1;
} 
//队列节点
struct QNode{
	BiTNode elem;
	QNode* next;
}; 
//队列结构体
struct Queue{
	QNode* front;
	QNode* finnal;
}; 
//初始化队列
void initQueue(Queue &q){
	q.front=(QNode*)malloc(100*sizeof(QNode));
	q.finnal=q.front;	
}
//往队尾添加元素
void push(Queue &q,BiTNode b){
	QNode temp;
	temp.elem=b;
    *q.finnal++=temp;
}
//弹出队首元素 
BiTNode pop(Queue &q){
	if(q.finnal==q.front) exit(0);
	QNode temp;
	temp=*q.front++;
}
//判断是否为空
bool isEmpty(Queue &q){
	if(q.finnal==q.front){
		return true;
	}
	else return false;
} 
//层序遍历
void PutTreeC(BiTNode *t){
	Queue q;
	initQueue(q);
	push(q,*t);
	while(!isEmpty(q)){
		BiTNode temp;
		temp=pop(q);
		printf("%c",temp.data);
		if(!temp.lchild==NULL){
			push(q,*temp.lchild);
				printf("left");
		}///else printf("#");
		if(!temp.rchild==NULL){
			push(q,*temp.rchild);
				printf("right");
		}
	}
	    
} 
int main(){
	BiTNode *t;
	CreateBiTree(&t);
	PutTreeF(&t);
	printf("\n");
	PutTreeC(t);
}

