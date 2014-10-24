// fanghong_triangle.cpp : Defines the entry point for the console application.
//2014.3.18 输入3个整数表示3条边，判断是否是直角三角形

#include "stdafx.h"

int main(int argc, char* argv[])
{
    int a = 0;
	int b = 0;
	int c = 0;
    int max = 0;
    int res = 0;  //1表示是直角三角形
   //3 4 5\是; 5 4 3\是; 6 3 4\不是；-3 4 5\不是 
    setbuf(stdout,NULL);
	printf("输入3个整数：\n");
    scanf("%d %d %d",&a,&b,&c);

	if(a>0 && b>0 && c>0 && a+b>c && a+c>b && b+c>a){
		max = a>b?a:b;
		max = max>c?max:c;
		if(max==a && max*max==b*b+c*c){ //最大边是a，且满足勾股定理
          res = 1;
		}else if(max==b && max*max==a*a+c*c){
          res = 1;
		}else if(max==c && max*max==a*a+b*b){
          res = 1;
		}    
	}

	if(res){
     printf("是");
	}else{
     printf("不是");
	}

	return 0;
}

