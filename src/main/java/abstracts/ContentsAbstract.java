package abstracts;

/**
 * 消息内容
 */
public abstract class ContentsAbstract {
    /**
     * 设置消息内容
     *
     * @param contents 内容
     */
    abstract public void setContents(String contents);

    /**
     * 获取消息内容
     *
     * @return 内容
     */
    abstract public String getContents();

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