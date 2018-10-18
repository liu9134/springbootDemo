package com.lcl.demo3.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/18 16:15
 */
public class ExcelData implements Serializable {

    private static final long serialVersionUID = 4444017239100620999L;

    // 表头
    private List<String> titles;

    // 数据
    private List<List<String>> rows;

    // 页签名称
    private String name;

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "名称：" + this.name+",标题："+this.titles.toString() + ",内容：" + this.rows.toString();
    }
}
