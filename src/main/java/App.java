import impl.Http;
import impl.Information;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Http http = new Http();
        Information information = new Information();
        information.stringToHttp("GET http://39.134.39.32/PLTV/88888888/224/3221226220/index.m3u8 HTTP/1.1\n" +
                "Host: 39.134.39.32\n" +
                "Connection: keep-alive\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.62\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6\n");
        http.request(information);
        System.out.println(information.httpToString());
    }
}