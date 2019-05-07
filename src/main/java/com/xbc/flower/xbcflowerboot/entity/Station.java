package com.xbc.flower.xbcflowerboot.entity;

import lombok.Data;

/**
 * 描述：
 *
 * @author xbcRaisins
 * @date 2019/5/1 14:45
 */
@Data
public class Station {

    public Station(){

    }

    public Station(String num, String name, String code, String pinyin, String abbr) {
        this.num = num;
        this.name = name;
        this.code = code;
        this.pinyin = pinyin;
        this.abbr = abbr;
    }

    private String num;
    private String name;
    private String code;
    private String pinyin;
    private String abbr;
}
