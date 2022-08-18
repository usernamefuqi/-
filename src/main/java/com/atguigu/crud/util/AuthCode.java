package com.atguigu.crud.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


/**
 * ������֤��
 * @author Administrator
 *
 */
public class AuthCode {  
	
    public static final int AUTHCODE_LENGTH = 5;        //��֤�볤��  
    public static final int SINGLECODE_WIDTH = 15;  //������֤����  
    public static final int SINGLECODE_HEIGHT = 30; //������֤��߶�  
    public static final int SINGLECODE_GAP = 4;     //������֤��֮����  
    public static final int IMG_WIDTH = AUTHCODE_LENGTH * (SINGLECODE_WIDTH + SINGLECODE_GAP);  
    public static final int IMG_HEIGHT = SINGLECODE_HEIGHT;

    //������֤��
    public static String getAuthCode() {
        String authCode = "";
        for(int i = 0; i < AUTHCODE_LENGTH; i++) {
            authCode += new Random().nextInt(10);
        }
        return authCode;
    }
      
    
    //�ڴ�������ͼƬ��ͼƬ������֤�룬�и�����
    public static BufferedImage getAuthImg(String authCode) {  
        
    	//����ͼƬ�ĸߡ�������  
        //RGB���룺red��green��blue  
        BufferedImage img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_BGR);  
        //�õ�ͼƬ�ϵ�һ������  
        Graphics g = img.getGraphics();  
        //���û��ʵ���ɫ������������ɫ  
        g.setColor(Color.white);
        //�û��������һ�����Σ����ε����Ͻ����꣬����  
        g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);  
        //��������ɫ����Ϊ��ɫ������д��  
        g.setColor(Color.BLACK);  
        //�������壺���塢������ʽ�ġ��ֺ�  
        g.setFont(new Font("����", Font.PLAIN, SINGLECODE_HEIGHT + 5));  
          
        //�������  
        char c;  
        for(int i = 0; i < authCode.toCharArray().length; i++) {  
            //ȡ����Ӧλ�õ��ַ�  
            c = authCode.charAt(i);  
            //����һ���ַ�����Ҫ�������ݣ���ʼ��λ�ã��߶�  
            g.drawString(c + "", i * (SINGLECODE_WIDTH + SINGLECODE_GAP)+ SINGLECODE_GAP / 2, IMG_HEIGHT);  
        }  
      
        Random random = new Random();  
        //������
        for(int i = 0; i < 15; i++) {
            int x = random.nextInt(IMG_WIDTH);  
            int y = random.nextInt(IMG_HEIGHT);  
            int x2 = random.nextInt(IMG_WIDTH);  
            int y2 = random.nextInt(IMG_HEIGHT);  
            g.drawLine(x, y, x + x2, y + y2);  
        }  
        return img;  
    }  
}  