// fanghong_avg.cpp : Defines the entry point for the console application.
//2014.3.18,键盘读入若干整数，累加和，输入0，结束，求平均值

#include "stdafx.h"

int main(int argc, char* argv[])
{
	int sum = 0;
	int num = -1;
	int cnt = 0;
	float avg = 0;
    //6 9 \7.5;0 \0;3\3
	setbuf(stdout,NULL);
    while(num!=0){		
	  printf("输入整数:\n");
      scanf("%d",&num);
	  sum = sum + num;
	  cnt++;
	}
	if(cnt>1){
      avg = sum*1.0/--cnt;
	}
	printf("%f",avg);

	return 0;
}

