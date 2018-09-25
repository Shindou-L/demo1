package linqh.test.demo1.test.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("alarm_info_cfg")
public class AlarmInfoCfg {
    private String uuid;

    @TableField("alarm_name")
    private String alarmName;

    @TableField("alarm_type")
    private String alarmType;

    private String affiliation;

    @TableField("product_type")
    private String productType;

    private String hierarchy;

    @TableField("interface_person")
    private String interfacePerson;

    @TableField("deal_help")
    private String dealHelp;

    private String theory;

    @TableField("alarm_message")
    private String alarmMessage;

    @TableField("eliminate_way")
    private String eliminateWay;

    private int overtime;

    @TableField("judge_obj")
    private String judgeObj;

    private String module;

    @TableField("alarm_key_rule")
    private String alarmKeyRule;

    @TableField("is_crash")
    private int isCrash;

    @TableField("belong_page")
    private String belongPage;

    @TableField("is_public")
    private int isPublic;

    @TableField("creater_user")
    private String createrUser;

    @TableField("update_at")
    private Date updateAt;

    @TableField("create_uuid")
    private String createUuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getInterfacePerson() {
        return interfacePerson;
    }

    public void setInterfacePerson(String interfacePerson) {
        this.interfacePerson = interfacePerson;
    }

    public String getDealHelp() {
        return dealHelp;
    }

    public void setDealHelp(String dealHelp) {
        this.dealHelp = dealHelp;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public String getEliminateWay() {
        return eliminateWay;
    }

    public void setEliminateWay(String eliminateWay) {
        this.eliminateWay = eliminateWay;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public String getJudgeObj() {
        return judgeObj;
    }

    public void setJudgeObj(String judgeObj) {
        this.judgeObj = judgeObj;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getAlarmKeyRule() {
        return alarmKeyRule;
    }

    public void setAlarmKeyRule(String alarmKeyRule) {
        this.alarmKeyRule = alarmKeyRule;
    }

    public int getIsCrash() {
        return isCrash;
    }

    public void setIsCrash(int isCrash) {
        this.isCrash = isCrash;
    }

    public String getBelongPage() {
        return belongPage;
    }

    public void setBelongPage(String belongPage) {
        this.belongPage = belongPage;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public String getCreaterUser() {
        return createrUser;
    }

    public void setCreaterUser(String createrUser) {
        this.createrUser = createrUser;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getCreateUuid() {
        return createUuid;
    }

    public void setCreateUuid(String createUuid) {
        this.createUuid = createUuid;
    }
}
