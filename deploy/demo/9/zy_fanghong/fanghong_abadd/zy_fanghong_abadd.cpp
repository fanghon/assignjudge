// zy_fanghong_abadd.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a = 0;
	int b = 1;

  setbuf(stdout,NULL);
	printf("请输入整数a b \n");
//	fflush(stdout);
	scanf("%d %d",&a,&b);
 

	long res = a+b;

	printf("结果：%d",res);
  //fflush(stdout);
  
  
  
	return 0;
}

