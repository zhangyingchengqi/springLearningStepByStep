package com.yc.tx.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountVO implements Serializable {
    private static final long serialVersionUID = 6845856180708527688L;

    private Integer accountId;
    private Double money;
    private Integer inAccountId;

}
