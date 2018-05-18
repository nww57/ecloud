package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
public class Applicant {

    @XStreamAlias("第一申请人")
    private ApplicantFirst first;

    @XStreamImplicit
    private List<ApplicantOther> otherList;

    public Applicant(ApplicantFirst first, List<ApplicantOther> otherList) {
        this.first = first;
        this.otherList = otherList;
    }

    public static List<ApplicantOther> generateOriginalApplicantOther(){
        List<ApplicantOther> otherList = new ArrayList<>();
        otherList.add(new ApplicantOther(1));
        otherList.add(new ApplicantOther(2));
        return otherList;
    }
}
