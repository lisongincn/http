package impl;

import abstracts.informationLine.InformationLineRequestAbstract;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationLineRequest extends InformationLineRequestAbstract {

    private String method;
    private String url;
    private String host;
    private int port = -1;
    private String path;
    private String parameter;

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String toString() {
        return "InformationLineRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", version='"+getVersion()+'\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", path='" + path + '\'' +
                ", parameter='" + parameter + '\'' +
                '}';
    }

    @Override
    public void clear() {
        setMethod(null);
        setUrl(null);
        setVersion(null);
        setHost(null);
        setPort(-1);
        setPath(null);
        setParameter(null);
    }

    @Override
    public void stringToHttp(String httpString) {
        clear();
        Matcher matcher;
        matcher = Pattern.compile(Regex.REGEX_INFORMATION_LINE).matcher(httpString);
        if (matcher.find()) {
            String method = matcher.group(1);
            String url = matcher.group(2);
            String version = matcher.group(3);
            setMethod(method);
            setUrl(url);
            setVersion(version);
        }
        matcher = Pattern.compile(Regex.REGEX_INFORMATION_LINE_REQUEST_HOST).matcher(getUrl());
        if (matcher.find()) {
            String host = matcher.group(1);
            setHost(host);
        }
        matcher = Pattern.compile(Regex.REGEX_INFORMATION_LINE_REQUEST_PORT).matcher(getUrl());
        if (matcher.find()) {
            String prot = matcher.group(1);
            setPort(Integer.parseInt(prot));
        }
        matcher = Pattern.compile(Regex.REGEX_INFORMATION_LINE_REQUEST_PATH).matcher(getUrl());
        if (matcher.find()) {
            String path = matcher.group(1);
            setPath(path);
        }
        matcher = Pattern.compile(Regex.REGEX_INFORMATION_LINE_REQUEST_PARAMETER).matcher(getUrl());
        if (matcher.find()) {
            String parameter = matcher.group(1);
            setParameter(parameter);
        }
    }

    @Override
    public String httpToString() {
        return String.format("%s %s %s", getMethod(), getUrl(), getVersion());
    }

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getParameter() {
        return this.parameter;
    }

    @Override
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
