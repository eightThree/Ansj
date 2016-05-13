package com.chinamobile.cmss.i3.seg;

/**
 * Created by zhanghong on 2016/4/5.
 * revised by zhanghong on 2016/05/11.
 */
import com.chinamobile.cmss.i3.util.StopDictUtil;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;


import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.ansj.splitWord.analysis.BaseAnalysis;

public class DirectoryFileContentSegment {

    public static void main(String[] args){
    //    String path="input_seg/";
    //    String path ="C:\\Users\\zh\\Desktop\\商情分析系统\\data\\SogouC.reduced.20061102\\sogou\\test\\" ;
    //    String path ="C:\\Users\\zh\\Desktop\\商情分析系统\\data\\yuqing\\other\\" ;
	String path ="/var/www/html/yuqing/transportshipping/";
        DirectoryFileContentSegment dfcs = new DirectoryFileContentSegment();
        DirectoryFileContentSegment.ReadAllFile(path);
    }

    //读取一个文件夹下所有文件及子文件夹下的所有文件
    //递归读取
    //参数是目录
    public static void ReadAllFile(String filePath){
        File f = null;
        f = new File(filePath);
        File[] files = f.listFiles(); // 得到f文件夹下面的所有文件。
        //  List<File> list = new ArrayList<File>();
        for (File file : files) {
            if(file.isDirectory()) {
                System.out.println("文件夹："+file);
                //如何当前路劲是文件夹，则循环读取这个文件夹下的所有文件
                ReadAllFile(file.getAbsolutePath());
            } else if(file.isFile()){
                System.out.println("文     件："+file);
                //        list.add(file);
                try{
                    segment(file);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //分词，ansj
    public static void segment(File file) throws IOException {
        //读取GBK文件，需要设置GBK编码格式。默认读取utf-8文件
    //    String encoding="utf-8";
    //    InputStreamReader reader1 = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
        InputStreamReader reader1 = new InputStreamReader(new FileInputStream(file));//考虑到编码格式
        BufferedReader reader = new BufferedReader(reader1);
        FileWriter fw = new FileWriter(file.toString()+"_seg",true);
        try {
            String tempString = null;
            StringBuffer sbuf=new StringBuffer();
            while ((tempString = reader.readLine()) != null) {
                // 显示行号+精准分词
                List<Term> parse_to = ToAnalysis.parse(tempString);
                for (int i = 0; i < parse_to.size(); i++)
                {

                    Term tempterm =parse_to.get(i);
                    String tempstr = tempterm.toString();
                    if(tempstr.contains("/w")){continue;}//去掉标点符号
                    if(tempstr.indexOf("/")!=-1)
                    {
                        String[] segword = tempstr.split("/");
                        if(segword.length==2)
                        {
                            //去停用词
                            if(StopDictUtil.isStopWord(segword[0]))
                            {
                                continue;
                            }
                            else
                            {
                                sbuf.append(segword[0]);
                                sbuf.append(" ");
                            }
                        }
                        else
                        {continue;}

                    }
                    else{continue;}
                }
            }
//            it, 01
//            financial,02
//            realestate,03,
//            commercialservice,04
//            tradewholesale,05,
//            education,06,
//            manufacture,07,
//            transportshipping,08,
//            service,09
//            culture,10,
//            energyresource,11,
//            government,12,
//            agriculture,13,
//            medical,14,
//            tourism,15,
//            other,16
            String result = sbuf.toString();
            fw.write(result, 0, result.length());
            fw.flush();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    fw.close();
                } catch
                        (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    //文件批量合并
    public static void MergeAllFiles(){


    }
}
