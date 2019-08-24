package com.wcy.design_pattern.factory;

import com.wcy.design_pattern.factory.entity.Milk;
import com.wcy.design_pattern.factory.entity.TeiLunSu;
import com.wcy.design_pattern.factory.entity.YiliMilk;

public class MilkFactory extends AbstractFactory{
    @Override
    Milk getYiliMilk() {
        return new YiliMilk();
    }

    @Override
    Milk getTeiLunSuMilk() {
        return new TeiLunSu();
    }
}
