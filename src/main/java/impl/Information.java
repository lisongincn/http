package impl;

import abstracts.ContentsAbstract;
import abstracts.HeadersAbstract;
import abstracts.InformationAbstract;
import abstracts.informationLine.InformationLineAbstract;
import exception.InformationInvalidException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Information extends InformationAbstract {
    private InformationLineAbstract informationLine = new InformationLineRequest();
    private HeadersAbstract headers = new Headers();
    private ContentsAbstract contents = new Contents();

    @Override
    public void setInformationLine(InformationLineAbstract informationLine) {
        this.informationLine = informationLine;
    }

    @Override
    public InformationLineAbstract getInformationLine() {
        return this.informationLine;
    }

    @Override
    public void setHeaders(HeadersAbstract headers) {
        this.headers = headers;
    }

    @Override
    public HeadersAbstract getHeaders() {
        return this.headers;
    }

    @Override
    public void setContents(ContentsAbstract contents) {
        this.contents = contents;
    }

    @Override
    public ContentsAbstract getContents() {
        return this.contents;
    }

    @Override
    public void clear() {
        getInformationLine().clear();
        getHeaders().clear();
        getContents().clear();
    }

    @Override
    public void stringToHttp(String httpString) {
        clear();
        Matcher matcher;
        //捕获消息行
        matcher = Pattern.compile(Regex.REGEX_INFORMATION_LINE).matcher(httpString);
        if (matcher.find()) {//是不是有效的消息行
            String group = matcher.group(0);
            matcher = Pattern.compile(Regex.REGEX_INFORMATION_LINE_REQUEST).matcher(group);
            if (matcher.find()) {//消息行是请求行
                InformationLineRequest informationLineRequest = new InformationLineRequest();
                informationLineRequest.stringToHttp(group);
                setInformationLine(informationLineRequest);
            } else {//消息行是响应行
                InformationLineResponse informationLineResponse = new InformationLineResponse();
                informationLineResponse.stringToHttp(group);
                setInformationLine(informationLineResponse);
            }
        } else {
            throw new InformationInvalidException("无效的消息,因为消息行是无效的");
        }
        //捕获消息头
        matcher = Pattern.compile(Regex.REGEX_INFORMATION_HEADERS).matcher(httpString);
        if (matcher.find()) {
            String group = matcher.group(1);
            Headers headers = new Headers();
            headers.stringToHttp(group);
            setHeaders(headers);
        }
        //捕获消息内容
        matcher = Pattern.compile(Regex.REGEX_INFORMATION_CONTENTS).matcher(httpString);
        if (matcher.find()) {
            String group = matcher.group(1);
            Contents contents = new Contents();
            contents.stringToHttp(group);
            setContents(contents);
        }
    }

    @Override
    public String httpToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getInformationLine().httpToString());
        if (getHeaders().httpToString().length() > 0) {
            stringBuilder.append("\n").append(getHeaders().httpToString());
        }
        stringBuilder.append("\n\n").append(getContents().httpToString());
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Information{" +
                "informationLine=" + informationLine +
                ", headers=" + headers +
                ", contents=" + contents +
                '}';
    }
}
