package com.wcy.design_pattern.factory;

import com.wcy.design_pattern.factory.entity.Milk;
import com.wcy.design_pattern.factory.entity.TeiLunSu;
import com.wcy.design_pattern.factory.entity.YiliMilk;

public class SimpleFactory {

    public Milk getMileName(String name){
        if("yili".equals(name)){
            return new YiliMilk();
        }else if("teilunsu".equals(name)){
            return new TeiLunSu();
        }
        return null;
    }
}
