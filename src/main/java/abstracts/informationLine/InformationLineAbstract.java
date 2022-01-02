package abstracts.informationLine;

/**
 * 消息行
 */
public abstract class InformationLineAbstract {
    private String version;

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置协议版本
     *
     * @param version 协议版本
     */
    public void setVersion(String version) {
        this.version = version;
    }


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