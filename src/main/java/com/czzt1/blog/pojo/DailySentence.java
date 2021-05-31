package com.czzt1.blog.pojo;

/**
 * @Author czzt1
 * @Date 2019-06-20- 17:36
 */
public class DailySentence {
    private String englishText;
    private String chineseText;
    private String dateStr;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    @Override
    public String toString() {
        return "DailySentence{" +
                "englishText='" + englishText + '\'' +
                ", chineseText='" + chineseText + '\'' +
                '}';
    }

    public String getEnglishText() {
        return englishText;
    }

    public void setEnglishText(String englishText) {
        this.englishText = englishText;
    }

    public String getChineseText() {
        return chineseText;
    }

    public void setChineseText(String chineseText) {
        this.chineseText = chineseText;
    }
}
