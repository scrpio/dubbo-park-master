package com.park.weixin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.park.common.util.ResultUtil;
import com.park.common.pojo.Result;
import com.park.model.Garage;
import com.park.model.GarageCar;
import com.park.pojo.Marker;
import com.park.service.GarageCarService;
import com.park.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GarageController {
    @Autowired
    private GarageService garageService;
    @Autowired
    private GarageCarService garageCarService;

    @GetMapping("/api/garageList")
    public Result<List<Marker>> getApiGarageList(Double lat, Double lng){
        return new ResultUtil<List<Marker>>().setData(garageService.getApiGarageList(lat,lng));
    }

    @GetMapping("/api/garage")
    public Result<Garage> getApiGarage(@RequestParam Long id) {
        EntityWrapper<GarageCar> carEntity = new EntityWrapper<>();
        Wrapper<GarageCar> carWrapper = carEntity.eq("garage_id", id).and("status = 0");
        int leisure = garageCarService.selectCount(carWrapper);
        Garage garage = garageService.getGarageById(id);
        garage.setLeisure(leisure);
        return new ResultUtil<Garage>().setData(garage);
    }
}
