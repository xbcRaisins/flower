package com.xbc.flower.xbcflowerboot.service.impl;

import com.xbc.flower.xbcflowerboot.dao.StationDao;
import com.xbc.flower.xbcflowerboot.entity.Station;
import com.xbc.flower.xbcflowerboot.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：
 *
 * @author weizeng
 * @date 2019/4/30 16:38
 */
@Service
public class StationServiceImpl implements StationService {

    @Autowired
    StationDao stationDao;


    @Override
    public void add(Station station) {
        stationDao.add(station);
    }


}
