package com.chinamobile.cmss.i3.seg;
/**
 * Created by zhanghong on 2016/4/5.
 */

import org.ansj.splitWord.analysis.*;

import java.io.*;
import java.util.List;
import org.ansj.domain.Term;

public class segDirecotryFile {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\zh\\Desktop\\Ansj\\javatestfile.txt";
        File file = new File(fileName);
        BufferedReader reader = null;
        FileWriter fw = new FileWriter("C:\\Users\\zh\\Desktop\\Ansj\\javatestfile_fenci2.txt",true);
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行利用精准分词：\n");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号+精准分词
                List<Term> parse_to = ToAnalysis.parse(tempString);
                StringBuffer sbuf=new StringBuffer();
                for (int i = 0; i < parse_to.size(); i++) {
                    sbuf.append(parse_to.get(i));
                }
                //   sbuf.append("\n"); //不加换行符会写在一行中
                //   String result=new String(sbuf.toString().getBytes(),"utf-8");
                //   fw.write(result,0,result.length());
                fw.write(sbuf.toString(), 0, sbuf.toString().length());
                fw.flush();
                System.out.println(parse_to);
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    fw.close();
                } catch (IOException e1) {
                }
            }
        }

        /*
        // write your code here
        //基本分词
        List<Term> parse_base = BaseAnalysis.parse("今天天气真好，我和小伙伴们一起去郊游。");
        System.out.println(parse_base);

        //精准分词
        List<Term> parse_to = ToAnalysis.parse("今天天气真好，我和小伙伴们一起去郊游");
        System.out.println(parse_to);


        // 面向索引的分词
        List<Term> parse_index = IndexAnalysis.parse("今天天气真好");
        System.out.println(parse_index);

        //    result:[让/v, 战士/n, 们/k, 过/ug, 一个/m, 欢乐/a, 祥和/a, 的/uj, 新春/t, 佳节/n, 。/w]


        //nlp 分词
     //   List<Term> parse_nlp = NlpAnalysis.parse("洁面仪配合洁面深层清洁毛孔 清洁鼻孔面膜碎觉使劲挤才能出一点点皱纹 脸颊毛孔修复的看不见啦");
     //   System.out.println(parse_nlp);
     */

    }

}
