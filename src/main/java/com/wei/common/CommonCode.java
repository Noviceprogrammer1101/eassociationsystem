package com.wei.common;

/**
 * 提示码
 * @author wei
 */

public enum CommonCode {
    save_success("1","存快递成功"),
    save_error("0","存快递失败"),
    find_accodring_num_success("11","根据单号查询成功"),
    find_accodring_num_error("11","根据单号查询成功"),
    update_recipientname_success("21","更新收件人名字成功"),
    update_recipientname_error("22","更新收件人名字失败"),
    update_recipientphone_success("23","更新收件人电话成功"),
    update_recipient_phone_error("24","更新收件人电话失败");

    private final String code;
    private final String message;

    CommonCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
