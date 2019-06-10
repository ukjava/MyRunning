package com.ukjava.myrunning.main.bean;

import java.io.Serializable;

/**
 * Author ：zouyi
 * Time ： 2019/3/12
 * Declare ：登录返回数据     全部保存
 */
public class LoginBean implements Serializable {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getMemberPhoto() {
        return memberPhoto;
    }

    public void setMemberPhoto(String memberPhoto) {
        this.memberPhoto = memberPhoto;
    }

    public String getMemberGradeId() {
        return memberGradeId;
    }

    public void setMemberGradeId(String memberGradeId) {
        this.memberGradeId = memberGradeId;
    }

    public String getMemberGradeName() {
        return memberGradeName;
    }

    public void setMemberGradeName(String memberGradeName) {
        this.memberGradeName = memberGradeName;
    }

    public String getIsSetPassword() {
        return isSetPassword;
    }

    public void setIsSetPassword(String isSetPassword) {
        this.isSetPassword = isSetPassword;
    }

    public String getIsSetPayPassword() {
        return isSetPayPassword;
    }

    public void setIsSetPayPassword(String isSetPayPassword) {
        this.isSetPayPassword = isSetPayPassword;
    }

    /**
     * token : d558ddfa316e15342929d6e5b8bc8f29
     * memberId : ae0408e3108542fcbe584dc084fd36f0
     * memberName : test
     * cardnum : NO.201902201641231721
     * account : test1
     * email : 571@qq.com
     * tel : 13428140655
     * sex : 女
     * birthdate : 2019-02-22
     * memberPhoto : http://app2.15fen.com:7079/member-file/ae0408e3108542fcbe584dc084fd36f0.jpg
     * memberGradeId : 78aed2f6097749feab06a664ed35d932
     * memberGradeName : 铜牌会员
     * isSetPassword : Y/N    (是否设置过登录密码  Y是)
     * isSetPayPassword : Y/N    （是否设置了支付密码）
     */

    private String token;
    private String memberId;
    private String memberName;
    private String cardnum;
    private String account;
    private String email;
    private String tel;
    private String sex;
    private String birthdate;
    private String memberPhoto;
    private String memberGradeId;
    private String memberGradeName;
    private String isSetPassword;
    private String isSetPayPassword;
}
