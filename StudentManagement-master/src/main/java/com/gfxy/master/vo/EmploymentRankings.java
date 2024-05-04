package com.gfxy.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 页面的展示
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentRankings {

    /**
     * id
     */
    private int id;

    /**
     * 排名
     */
    private int rank;

    /**
     * 专业
     */
    private String major;

    /**
     * 月收入
     */
    private String monthlyIncome;

}
