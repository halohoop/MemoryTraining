package com.halohoop.memorytraining.models;

/**
 * Created by Pooholah on 2017/3/31.
 */

public class ActualModels implements IActualModel{
    @Override
    public int getItemText(int position) {
        return ITEMS_GROUP1[position];
    }
}
