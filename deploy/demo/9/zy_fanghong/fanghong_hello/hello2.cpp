// hello2.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdlib.h>


void crash(){
  int i = 1;
  int j = 0;
  i/=j;	
  printf("div %d",i);
	
}

int main(int argc, char* argv[])
{
	int a = 0;
	int b = 0;
	int arr[] = {1,2};
	
	printf("Hello World 1!\n");
	fflush(stdout);
	//��ѭ������
	// while(1); 
	//�ݹ���ò���
/*	while(1){
		 main(argc,argv);
	} */
	//���޷����ڴ����
/*	while(1){
	  malloc(1024*1024);
	  printf("Hello World!\n");
	}*/
	//system���ò���
	if(1){
	  system("dir");
	}
	//����Խ���ȡ���Ż�����󣬲��ᵯ���Ի���
	arr[2] = 3;
	
//	crash();
	
	
	return 0;
}
