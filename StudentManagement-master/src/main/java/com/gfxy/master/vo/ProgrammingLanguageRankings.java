package com.gfxy.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguageRankings {

    /**
     * id
     */
    private int id;

    /**
     * 排名
     */
    private int rank;

    /**
     * 语言
     */
    private String language;

    /**
     * 人气
     */
    private Float popularity;

    /**
     * 与上月比较
     */
    private String comparisonLastMonth;

    /**
     * 年度之星
     */
    private String annualStar;
}
