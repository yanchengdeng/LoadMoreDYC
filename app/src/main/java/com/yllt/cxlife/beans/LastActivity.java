package com.yllt.cxlife.beans;


/**
 * Created by yanchengdeng on 2016/4/6.
 * 最新活动
 */
public class LastActivity {

    private int drawable;

    private String tittle;

    public LastActivity(int randomCheeseDrawable, String sCheeseString) {
        this.drawable = randomCheeseDrawable;
        this.tittle = sCheeseString;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
