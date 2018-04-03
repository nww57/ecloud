package com.sunesoft.ecloud.admin.api.model;

public class ChangePassword {

    private String oldPw;

    private String newPw;

    private Boolean need;


    public Boolean getNeed() {
        return need;
    }

    public void setNeed(Boolean need) {
        this.need = need;
    }

    public String getOldPw() {
        return oldPw;
    }

    public void setOldPw(String oldPw) {
        this.oldPw = oldPw;
    }

    public String getNewPw() {
        return newPw;
    }

    public void setNewPw(String newPw) {
        this.newPw = newPw;
    }
}
