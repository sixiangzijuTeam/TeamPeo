package com.yzc.qrcode;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrcodeTest2 {
	 public static byte[] getQRCodeImage(String text, int width, int height)  {
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix;
	        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			try {
				bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
				  MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
			} catch (WriterException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        byte[] pngData = pngOutputStream.toByteArray(); 
	        return pngData;

	 }
	 public static ByteArrayOutputStream getQRCodeImages(String text, int width, int height)  {
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix;
	        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
			try {
				bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
				  MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
			} catch (WriterException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        return pngOutputStream;

	 }
	 
	 public static void main(String[] args) {
		  byte[] qrCodeImages = getQRCodeImage("你好", 10, 10);
		 try {
			Image read = ImageIO.read(new ByteArrayInputStream(qrCodeImages));
			System.out.println(read);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(qrCodeImages);
	}
	 
	 private static   ByteArrayInputStream pares(ByteArrayOutputStream out)  {
		 ByteArrayInputStream swapStream = new ByteArrayInputStream(out.toByteArray());
		 return swapStream;
	}
}
