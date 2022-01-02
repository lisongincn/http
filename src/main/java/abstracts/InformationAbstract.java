package abstracts;

import abstracts.informationLine.InformationLineAbstract;

/**
 * 消息
 */
public abstract class InformationAbstract {
    /**
     * 设置消息行
     *
     * @param informationLine 消息行
     */
    abstract public void setInformationLine(InformationLineAbstract informationLine);

    /**
     * 获取消息行
     *
     * @return 消息行
     */
    abstract public InformationLineAbstract getInformationLine();

    /**
     * 设置消息头
     *
     * @param headers 消息头
     */
    abstract public void setHeaders(HeadersAbstract headers);

    /**
     * 获取消息头
     *
     * @return 消息头
     */
    abstract public HeadersAbstract getHeaders();

    /**
     * 设置消息内容
     *
     * @param contents 消息内容
     */
    abstract public void setContents(ContentsAbstract contents);

    /**
     * 获取消息内容
     *
     * @return 消息内容
     */
    abstract public ContentsAbstract getContents();

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