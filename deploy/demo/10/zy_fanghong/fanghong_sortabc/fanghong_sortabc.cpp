// fanghong_sortabc.cpp : Defines the entry point for the console application.
//2014.3.18 �����̶���3���ַ��������asc��ֵ�������м���Ǹ��ַ�

#include "stdafx.h"

int main(int argc, char* argv[])
{
	char cha = 0;;
	char chb = 0;
	char chc = 0;
    char mid = 0;
    //a b c\b; A b C\C;b c Z\b ;a c b\b
	setbuf(stdout,NULL);
	printf("����������ͬ�ַ���\n");
    scanf("%c %c %c",&cha,&chb,&chc);

	if(cha<chb){ //a b �еĴ�ֵ����a ��mid��
       mid = chb;
	}
    if(mid>chc){ //b���,ȡa��c�еĴ�ֵ
      mid = cha>chc?cha:chc;      
	}else if(cha>chc){ //a ���ȡ b c�еĴ�ֵ
		mid = chb>chc?chb:chc;
	}else {   //c ��� 
		mid = cha>chb?cha:chb;
	}
    printf("%c\n",mid);

	return 0;
}

