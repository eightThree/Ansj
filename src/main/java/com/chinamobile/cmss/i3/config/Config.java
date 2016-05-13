package com.chinamobile.cmss.i3.config;


/**
 * Created by zhanghong on 2016/5/11
 */
public class Config {
    /**
     * mysql 配置
     */
//    public static final String MYSQL_URL_PORT = "10.128.3.114:3306";
    public static final String MYSQL_URL_PORT = "10.133.5.48:3306";
    public static final String MYSQL_DB = "scrm";
    public static final String MYSQL_USER = "scrm";
    public static final String MYSQL_PASSWORD = "123@scrm";

    /**
     * hbase 配置
     */
    public static final String HBASE_ZOOKEEPER_CLIENTPORT_VALUE = "2181";
    public static final String HBASE_ZOOKEEPER_QUORUM_VALUE = "10.254.3.104,10.254.4.6,10.254.4.18";
    public static final String HBASE_ROOT_DIR_VALUE = "hdfs://10.254.3.104:8020/apps/hbase/data";
//    public static final String HBASE_ZOOKEEPER_QUORUM_VALUE = "node4, node7, node9";
//    public static final String HBASE_ROOT_DIR_VALUE = "hdfs://node4:8020/apps/hbase/data";

    public static final String HBASE_ORIGIN = "origin";

    /**
     * redis 配置
     */
    public static final String REDIS_HOST = "10.133.12.25";
    public static final Integer REDIS_PORT = 6379;
    public static final String REDIS_CREATE_DB = "wbAnalysis_unprocessed_url";
    public static final String REDIS_UPDATE_DB = "wbAnalysis_unprocessed_update";
    public static final String REDIS_UID_DB = "wbAnalysis_missed_uid";

    /**
     * hdfs 配置
     */
    public static final String HDFS_FS = "fs.defaultFS";
    //public static final String HDFS_FS_VALUE = "hdfs://10.133.16.85:8020";
    public static final String HDFS_FS_VALUE = "hdfs://scrm49:8020";

    public static final String HDFS_OUT_PATH = "/HotNews/out";
    public static final String HDFS_IN_PATH = "/HotNews/in";

    /**
     * MR 配置
     */
    public static final Integer MR_MAP_SIZE = 15;
    public static final Integer MR_REDUCE_SIZE = 10;

    /**
     * hadoop配置
     */
    public static final String HADOOP_YARN_RM_ADDR = "scrm49:8050";
    //public static final String HADOOP_YARN_RM_ADDR = "10.133.16.85:8050";

    /**
     * 其他配置
     */
    public static final String STOP_DICT_PATH = "resources/dict/stop.dict";              // 停用词词典路径
    public static final String TRAIN_FILE_PATH = "resource/forum.xlsx";                 // 训练文件路径
    public static final String TEST_FILE_PATH = "resource/forum1_test.xlsx";           // 训练文件路径
    public static final String MODEL_FILE_PATH = "resource/model/svm.model";           // 模型保存路径
    public static final int NORMAL_FEATHRE_WORD_NUM = 4000;                              // 正常类特征词数量
    public static final int SPAM_FEATHRE_WORD_NUM = 4000;                                // 垃圾类特征词数量
}