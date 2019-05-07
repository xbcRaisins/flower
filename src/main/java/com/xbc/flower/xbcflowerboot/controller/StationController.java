package com.xbc.flower.xbcflowerboot.controller;


import com.xbc.flower.xbcflowerboot.entity.Station;
import com.xbc.flower.xbcflowerboot.service.StationService;
import com.xbc.flower.xbcflowerboot.util.FileUtil;
import com.xbc.flower.xbcflowerboot.util.ListUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 描述：
 *
 * @author weizeng
 * @date 2019/4/30 16:36
 */
@RestController
@RequestMapping("/station")
public class StationController {

    Logger log = LoggerFactory.getLogger(StationController.class);

    @Autowired
    StationService stationService;

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @RequestMapping("/add")
    public void add() {
        String stationName = FileUtil.readFileAll("D:\\station.txt");
        String[] lists = stationName.split(",");
        List<List<String>> allLIst = ListUtil.averageAssign(Arrays.asList(lists), 10);
        for (List<String> list : allLIst) {
            process(threadPoolTaskExecutor, list);
        }
    }

    public void process(ThreadPoolTaskExecutor executor, final List<String> list) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < list.size() - 1; ) {
                    Station station = new Station(list.get(i), list.get(i + 1), list.get(i + 2), list.get(i + 3), list.get(i + 4));
                    log.info(station.toString());
                    stationService.add(station);
                    if (i < list.size() - 1) {
                        i = i + 5;
                    }
                }
            }
        });
    }
}