package com.haojg.tesseract;

import net.sourceforge.tess4j.Tesseract;

import java.io.File;

public class Main {


    public static void main(String[] args) throws Exception{
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/Users/haojianguo/Downloads/tessdata");
        String s = tesseract.doOCR(new File("/Users/haojianguo/Downloads/demo.jpeg"));

        System.out.println(s);
    }



}
