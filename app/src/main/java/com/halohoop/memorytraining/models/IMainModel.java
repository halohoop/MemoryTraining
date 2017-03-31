package com.halohoop.memorytraining.models;

import com.halohoop.memorytraining.R;

import java.util.List;

import dev.dworks.libs.astickyheader.SimpleSectionedGridAdapter;

/**
 * Created by Pooholah on 2017/3/31.
 */

public interface IMainModel {
    public static int[] CODING_GROUP = {R.string.coding_group1, R.string.coding_group2};
    public static int[] CODING_ITEMS = {R.string.coding_item1_group1, R.string.coding_item2_group2};
    public static int[] ACTUAL_GROUP = {R.string.actual_group1, R.string.actual_group2,
            R.string.actual_group3, R.string.actual_group4};
    public static int[] ACTUAL_ITEMS = {
            R.string.actual_item1_group1,
            R.string.actual_item2_group1,
            R.string.actual_item3_group2};

    int getCodingCount();

    int getActualCount();

    List<SimpleSectionedGridAdapter.Section> getCodingGroups();

    Object getCodingItem(int i);

    Object getActualItem(int i);

    List<SimpleSectionedGridAdapter.Section> getActualGroups();

    int getCodingText(int i);

    int getActualText(int i);
}
