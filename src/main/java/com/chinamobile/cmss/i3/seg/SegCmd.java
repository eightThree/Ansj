package com.chinamobile.cmss.i3.seg;
/**
 * Created by zhanghong on 2015/1/23.
 * ANSJ command line server:
 * run steps:
 * 1 javac SegCmd.java
 * 2 java SegCmd
 * 3 java SegCmd inputfile outputfile
 * inputfile:"C:\\Users\\zh\\Desktop\\Ansj\\javatestfile.txt";
 * outputfile:"C:\\Users\\zh\\Desktop\\Ansj\\javatestfile_fenci.txt";
 *
 * absolutepath(ok):
 * steps:
 * 1 C:\Users\zh\Desktop\Ansj\src\main\java>javac -cp .;c:\Users\zh\Desktop\Ansj\ansj_seg-2.0.8.jar;c:\Users\zh\Desktop\Ansj\nlp-lang-0.3.jar;c:\Users\zh\D
 esktop\Ansj\tree_split-1.4.jar c:\Users\zh\Desktop\Ansj\src\main\java\SegCmd.java
 * 2 C:\Users\zh\Desktop\Ansj\src\main\java>java -cp .;c:\Users\zh\Desktop\Ansj\ansj_seg-2.0.8.jar;c:\Users\zh\Desktop\Ansj\nlp-lang-0.3.jar;c:\Users\zh\De
 sktop\Ansj\tree_split-1.4.jar SegCmd "C:\\Users\\zh\\Desktop\\Ansj\\javatestfile.txt" "C:\\Users\\zh\\Desktop\\Ansj\\javatestfile_fenci1.txt"
 */

import org.ansj.splitWord.analysis.ToAnalysis;
import java.io.*;
import java.util.List;
import org.ansj.domain.Term;
public class SegCmd {
    public static void main(String[] args) throws IOException {
        String firstArg,secondArg;
        if (args.length != 2) {
            System.err.println("Argument must be an source file(path) and output file(path)");
            System.out.println("file(path) example:"+"C:\\Users\\zh\\Desktop\\Ansj\\javatestfile.txt");
            System.exit(1);
        }
        else
        {
            try {
                firstArg = args[0];
                secondArg = args[1];
                //String fileName = "C:\\Users\\zh\\Desktop\\Ansj\\javatestfile.txt";
                String fileName = firstArg;
                File file = new File(fileName);
                BufferedReader reader = null;
                //FileWriter fw = new FileWriter("C:\\Users\\zh\\Desktop\\Ansj\\javatestfile_fenci.txt", true);
                //FileWriter fw = new FileWriter(secondArg);

                FileOutputStream fos = new FileOutputStream(secondArg);
                OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
                System.out.println("Start Segmentation :"+firstArg);
                try {
                    System.out.println("Segment by line:\n");
                    reader = new BufferedReader(new FileReader(file));
                    String tempString = null;
                    int line = 1;
                    //read each line to end
                    while ((tempString = reader.readLine()) != null) {
                        // line number and segmentation
                        List<Term> parse_to = ToAnalysis.parse(tempString);
                        StringBuffer sbuf = new StringBuffer();
                        for (int i = 0; i < parse_to.size(); i++)
                            sbuf.append(parse_to.get(i));
                        sbuf.append("\n");
                        String result=new String(sbuf.toString().getBytes(),"UTF-8");
                        osw.write(result);
                        osw.flush();
                        //fw.write(result,0,result.length());
                        //fw.write(sbuf.toString(), 0, sbuf.toString().length());
                        //fw.flush();
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
                            osw.close();
                            fos.close();
                            //fw.close();
                        } catch (IOException e1) {
                        }
                    }
                }
                System.out.println("The input file is :"+firstArg);
                System.out.println("The output file is :"+secondArg);
                System.out.println("End Segmentation!");
            } catch (Exception e) {
                System.err.println("Some errors encount:"+e.getMessage());
                System.exit(1);
            }
        }
    }
}
