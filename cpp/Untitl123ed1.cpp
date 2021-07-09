#include <stdio.h>

int* sort(int *p){
	int length=sizeof(p)/sizeof(int);
	for(int i=length-2;i>=0;i--){
		for(int ii=0;ii<=i;ii++){
			if(p[ii]<p[ii+1]){
				int temp;
				p[ii]=p[ii+1];
				p[ii+1]=temp;
			}
		}
	}
	return p;
	
}
int main() {
	int i,n;
	scanf("%d",&i);
	for(int j=0;j<=i;j++){
		scanf("%d",&n);
		int num[n];
		for(int ii=0;ii<n;ii++){
		scanf("%d",&num[ii]);
	    }
	    sort(num);
	    for(int ii=0;ii<n;ii++){
		printf("%d",num[ii]);
	    }
	}
	}
