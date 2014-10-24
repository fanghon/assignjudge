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
    System.out.println("1 开始猜数");
    System.out.println("2 参数设置");
    System.out.println("3 退出");
  }

   void canShu(){
    while(1==1){
      System.out.println("请选择难度");
      System.out.println("1.难 2.一般 3.容易");
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
           System.out.println("输入有误请重新输入");
         }     
    }
  }

  void yunXing(){
    int suijishu = 1+(int)(Math.random()*100);
    System.out.println(suijishu);
    int times = 1;
    while(times <= moshi){
      System.out.println("请输入你猜测的数（1--100的整数）");
      int caice = getInput();
      if(caice>100||caice<1){
         System.out.println("超出范围");
      }
      else{
        if(caice == suijishu){
          break;
        } else if(caice < suijishu){
          System.out.println("小了");
        } else{
          System.out.println("大了");
        }
        times++;
      }
    }
    if (times > moshi){
      System.out.println("超过次数，尚需努力");
    }
    else{
      System.out.println("恭喜你猜对了，你的战力为:"+(1 - times/8F)*100+'%');
    }
  }

public static void main(String[] args){
  GuessNumber caizi = new GuessNumber();
  while(1==1){  
    caizi.caiDan();  
    System.out.println("请选择");
    int sel = getInput();
    switch(sel){
    case 1:caizi.yunXing();break;
    case 2:caizi.canShu();
           System.out.println("设置完成");
           break;
    case 3:System.out.println("Bye bye!");
           System.exit(0);
    default:System.out.println("输入有误");
    }
  }
  }
}