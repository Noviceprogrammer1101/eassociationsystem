package com.wei.common;
import java.util.List;
import com.wei.pojo.Parcel;

import lombok.Data;

/**
 *
 * 统一返回结果
 * @author wei
 */
@Data
public class Result<T> {
    private String message;
    private List<T> list;
}
