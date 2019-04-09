package com.zc.partymember.domain;

import java.util.Date;

public class Questionnaire {
    private Integer id;
    private Integer userId;
    private Integer questionNumber;
    private Date subMissionTime;
    private String answer;
    private String remark;
    private String status;
    private String createBy;
    private Date createDate;
    private Date updateDate;
    private String updateBy;

    public Questionnaire(Integer id, Integer userId, Integer questionNumber, Date subMissionTime, String answer, String createBy, String updateBy,
                         Date createDate, Date updateDate,String remark, String status) {
        this.id = id;
        this.userId = userId;
        this.questionNumber = questionNumber;
        this.subMissionTime = subMissionTime;
        this.remark = remark;
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
        this.status=status;
        this.answer=answer;
    }

    public Questionnaire() {
        super();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Date getSubMissionTime() {
        return subMissionTime;
    }

    public void setSubMissionTime(Date subMissionTime) {
        this.subMissionTime = subMissionTime;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
