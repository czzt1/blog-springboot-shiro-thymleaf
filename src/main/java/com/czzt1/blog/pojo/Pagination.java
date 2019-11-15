package com.czzt1.blog.pojo;

public class Pagination {
    private int totalPageNum;
    private int curPageNum;

    public Pagination(int totalPageNum, int curPageNum) {
        this.totalPageNum = totalPageNum;
        this.curPageNum = curPageNum;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getCurPageNum() {
        return curPageNum;
    }

    public void setCurPageNum(int curPageNum) {
        this.curPageNum = curPageNum;
    }
}
