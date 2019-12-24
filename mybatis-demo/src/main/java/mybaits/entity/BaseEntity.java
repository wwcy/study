package mybaits.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @auth wcy on 2019/7/9.
 */
//@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2393269568666085258L;

    //@Id
    protected String id;

    /**
     * 状态（1正常 2删除 3停用）
     */
    //@Column(name = "status")
    protected Integer status;

    /**
     * 系统内置（1否 2是）
     */
    //@Column(name = "is_sys")
    protected Integer isSys;

    //@Column(name = "created_date")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   // @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    protected Date createDate;

    //Column(name = "updated_date")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date updateDate;

   // @Column(name = "created_by")
    protected String createBy;

    //@Column(name = "updated_by")
    protected String updateBy;

   // @Transient
    protected int pageNum;

    //@Transient
    protected int pageSize;

    /**
     * 删除标记（1：正常；2：删除；3：停用；）
     */
    public static final int DEL_FLAG_NORMAL = 1;
    public static final int DEL_FLAG_DELETE = 2;
    public static final int DEL_FLAG_STOP = 3;
    /**
     *  系统内置（1否 2是 ）
     */
    public static final int SYS_FLAG_NO = 1;
    public static final int SYS_FLAG_YES = 2;

    //@Transient
   // @JsonIgnore
    public boolean isNew() {
        return this.id == null;
    }

    //@Transient
   // @JsonIgnore
    public void preInsert(String user){
        if(isNew()){
            UUID uuid = UUID.randomUUID();
            this.setId(uuid.toString().replace("-", ""));
        }
        this.updateBy = user;
        this.createBy = user;
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    //@Transient
    //@JsonIgnore
    public void preUpdate(String user){
        this.updateBy = user;
        this.updateDate = new Date();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsSys() {
        return isSys;
    }

    public void setIsSys(Integer isSys) {
        this.isSys = isSys;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
