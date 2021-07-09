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
    	printf("栈空"); 
		exit (0);}		
    return --s.top;
}
BiTree peek(stack &s){
    if(s.base==s.top){
    	printf("栈空"); 
		exit (0);}		
	return s.top;
}

bool isEmpty(stack &s){
	if(s.base==s.top) return true;	
	else return false;
}
//非递归实现
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
             push(s,p);//把根节点放入栈中
             printf("%c",p->data);
             if(p->data==target){
             	break;
			 }
             p=p->rchild;//步骤二，遍历右子树
            }
            else{
               	BiTree tem=pop(s);
                p=tem->lchild;//步骤三，遍历左子树
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
	

//递归实现后序遍历，用于验证答案 
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
	printf("请输入树，空节点为#\n"); 
	CreateTree(t);
	printf("输入终点，将输出路径\n");	 	
	NPutTree(t);
	
	
}
