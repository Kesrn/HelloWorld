package com.zc.partymember.domain;

import java.util.Date;

public class Dept {
    private int id;
    private String name;
    private String code;
    private String remark;
    private String createBy;
    private Date createDate;
    private Date updateDate;
    private String updateBy;
    private Integer fid;

    public Dept(int id,String name,String code,String remark,String createBy,
                Date createDate,Date updateDate,String updateBy){
                this.id=id;
                this.name=name;
                this.code=code;
                this.remark=remark;
                this.createBy=createBy;
                this.createDate=createDate;
                this.updateBy=updateBy;
                this.updateDate=updateDate;
    }
    public Dept(){
        super();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }
}
