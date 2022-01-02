package impl;

import abstracts.informationLine.InformationLineResponseAbstract;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationLineResponse extends InformationLineResponseAbstract {
    private int code = -1;
    private String message;

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void clear() {
        setVersion(null);
        setCode(-1);
        setMessage(null);
    }

    @Override
    public void stringToHttp(String httpString) {
        clear();
        Matcher matcher = Pattern.compile(Regex.REGEX_INFORMATION_LINE).matcher(httpString);
        if (matcher.find()) {
            String version = matcher.group(1);
            String code = matcher.group(2);
            String message = matcher.group(3);
            setVersion(version);
            setCode(Integer.valueOf(code));
            setMessage(message);
        }
    }

    @Override
    public String httpToString() {
        String format = String.format("%s %d %s", getVersion(), getCode(), getMessage());
        return format;
    }

    @Override
    public String toString() {
        return "InformationLineResponse{" +
                ", version='"+getVersion()+'\'' +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
