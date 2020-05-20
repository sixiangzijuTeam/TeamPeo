package com.yzc.print;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;

import com.yzc.qrcode.QrcodeTest;
import com.yzc.qrcode.QrcodeTest2;

public class PrintTest2 implements Printable{   
	
	private String  MyName="你是大黄寺大街发了啥快递就发了跨境电商是打飞机跨世纪的进口量";
	
	public User  user=new User();
   /** 
 
   * @param Graphic指明打印的图形环境 
 
   * @param PageFormat指明打印页格式（页面大小以点为计量单位，1点为1英才的1/72，1英寸为25.4毫米。A4纸大致为595×842点） 
 
   * @param pageIndex指明页号 
 
   **/  
  
   public int print(Graphics gra, PageFormat pf, int pageIndex) throws PrinterException {  
       
       System.out.println("pageIndex="+pageIndex);   
      String str = "K001";  
      Graphics2D g2 = (Graphics2D) gra;  
      //设置打印颜色为黑色  
      g2.setColor(Color.black);  
      //打印起点坐标  
      double x = pf.getImageableX();  
      double y = pf.getImageableY();  
      user.setName("你好啊");
      switch(pageIndex){  
	      case 0:  
	    	  System.out.println("xu");
	           Font font2 = new Font("新宋体", Font.BOLD, 10);  
	           g2.setFont(font2);//设置字体  
	           float[] dash2 = {2.0f};   
	           //设置打印线的属性。   
	           //1.线宽 2、3、不知道，4、空白的宽度，5、虚线的宽度，6、偏移量  
	           g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dash2, 0.0f));    
	           //g2.setStroke(bs_3);//设置线宽 
	           float heigth2 = font2.getSize2D();//字体高度   
	           System.out.println("x="+x);  
	           // -1- 用Graphics2D直接输出   
	           //首字符的基线(右下部)位于用户空间中的 (x, y) 位置处   
	           //g2.drawLine(10,10,200,300);   
	           String filename="K002"+".png";
				File file =new File(filename);
				QrcodeTest.generateQRCodeImage(filename, 100, 100, file.getAbsolutePath());
				Image image;
				try {
					image = ImageIO.read(file);
					//g2.drawImage(image, 10, 10, null);
					g2.drawImage(image, 10, 5, 60, 60, null);
					g2.drawString("姓名:JKLKJ", 70, 20);
					g2.drawString("性别:男", 70, 40);
					g2.drawString("筛选号: K001 年龄: 20", 20, 70);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if(file.exists()) {
						file.delete();
					}
				}
				System.out.println("图片");
		           
//	           g2.drawString("开始答应", (float)x+10, (float)y+1*heigth2);  
//	           g2.drawString(MyName, (float)x+10, (float)y+1*heigth2+20);  
	           return PAGE_EXISTS;  
	      case 2:  
	    	  System.out.println("bu");
	           Font font = new Font("新宋体", Font.PLAIN, 12);  
	           g2.setFont(font);//设置字体  
	           float[] dash = {2.0f};   
	           //设置打印线的属性。   
	           //1.线宽 2、3、不知道，4、空白的宽度，5、虚线的宽度，6、偏移量  
	           g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dash, 0.0f));    
	           //g2.setStroke(bs_3);//设置线宽 
	           float heigth = font.getSize2D();//字体高度   
	           System.out.println("x="+x);  
	           // -1- 用Graphics2D直接输出   
	           //首字符的基线(右下部)位于用户空间中的 (x, y) 位置处   
	           //g2.drawLine(10,10,200,300);   
		        g2.drawString("第二章sdfsdf", 10, 10);   
//	           g2.drawString("开始答应", (float)x+10, (float)y+1*heigth2);  
//	           g2.drawString(MyName, (float)x+10, (float)y+1*heigth2+20);  
	           return PAGE_EXISTS;  
         default:  
  
        	 return PAGE_EXISTS;  
//        	 return NO_SUCH_PAGE;
  
      }  
         
   }  
    
public static void main(String[] args) {  
         
    //    通俗理解就是书、文档   
    Book book = new Book();  
    //    设置成竖打   
    PageFormat pf = new PageFormat();    
    pf.setOrientation(PageFormat.PORTRAIT);  
    //    通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。  
    Paper p = new Paper();  
    p.setSize(140,90);//纸张大小   
    p.setImageableArea(10,10, 140,90);//A4(595 X 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72  
    pf.setPaper(p);  
    //    把 PageFormat 和 Printable 添加到书中，组成一个页面    
//    book.append(new PrintTest(), pf,1);
    PrintTest2 printTest = new PrintTest2();
    book.append(printTest, pf,1);
//    book.append(printTest, pf,2);
   // book.append(new PrintTest(), pf);
     //获取打印服务对象  
     PrinterJob job = PrinterJob.getPrinterJob();   
     
     // 设置打印类   
     job.setPageable(book);  
     
     HashAttributeSet hs = new HashAttributeSet();
     
     String printerName="ZDesigner GK888t (EPL)";
  
     hs.add(new PrinterName(printerName,null));
  
     PrintService[] pss = PrintServiceLookup.lookupPrintServices(null, hs);
  
     if(pss.length==0){
       System.out.println("无法找到打印机:"+printerName);
       return ;
     }
    

         
     try {  
         //可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印  
    	 job.setPrintService(pss[0]);
    	 job.print();   
//         boolean a=job.printDialog();    
//         if(a)
//         {            
//             job.print();   
//         }else{
//             job.cancel();
//         }
     } catch (PrinterException e) {  
         e.printStackTrace();  
     }  
  
   }


  
}
