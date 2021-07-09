#include<stdio.h>
#include<stdlib.h>
#define Queue_size 10
typedef struct BiTNode{
	char data;
	bool marks=false;
	struct BiTNode *lchild;
	struct BiTNode *rchild;
}BiTNode,*BiTree; 

void CreateTree(BiTree &T){
	char content;
	scanf("%c",&content);
	if(content == '#')
		T = NULL;
	else{
		T = (BiTNode*)malloc(sizeof(BiTNode));
		T->data = content;
		CreateTree(T->lchild);
		CreateTree(T->rchild);
	}
}
struct stack{
	BiTNode* base;
	BiTNode* top;
	int size;
};
void initStack(stack &s){
    s.base=(BiTNode*)malloc(30*sizeof(BiTNode));
    s.top=s.base;
    s.size=30;
}
void push(stack &s,BiTree e){
	if(s.top-s.base>=s.size){
		s.base=(BiTNode*)realloc(s.base,(s.size+10)*sizeof(BiTNode));
		s.top=s.base+10;
	    s.size+=10;
	}
    *s.top++=*e;
}
BiTree  pop(stack &s){
    if(s.base==s.top){
    	printf("ջ��"); 
		exit (0);}		
    return --s.top;
}
BiTree peek(stack &s){
    if(s.base==s.top){
    	printf("ջ��"); 
		exit (0);}		
	return s.top;
}

bool isEmpty(stack &s){
	if(s.base==s.top) return true;	
	else return false;
}
//�ǵݹ�ʵ��
void NPutTree(BiTree T){
	stack s;
	initStack(s);
	char target;
	scanf("%c",&target);  
	if(T==NULL) return;
	BiTree p=T;
	BiTree pre=NULL;
	 while(p!=pre||(!isEmpty(s))){
            if(p!=pre){
             push(s,p);//�Ѹ��ڵ����ջ��
             printf("%c",p->data);
             if(p->data==target){
             	break;
			 }
             p=p->rchild;//�����������������
            }
            else{
               	BiTree tem=pop(s);
                p=tem->lchild;//������������������
            }
        }
       
        /*while(!isEmpty(res)){
        	printf("%c",pop(res)->data);
		}*/
     } 

	/*while(!isEmpty(s)){
		while(p!=NULL){
			p=p->lchild;
		}
		while(peek(s)->rchild==NULL||peek(s)->marks){
			printf("%c",pop(s)->data);
		}
		peek(s)->marks=true;
		p=p->rchild;
	}*/ 
	

//�ݹ�ʵ�ֺ��������������֤�� 
void PutTree(BiTree T){
	if(T->lchild!=NULL){
		PutTree(T->lchild);
	}
	if(T->rchild!=NULL){
		PutTree(T->rchild);
	}
	printf("%c",T->data);
}
bool TreeEmpty(BiTree T)
{
	if(T == NULL)
		return true;
	else 
		return false;
}
int main(){
	BiTree t;
	printf("�����������սڵ�Ϊ#\n"); 
	CreateTree(t);
	printf("�����յ㣬�����·��\n");	 	
	NPutTree(t);
	
	
}
