package abstracts.informationLine;

/**
 * 请求信息行
 */
public abstract class InformationLineRequestAbstract extends InformationLineAbstract {
    /**
     * 设置请求方法
     * 例如:
     * GET/POST/...
     *
     * @param method 方法
     */
    abstract public void setMethod(String method);

    /**
     * 获取请求方法
     *
     * @return 方法
     */
    abstract public String getMethod();

    /**
     * 设置请求 URL 地址
     * 则默端口: 80
     * 例如:
     * http://www.google.com/xxx/xxx？xx=11
     * http://127.0.0.1:8848/login?user=username=root,passwd=123456
     * http://192.168.0.1/
     *
     * @param url 地址
     */
    abstract public void setUrl(String url);

    /**
     * 获取 URL 地址;
     */
    abstract public String getUrl();

    /**
     * 返回一个程序可读字符串
     *
     * @return 字符串
     */
    abstract public String toString();

    /**
     * 获取主机
     *
     * @return 主机地址
     */
    abstract public String getHost();

    /**
     * 获取端口
     *
     * @return 端口
     */
    abstract public int getPort();

    /**
     * 获取路径
     *
     * @return 路径
     */
    abstract public String getPath();

    /**
     * 设置主机
     *
     * @return 主机地址
     */
    abstract public void  setHost(String host);

    /**
     * 设置端口
     *
     * @return 端口
     */
    abstract public void  setPort(int port);

    /**
     * 设置路径
     *
     * @return 路径
     */
    abstract public void setPath(String path);

    /**
     * 获取参数
     * @return 参数
     */
    abstract public String getParameter();

    /**
     * 设置参数
     * @return 参数
     */
    abstract public void setParameter(String parameter);
}