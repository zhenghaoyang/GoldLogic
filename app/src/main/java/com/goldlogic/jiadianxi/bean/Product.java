package com.goldlogic.jiadianxi.bean;

/**
 * Created by Administrator on 2018/4/8.
 */

public class Product {

    public String tag = "新旧单";

    public String companyLogoUrl = "////";

    public String investLevel = "投15000";

    public String companyBackground = "五百强";

    public String yearInverest = "300%";


    /**
     * TaskId : 1800
     * Name : 拓道金服
     * LogoPic : 20180307153442.png
     * AddInterest : 13.1
     * AllYearRate : 21.1
     * ReinvestAward : false
     * Score : 94
     * SimpleDescription : null
     * Tag :
     * YearRate : null
     * IsYear : false
     * Ext2 : 30天
     * Ext1 : 2
     * Ext4 : 新单
     * Ext6 : 10000-100000
     * Mystery : false
     * Released : true
     * Period : 2
     */

    private int TaskId;
    private String Name;
    private String LogoPic;
    private String AddInterest;
    private String AllYearRate;
    private boolean ReinvestAward;
    private int Score;
    private Object SimpleDescription;
    private String Tag;
    private Object YearRate;
    private boolean IsYear;
    private String Ext2;
    private String Ext1;
    private String Ext4;
    private String Ext6;
    private boolean Mystery;
    private boolean Released;
    private String Period;

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int TaskId) {
        this.TaskId = TaskId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLogoPic() {
        return LogoPic;
    }

    public void setLogoPic(String LogoPic) {
        this.LogoPic = LogoPic;
    }

    public String getAddInterest() {
        return AddInterest;
    }

    public void setAddInterest(String AddInterest) {
        this.AddInterest = AddInterest;
    }

    public String getAllYearRate() {
        return AllYearRate;
    }

    public void setAllYearRate(String AllYearRate) {
        this.AllYearRate = AllYearRate;
    }

    public boolean isReinvestAward() {
        return ReinvestAward;
    }

    public void setReinvestAward(boolean ReinvestAward) {
        this.ReinvestAward = ReinvestAward;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public Object getSimpleDescription() {
        return SimpleDescription;
    }

    public void setSimpleDescription(Object SimpleDescription) {
        this.SimpleDescription = SimpleDescription;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    public Object getYearRate() {
        return YearRate;
    }

    public void setYearRate(Object YearRate) {
        this.YearRate = YearRate;
    }

    public boolean isIsYear() {
        return IsYear;
    }

    public void setIsYear(boolean IsYear) {
        this.IsYear = IsYear;
    }

    public String getExt2() {
        return Ext2;
    }

    public void setExt2(String Ext2) {
        this.Ext2 = Ext2;
    }

    public String getExt1() {
        return Ext1;
    }

    public void setExt1(String Ext1) {
        this.Ext1 = Ext1;
    }

    public String getExt4() {
        return Ext4;
    }

    public void setExt4(String Ext4) {
        this.Ext4 = Ext4;
    }

    public String getExt6() {
        return Ext6;
    }

    public void setExt6(String Ext6) {
        this.Ext6 = Ext6;
    }

    public boolean isMystery() {
        return Mystery;
    }

    public void setMystery(boolean Mystery) {
        this.Mystery = Mystery;
    }

    public boolean isReleased() {
        return Released;
    }

    public void setReleased(boolean Released) {
        this.Released = Released;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String Period) {
        this.Period = Period;
    }
}
