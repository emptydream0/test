package com.spring.springboot.controller;

import com.spring.springboot.common.Result;
import com.spring.springboot.entity.AverageData;
import com.spring.springboot.entity.MyData;
import com.spring.springboot.mapper.MydataMapper;
import com.spring.springboot.service.MyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class MyDataController {
    @Autowired
    private MydataMapper mydataMapper;
    @Autowired
    private MyDataService myDataService;

    @PostMapping("/save")
    public Result save(@RequestBody MyData data){
        myDataService.saveOrUpdate(data);
        return Result.success("保存成功");
    }
// ascOrDesc用于更改排序模式，0为升序，1或其他数字为降序
    @PostMapping("/listByTime/{ascOrDesc}")
    public Result listByTime(@PathVariable Integer ascOrDesc){
        List<MyData> data= myDataService.listTime(ascOrDesc);
        AverageData averageData = myDataService.averageData(data);
        return Result.success(data,averageData);
    }

    @PostMapping("/listByTemperature/{ascOrDesc}")
    public Result listByTemperature(@PathVariable Integer ascOrDesc){
        List<MyData> data= myDataService.listTemperature(ascOrDesc);
        AverageData averageData = myDataService.averageData(data);
        return Result.success(data,averageData);
    }

    @PostMapping("/listByHumidity/{ascOrDesc}")
    public Result listByHumidity(@PathVariable Integer ascOrDesc){
        List<MyData> data= myDataService.listTemperature(ascOrDesc);
        AverageData averageData = myDataService.averageData(data);
        return Result.success(data,averageData);
    }
    @PostMapping("/listByPressure/{ascOrDesc}")
    public Result listByPressure(@PathVariable Integer ascOrDesc){
        List<MyData> data= myDataService.listPressure(ascOrDesc);
        AverageData averageData = myDataService.averageData(data);
        return Result.success(data,averageData);
    }




}
