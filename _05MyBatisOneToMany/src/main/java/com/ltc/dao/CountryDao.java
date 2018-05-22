package com.ltc.dao;

import com.ltc.bean.Country;
import com.ltc.bean.Provincial;

public interface CountryDao {
    /**
     * 根据国家的id  查询国家以及对应省会的信息
     */

    Country selectCountryByCid(Integer id);


}
