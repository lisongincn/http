package abstracts;

import java.util.HashMap;

/**
 * 消息头
 */
public abstract class HeadersAbstract {
    /**
     * 添加一个消息头
     *
     * @param key   键
     * @param value 值
     */
    abstract public void setHeader(String key, String value);

    /**
     * 设置一个消息头集合
     *
     * @param headsMap 消息头集合
     */
    abstract public void setHeaders(HashMap<String, String> headsMap);

    /**
     * 获取一个消息头
     *
     * @param key 键
     * @return 值
     */
    abstract public String getHeader(String key);

    /**
     * 获取全部的消息头
     *
     * @return 全部消息头
     */
    abstract public HashMap<String, String> getHeaders();

    /**
     * 清除全部字段
     */
    abstract public void clear();

    /**
     * 使用程序可读的字符串初始化对象
     * @return 字符串
     */
    abstract public void stringToHttp(String httpString);

    /**
     * 返回一个程序可读字符串
     * @return 字符串
     */
    abstract public String httpToString();
}