// fanghong_triangle.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

int main(int argc, char* argv[])
{
    int a = 0;
	int b = 0;
	int c = 0;
    int max = 0;
    int res = 0;  //1表示是全等三角形
   //3 3 3\是; 5 4 3\不是; -1 -1 -1\不是；1 2 8\不是 
    setbuf(stdout,NULL);
	printf("请输入3个整数：\n");
    scanf("%d %d %d",&a,&b,&c);

	if(a>0 && b>0 && c>0 && a+b>c && a+c>b && b+c>a){
		if(a==b && b==c){
		  res = 1;
		}
	}

	if(res){
     printf("是");
	}else{
     printf("不是");
	}
	
	
	
	printf("Hello World!\n");
	return 0;
}

