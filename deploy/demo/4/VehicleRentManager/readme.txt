2013.10.24
1 如何导入eclipse项目？
   前提条件：eclipse 项目\eclipse
  File->import->General->existing project to workspace
     选择项目所在文件夹

2 如何导出java可执行jar包？
  1 File->export->Java->Runnable jar
  2 确认Lanch Configuration ，哪个类是主入口类；
           给定jar输出的位置
           其他项默认
           
  3 运行jar包文件
    命令行命令：
      切换到jar包所在路径
      java  -jar  xx.jar
     ( java yy   //yy是类名)
     
  4 使用批处理命令执行
    a 文本编辑器编写文件，内容如下：
        java  -jar xx.jar
       保存文件时，命名为“run.bat”
    b 资源管理器，点击run.bat
    
   项目问题：
   1 车辆信息的初始化
   2 退租过程实现
   3 出租时间的计算
   