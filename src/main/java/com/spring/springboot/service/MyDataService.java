package com.spring.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.springboot.entity.AverageData;
import com.spring.springboot.entity.MyData;
import com.spring.springboot.mapper.MydataMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyDataService extends ServiceImpl<MydataMapper, MyData> {
    public List<MyData>listTime(Integer ascOrDesc){
        QueryWrapper<MyData> queryWrapper = new QueryWrapper<>();
        if (ascOrDesc==0){
            queryWrapper.orderByAsc("time");
        }else {
            queryWrapper.orderByDesc("time");
        }
        return this.list(queryWrapper);
    }

    public List<MyData>listTemperature(Integer ascOrDesc){
        QueryWrapper<MyData> queryWrapper = new QueryWrapper<>();
        if (ascOrDesc==0){
            queryWrapper.orderByAsc("temperature");
        }else {
            queryWrapper.orderByDesc("temperature");
        }
        return this.list(queryWrapper);
    }
        public List<MyData>listHumidity(Integer ascOrDesc){
        QueryWrapper<MyData> queryWrapper = new QueryWrapper<>();
        if (ascOrDesc==0){
            queryWrapper.orderByAsc("humidity");
        }else {
            queryWrapper.orderByDesc("humidity");
        }
        return this.list(queryWrapper);
    }

        public List<MyData>listPressure(Integer ascOrDesc){
        QueryWrapper<MyData> queryWrapper = new QueryWrapper<>();
        if (ascOrDesc==0){
            queryWrapper.orderByAsc("pressure");
        }else {
            queryWrapper.orderByDesc("pressure");
        }
        return this.list(queryWrapper);
    }

        public AverageData averageData(List<MyData> dataList){
            AverageData average = new AverageData();
            int num= dataList.size();
            double temperatureSum=0;
            double humiditySum=0;
            double pressureSum=0;
            for (int i =0;i<num;i++){
                MyData data=dataList.get(i);
                temperatureSum +=data.getTemperature();
                humiditySum+=data.getHumidity();
                pressureSum+=data.getPressure();

            }
            average.setTemperature(temperatureSum/num);
            average.setHumidity(humiditySum/num);
            average.setPressure(pressureSum/num);
            return average;

        }



}
