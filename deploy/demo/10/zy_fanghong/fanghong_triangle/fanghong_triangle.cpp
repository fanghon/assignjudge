// fanghong_triangle.cpp : Defines the entry point for the console application.
//2014.3.18 ����3��������ʾ3���ߣ��ж��Ƿ���ֱ��������

#include "stdafx.h"

int main(int argc, char* argv[])
{
    int a = 0;
	int b = 0;
	int c = 0;
    int max = 0;
    int res = 0;  //1��ʾ��ֱ��������
   //3 4 5\��; 5 4 3\��; 6 3 4\���ǣ�-3 4 5\���� 
    setbuf(stdout,NULL);
	printf("����3��������\n");
    scanf("%d %d %d",&a,&b,&c);

	if(a>0 && b>0 && c>0 && a+b>c && a+c>b && b+c>a){
		max = a>b?a:b;
		max = max>c?max:c;
		if(max==a && max*max==b*b+c*c){ //������a�������㹴�ɶ���
          res = 1;
		}else if(max==b && max*max==a*a+c*c){
          res = 1;
		}else if(max==c && max*max==a*a+b*b){
          res = 1;
		}    
	}

	if(res){
     printf("��");
	}else{
     printf("����");
	}

	return 0;
}

