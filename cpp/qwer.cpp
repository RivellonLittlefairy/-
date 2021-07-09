#include<stdio.h>
#include <stdlib.h>
typedef struct BiTNode {
	char data;
	int depth;
	struct BiTNode* lchild;
	struct BiTNode* rchild;
}BiTNode, * BiTree;

void CreateTree(BiTree& T,int dep) {
	char content;
	scanf("%c", &content);
	if (content == '#')
		T = NULL;
	else {
		T = (BiTNode*)malloc(sizeof(BiTNode));
		T->data = content;
		
		T->depth=dep;
		CreateTree(T->lchild,dep+1);
		CreateTree(T->rchild,dep+1);
	}
} 


bool TreeEmpty(BiTree T)
{
	if (T == NULL)
		return true;
	else
		return false;
}

struct stack{
	struct BiTNode* base;
	struct BiTNode* top;
	int size;
};
void initStack(stack &s){
    s.base=(BiTNode*)malloc(10*sizeof(BiTNode*));
    s.top=s.base;
    s.size=10;
}
void push(stack &s,BiTNode e){
	if(s.top-s.base>=s.size){
		s.base=(BiTNode*)realloc(s.base,(s.size+10)*sizeof(BiTNode));
		s.top=s.base+10;
	    s.size+=10;
	}
    *s.top++=e;
}
BiTNode* pop(stack &s){
    if(s.base==s.top){ 
    	printf("Õ»¿Õ"); 
		exit (0);}
	return --s.top;

}
bool isEmpty(stack &s){
	if(s.base==s.top) return true;	
	else return false;
}
void putNode(BiTNode *t){
	for(int i=0;i<t->depth;i++){
		printf(" ");
	}
	printf("%c\n",t->data);
}
void putTree(BiTNode *t){
	/*stack s;
	initStack(s);
	if(t==NULL){
		printf("");
		exit(0);
	}
	while(t!=NULL||isEmpty(s)){
		while(t!=NULL){
			push(s,*t);
			t=t->lchild;
		}
	    pop(s,*t);
	    putNode(t);
	    t=t->rchild;
	} */
	if(t->rchild!=NULL) putTree(t->rchild);
	putNode(t);
	if(t->lchild!=NULL) putTree(t->lchild);
	
}
void putTree2(BiTNode *t){
	stack s;
	initStack(s);
	if(t==NULL){
		printf("");
		exit(0);
	}
	while(t!=NULL||!isEmpty(s)){
		while(t!=NULL){
			push(s,*t);
			t=t->lchild;
		}
	    t=pop(s);
	    putNode(t);
	    t=t->rchild;
	} 
}


int main(){
	BiTree t;
	CreateTree(t,0);      
	putTree(t); 
	putTree2(t); 

           

	
}
