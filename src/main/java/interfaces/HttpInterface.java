package interfaces;

import abstracts.InformationAbstract;

import java.io.IOException;

/**
 * http协议
 */
public interface HttpInterface {
    /**
     * 执行一次请求
     *
     * @param information 消息
     * @return 服务器返回的结果
     */
    InformationAbstract request(InformationAbstract information) throws IOException;
}