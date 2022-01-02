package impl;

import abstracts.HeadersAbstract;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Headers extends HeadersAbstract {
    private HashMap<String, String> headerHashMap = new HashMap<>();

    @Override
    public void setHeader(String key, String value) {
        getHeaderHashMap().put(key, value);
    }

    @Override
    public void setHeaders(HashMap<String, String> headerHashMap) {
        setHeaderHashMap(headerHashMap);
    }

    @Override
    public String getHeader(String key) {
        return getHeaderHashMap().get(key);
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return getHeaderHashMap();
    }

    @Override
    public void clear() {
        getHeaderHashMap().clear();
    }

    @Override
    public void stringToHttp(String httpString) {
        clear();
        Matcher matcher = Pattern.compile(Regex.REGEX_INFORMATION_HEADER).matcher(httpString);
        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            setHeader(key, value);
        }
    }

    @Override
    public String httpToString() {
        StringBuilder stringBuilder = new StringBuilder();
        Set<Map.Entry<String, String>> entries = getHeaderHashMap().entrySet();
        for (Map.Entry<String, String> next : entries) {
            String key = next.getKey();
            String value = next.getValue();
            stringBuilder.append(String.format("%s%s: %s", stringBuilder.toString().length() == 0 ? "" : "\n", key, value));
        }
        return stringBuilder.toString();
    }

    private HashMap<String, String> getHeaderHashMap() {
        return headerHashMap;
    }

    private void setHeaderHashMap(HashMap<String, String> headerHashMap) {
        this.headerHashMap = headerHashMap;
    }

    @Override
    public String toString() {
        return "Headers{" +
                "headerHashMap=" + headerHashMap +
                '}';
    }
}
