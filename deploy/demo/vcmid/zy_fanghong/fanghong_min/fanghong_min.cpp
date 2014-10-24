// fanghong_min.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a = 0;
	int b = 0;
	int c = 0;
    setbuf(stdout,NULL);
	printf("请输入3个整数：\n");
	scanf("%d %d %d",&a,&b,&c);
    
	int min = a>b?b:a;
    min = min>c?c:min;
	printf("%d",min);

	return 0;
}

