#include <stdio.h> 
#include <stdlib.h>
#include <iostream> 
using namespace std;
typedef char ElemType;
//���Ľ�� 
typedef  struct BiTNode
{
    ElemType data;
    struct BiTNode *lchild, *rchild;
}BiTNode;
//���ĳ�ʼ�� 
void CreateBiTree(BiTNode **T)
{
    ElemType ch;
    cin >> ch;
    if (ch == '#')
        *T = NULL;  //��֤��Ҷ���
    else
    {
        *T = (BiTNode*)malloc(sizeof(BiTNode));
        (*T)->data = ch;//���ɽ��
        CreateBiTree(&(*T)->lchild);//����������s
        CreateBiTree(&(*T)->rchild);//����������    
    }
}
//ǰ�����������
int PutTreeF(BiTNode **T){
	if(*T==NULL) printf("#");	
	if(!*T==NULL){
	printf("%c",(*T)->data); 
	PutTreeF(&(*T)->lchild);
	PutTreeF(&(*T)->rchild);}
	return 1;
} 
//���нڵ�
struct QNode{
	BiTNode elem;
	QNode* next;
}; 
//���нṹ��
struct Queue{
	QNode* front;
	QNode* finnal;
}; 
//��ʼ������
void initQueue(Queue &q){
	q.front=(QNode*)malloc(100*sizeof(QNode));
	q.finnal=q.front;	
}
//����β���Ԫ��
void push(Queue &q,BiTNode b){
	QNode temp;
	temp.elem=b;
    *q.finnal++=temp;
}
//��������Ԫ�� 
BiTNode pop(Queue &q){
	if(q.finnal==q.front) exit(0);
	QNode temp;
	temp=*q.front++;
}
//�ж��Ƿ�Ϊ��
bool isEmpty(Queue &q){
	if(q.finnal==q.front){
		return true;
	}
	else return false;
} 
//�������
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

