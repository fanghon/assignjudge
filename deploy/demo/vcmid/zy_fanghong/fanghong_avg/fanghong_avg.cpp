// fanghong_avg.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

int main(int argc, char* argv[])
{
	int n = 0;
	int sum = 0;
	setbuf(stdout,NULL);
	printf("«Î ‰»În£∫\n");
	scanf("%d",&n);
	for(int i=1;i<=n;i++){
       sum = sum+i;
	}
	float avg = 0;
	if(n>0){
    	avg = sum*1.0f/n;
	}
    printf("%f",avg);


	return 0;
}

