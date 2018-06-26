package com.jjoey.dynamictabs.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "customize_tabs")
public class Customize extends Model{

    public boolean isChecked;
    public int icon;

    @Column(name = "tabId")
    public String tabId;

    @Column(name = "tabName")
    public String tabName;

    @Column(name = "tabsCount")
    public int tabsCount;

    @Column(name = "tabPosition")
    private int tabPosition;

    public Customize() {  }

    public Customize(boolean isChecked, int icon, String tabId, String tabName, int tabsCount, int tabPosition) {
        this.isChecked = isChecked;
        this.icon = icon;
        this.tabId = tabId;
        this.tabName = tabName;
        this.tabsCount = tabsCount;
        this.tabPosition = tabPosition;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public int getTabsCount() {
        return tabsCount;
    }

    public void setTabsCount(int tabsCount) {
        this.tabsCount = tabsCount;
    }

    public int getTabPosition() {
        return tabPosition;
    }

    public void setTabPosition(int tabPosition) {
        this.tabPosition = tabPosition;
    }
}
