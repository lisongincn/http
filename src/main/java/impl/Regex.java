package impl;

/**
 * 正则表达式
 */
public class Regex {
    //消息行 共捕获三组信息，已空格为分隔符
    public static String REGEX_INFORMATION_LINE = "^(\\S+)\\s(\\S+)\\s(.*)";
    //请求行
    public static String REGEX_INFORMATION_LINE_REQUEST = "^\\S+\\s(?:https?://)?((?:\\w+)?\\.\\w+)*.*";
    //请求行主机
    public static String REGEX_INFORMATION_LINE_REQUEST_HOST = "^\\S*?((?:\\w+\\.)+\\w+)";
    //请求行端口
    public static String REGEX_INFORMATION_LINE_REQUEST_PORT = ":(\\w+)";
    //请求行目录
    public static String REGEX_INFORMATION_LINE_REQUEST_PATH = "\\.\\w+(?::\\d+)?((/[^\\?]+))";
    //请求行参数
    public static String REGEX_INFORMATION_LINE_REQUEST_PARAMETER = "\\?(\\S*)";

    //响应行
    public static String REGEX_INFORMATION_LINE_RESPONSE = "^(\\S+\\s-?\\d+\\s.*)";
    //全部消息头
    public static String REGEX_INFORMATION_HEADERS = "(\\S+:\\s[\\s\\S]+)\\n\\n";
    //消息头
    public static String REGEX_INFORMATION_HEADER = "(\\S+):\\s(.*)";
    //消息内容
    public static String REGEX_INFORMATION_CONTENTS = "\\n\\n([\\s\\S]*)$";
}