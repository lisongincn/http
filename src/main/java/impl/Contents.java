package impl;

import abstracts.ContentsAbstract;

public class Contents extends ContentsAbstract {
    private String contents;
    @Override
    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String getContents() {
        return this.contents;
    }

    @Override
    public void clear() {
        setContents(null);
    }

    @Override
    public void stringToHttp(String httpString) {
        setContents(httpString);
    }

    @Override
    public String httpToString() {
        return getContents()==null?"":getContents();
    }

    @Override
    public String toString() {
        return "Contents{" +
                "contents='" + contents + '\'' +
                '}';
    }
}