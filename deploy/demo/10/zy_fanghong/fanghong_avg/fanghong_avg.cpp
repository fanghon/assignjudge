// fanghong_avg.cpp : Defines the entry point for the console application.
//2014.3.18,���̶��������������ۼӺͣ�����0����������ƽ��ֵ

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
	  printf("��������:\n");
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

