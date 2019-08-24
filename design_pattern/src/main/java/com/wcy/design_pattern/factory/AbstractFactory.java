package com.wcy.design_pattern.factory;

import com.wcy.design_pattern.factory.entity.Milk;

public abstract class AbstractFactory {

    abstract Milk getYiliMilk();

    abstract Milk getTeiLunSuMilk();
}
