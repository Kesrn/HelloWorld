package com.zc.partymember.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Member {
    private Integer id;

    private Integer area;

    private Integer township;

    private Integer villageStreet;

    private String volunteerNumber;

    private String name;

    private String sex;

    private String age;

    private String education;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date meetingTime;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date approvalTime;

    private String talker;

    private Date createDate;

    private Integer createBy;

    private Date updateDate;

    private Integer updateBy;

    private String remark;

    private String areaName;

    private String townName;

    private String villageName;

    private String picPath;

    private String status;

//    private String start;
//
//    private String end;

    private String no_agree_reason;

    public Member(Integer id, Integer area, Integer township, Integer villageStreet, String volunteerNumber, String name, String sex, String age, String education, Date meetingTime, Date approvalTime, String talker,
                  Date createDate, Integer createBy, Date updateDate, Integer updateBy, String remark,String picPath,String status) {
        this.id = id;
        this.area = area;
        this.township = township;
        this.villageStreet = villageStreet;
        this.volunteerNumber = volunteerNumber;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.meetingTime = meetingTime;
        this.approvalTime = approvalTime;
        this.talker = talker;
        this.createDate = createDate;
        this.createBy = createBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.remark = remark;
        this.picPath = picPath;
        this.status = status;
    }

    public Member() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area == null ? null : area;
    }

    public Integer getTownship() {
        return township;
    }

    public void setTownship(Integer township) {
        this.township = township == null ? null : township;
    }

    public Integer getVillageStreet() {
        return villageStreet;
    }

    public void setVillageStreet(Integer villageStreet) {
        this.villageStreet = villageStreet == null ? null : villageStreet;
    }

    public String getVolunteerNumber() {
        return volunteerNumber;
    }

    public void setVolunteerNumber(String volunteerNumber) {
        this.volunteerNumber = volunteerNumber == null ? null : volunteerNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public Date getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(Date meetingTime) {
        this.meetingTime = meetingTime;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getTalker() {
        return talker;
    }

    public void setTalker(String talker) {
        this.talker = talker == null ? null : talker.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy == null ? null : createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy == null ? null : updateBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNo_agree_reason() {
        return no_agree_reason;
    }

    public void setNo_agree_reason(String no_agree_reason) {
        this.no_agree_reason = no_agree_reason;
    }

//    public String getStart() {
//        return start;
//    }
//
//    public void setStart(String start) {
//        this.start = start;
//    }
//
//    public String getEnd() {
//        return end;
//    }
//
//    public void setEnd(String end) {
//        this.end = end;
//    }
}