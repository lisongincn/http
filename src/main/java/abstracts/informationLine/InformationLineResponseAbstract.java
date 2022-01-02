package abstracts.informationLine;

/**
 * 响应信息行
 */
public abstract class InformationLineResponseAbstract extends InformationLineAbstract {
    /**
     * 设置响应代码
     *
     * @param code
     */
    abstract public void setCode(int code);

    /**
     * 获取响应代码
     *
     * @return 代码
     */
    abstract public int getCode();

    /**
     * 设置响应消息
     *
     * @param message 消息
     */
    abstract public void setMessage(String message);

    /**
     * 获取响应消息
     *
     * @return 消息
     */
    abstract public String getMessage();

    /**
     * 返回一个程序可读字符串
     * @return 字符串
     */
    abstract public String toString();
}