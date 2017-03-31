package com.halohoop.memorytraining.models;

import com.halohoop.memorytraining.R;

/**
 * Created by Pooholah on 2017/3/31.
 */

public interface IActualModel {
    public static int[] ITEMS_GROUP1 = {R.string.actual_item1_group1, R.string.actual_item2_group1};

    int getItemText(int position);
}
