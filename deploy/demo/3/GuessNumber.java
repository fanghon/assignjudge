import java.util.Scanner;
import java.util.Random;
public class GuessNumber {
public int moshi = 8;

  static int getInput(){
    Scanner in = new Scanner(System.in);
    int i = -1;
    try{
      i = in.nextInt();
    }catch(Exception e){
     System.out.println(e);
    }
    System.out.println("num:"+i);
    return i;
  }

  void caiDan(){
    System.out.println("1 ��ʼ����");
    System.out.println("2 ��������");
    System.out.println("3 �˳�");
  }

   void canShu(){
    while(1==1){
      System.out.println("��ѡ���Ѷ�");
      System.out.println("1.�� 2.һ�� 3.����");
      int sel = getInput();
      if (sel==1){
        moshi = 4;
        break;
      }else if(sel == 2){
         moshi = 6;
         break;
       }else if(sel == 3){
          moshi = 8;
          break;
        }else{
           System.out.println("������������������");
         }     
    }
  }

  void yunXing(){
    int suijishu = 1+(int)(Math.random()*100);
    System.out.println(suijishu);
    int times = 1;
    while(times <= moshi){
      System.out.println("��������²������1--100��������");
      int caice = getInput();
      if(caice>100||caice<1){
         System.out.println("������Χ");
      }
      else{
        if(caice == suijishu){
          break;
        } else if(caice < suijishu){
          System.out.println("С��");
        } else{
          System.out.println("����");
        }
        times++;
      }
    }
    if (times > moshi){
      System.out.println("��������������Ŭ��");
    }
    else{
      System.out.println("��ϲ��¶��ˣ����ս��Ϊ:"+(1 - times/8F)*100+'%');
    }
  }

public static void main(String[] args){
  GuessNumber caizi = new GuessNumber();
  while(1==1){  
    caizi.caiDan();  
    System.out.println("��ѡ��");
    int sel = getInput();
    switch(sel){
    case 1:caizi.yunXing();break;
    case 2:caizi.canShu();
           System.out.println("�������");
           break;
    case 3:System.out.println("Bye bye!");
           System.exit(0);
    default:System.out.println("��������");
    }
  }
  }
}