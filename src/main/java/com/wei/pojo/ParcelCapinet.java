package com.wei.pojo;

import java.util.ArrayList;
import java.util.TreeSet;

import com.wei.common.CommonCode;
import com.wei.common.Result;

/**
 * 快递柜
 * @author wei
 */
public class ParcelCapinet {
    /**
     * 默认容量为3
     */
    private static final int DEFAULT_CAPACITY=3;
    /**
     * 用于记录快递柜中存储的快递数量
     */
    private int count;
    /**
     * 创建3行3列的快递柜
     */
    private Parcel[][] parcels = new Parcel[DEFAULT_CAPACITY][DEFAULT_CAPACITY];

    //存储快递
    public Result save(Parcel parcel) {
        Result result = new Result();
        for (int i = 0; i < parcels.length; i++) {
            for (int j = 0; j < parcels[0].length; j++) {
                if (parcels[i][j] != null) {
                    parcels[i][j] = parcel;

                    result.setMessage(CommonCode.save_success.getMessage());
                    return result;
                }
            }
        }
        //存入不成功
        result.setMessage(CommonCode.save_error.getMessage());
        return result;
    }

    //取快递

    /**
     * 根据快递单号取快递
     * @param parcelNum
     * @return
     */
    public Result getByNum(String parcelNum) {
        ArrayList<Parcel> list = new ArrayList<>();
        Result result = new Result();
        for (int i = 0; i < this.parcels.length; i++) {
            for (int j = 0; j < this.parcels[0].length; j++) {
                if (parcelNum.equals(this.parcels[i][j].getParcelNum())) {
                    list.add(parcels[i][j]);
                    result.setMessage(CommonCode.update_recipientname_success.getMessage());
                    result.setList(list);
                    return result;
                }
            }
        }
        result.setMessage(CommonCode.update_recipientname_error.getMessage());
        return result;
    }

    /**
     * 根据行号和列号取快递
     * @param row
     * @param coloum
     * @return
     */
    public Result getByRowAndColoum(int row,int coloum) {
        ArrayList<Parcel> list = new ArrayList<>();
        Result result = new Result();
        if (this.parcels[row][coloum] != null) {
            list.add(parcels[row][coloum]);
            result.setList(list);
            return result;
        }
        result.setMessage(CommonCode.update_recipient_phone_error.getMessage());
        return result;
    }
    //更新快递

    /**
     * 根据单号，更新收件人名字
     * @param parcelNum
     * @param recipientName
     * @return
     */
    public Result updateByNum(String parcelNum,String recipientName) {
        Result result = new Result();
        for (int i = 0; i < parcels.length; i++) {
            for (int j = 0; j < parcels[0].length; j++) {
                if (parcelNum.equals(parcels[i][j].getParcelNum())) {
                    parcels[i][j].setRecipientName(recipientName);
                    result.setMessage(CommonCode.update_recipientname_success.getMessage());
                    return result;
                }
            }
        }
        result.setMessage(CommonCode.update_recipientname_error.getMessage());
        return result;
    }

    /**
     * 更新收件人电话号码
     * @param row
     * @param coloum
     * @param telPhone
     * @return
     */
    public Result updateByRowAndColoum(int row,int coloum,String telPhone) {
        Result result = new Result();
        if (parcels[row][coloum] != null) {
            parcels[row][coloum].setTelPhone(telPhone);
            result.setMessage(CommonCode.update_recipientphone_success.getMessage());
        }
        result.setMessage(CommonCode.update_recipient_phone_error.getMessage());
        return result;
    }


    /**
     * 根据单号查询快递
     * @param num
     * @return
     */
    public Result findByNum(String num) {
        Result result = new Result();
        for (int i = 0; i < parcels.length; i++) {
            for (int j = 0; j < parcels[0].length; j++) {
                if (num.equals(parcels[i][j].getParcelNum())) {
                    result.setMessage(CommonCode.find_accodring_num_success.getMessage());
                    return result;
                }
            }
        }
        result.setMessage(CommonCode.find_accodring_num_error.getMessage());
        return result;
    }

    /**
     * 根据姓名查询所有快递
     * @param recipientName
     * @return
     */
    public Result findAllByName(String recipientName) {
        ArrayList<Parcel> list = new ArrayList<>();
        Result result = new Result();
        for (int i = 0; i < this.parcels.length; i++) {
            for (int j = 0; j < this.parcels[0].length; j++) {
                if (recipientName.equals(this.parcels[i][j].getParcelNum())) {
                    list.add(parcels[i][j]);
                }
            }
        }
        result.setList(list);
        return result;
    }

    /**
     * 从小到大排序，只显示单号
     *
     * @return
     */
    public Result sortByNum() {
        ArrayList<String> list = new ArrayList<>();
        Result result = new Result();
        TreeSet<Parcel> treeSet = new TreeSet<>();
        for (int i = 0; i < this.parcels.length; i++) {
            for (int j = 0; j < this.parcels[0].length; j++) {
                treeSet.add(parcels[i][j]);
            }
        }
        for (Parcel p :
                treeSet) {
            list.add(p.getParcelNum());
        }
        result.setList(list);
        return result;
    }

    /**
     * 计算出快递柜的快递数量
     *
     * @return
     */
    public Result findAllCount() {
        ArrayList<Integer> list = new ArrayList<>();
        Result result = new Result();
        list.add(count);
        result.setList(list);
        return result;
    }

}
