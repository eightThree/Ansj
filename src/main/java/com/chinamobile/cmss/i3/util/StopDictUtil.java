package com.chinamobile.cmss.i3.util;

import com.chinamobile.cmss.i3.config.Config;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zouxiaoheng on 2016/3/10.
 */
public class StopDictUtil {
    private static HashSet<String> stopWordSet = loadStopDict(Config.STOP_DICT_PATH);

    /**
     * 停用词集合
     *
     * @param filePath 停用词存放的文件路径
     * @return 停用词集合
     */
    public static HashSet<String> loadStopDict(String filePath) {
        stopWordSet = new HashSet<String>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null)
                stopWordSet.add(line);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return stopWordSet;
    }

    /**
     * 停用词过滤
     *
     * @param words 待过滤的词
     * @return 过滤后的词
     */
    public static List<String> stopWordFilter(List<String> words) {
        List<String> result = new ArrayList<String>();
        for (String word : words) {
            if (!stopWordSet.contains(word))
                result.add(word);
        }
        return result;
    }

    /**
     * 判断一个词是否是停用词
     *
     * @param word 待判断的词
     * @retrun true/false
     */

    public static boolean isStopWord(String word) {
        if (stopWordSet.contains(word)) {
            return true;
        } else {
            return false;
        }
    }
}