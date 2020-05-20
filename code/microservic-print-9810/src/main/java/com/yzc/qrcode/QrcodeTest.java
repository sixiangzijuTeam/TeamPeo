package com.yzc.qrcode;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrcodeTest {
private static final String QR_CODE_IMAGE_PATH = "/Users/gisboy/Desktop/MyQRCode.png";
	
	public static void generateQRCodeImage(String text, int width, int height, String filePath)  {
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			@SuppressWarnings("unchecked")
			Hashtable<EncodeHintType, Object> hints = new Hashtable();
		    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			BitMatrix bitMatrix;
	
			bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height,hints);

			Path path = FileSystems.getDefault().getPath(filePath);
			
			MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		File file=new File("a.png");
		System.out.println(file.getAbsolutePath() +"---"+file.getCanonicalPath());
            generateQRCodeImage("This is my first测试", 100, 100, file.getAbsolutePath());
		if(file.exists()) {
			System.out.println("hjkl;");
//			file.delete();
		}
	}

}
