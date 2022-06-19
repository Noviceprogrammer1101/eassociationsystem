package com.wei.pojo;

import lombok.Data;

/**
 * 快递类
 * @author wei
 */
@Data
public class Parcel implements Comparable<Parcel>{
    private String recipientName;
    private String telPhone;
    private String province;
    private String senderName;
    private String senderPhone;
    private String senderProvince;
    private double postage;

    /**
     * 快递单号
     */
    private String parcelNum;

    /**
     * 按照单号排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Parcel o) {
        return Integer.parseInt(this.parcelNum) - Integer.parseInt(o.getParcelNum());
    }
}
