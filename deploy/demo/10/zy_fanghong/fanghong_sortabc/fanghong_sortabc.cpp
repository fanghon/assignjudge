// fanghong_sortabc.cpp : Defines the entry point for the console application.
//2014.3.18 ，键盘读入3个字符，输出按asc码值，处于中间的那个字符

#include "stdafx.h"

int main(int argc, char* argv[])
{
	char cha = 0;;
	char chb = 0;
	char chc = 0;
    char mid = 0;
    //a b c\b; A b C\C;b c Z\b ;a c b\b
	setbuf(stdout,NULL);
	printf("输入三个不同字符：\n");
    scanf("%c %c %c",&cha,&chb,&chc);

	if(cha<chb){ //a b 中的大值放在a 或mid中
       mid = chb;
	}
    if(mid>chc){ //b最大,取a、c中的大值
      mid = cha>chc?cha:chc;      
	}else if(cha>chc){ //a 最大，取 b c中的大值
		mid = chb>chc?chb:chc;
	}else {   //c 最大 
		mid = cha>chb?cha:chb;
	}
    printf("%c\n",mid);

	return 0;
}

