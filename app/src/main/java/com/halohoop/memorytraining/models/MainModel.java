package com.halohoop.memorytraining.models;

import com.halohoop.memorytraining.managers.MainApplicaton;

import java.util.ArrayList;
import java.util.List;

import dev.dworks.libs.astickyheader.SimpleSectionedGridAdapter;

/**
 * Created by Pooholah on 2017/3/31.
 */

public class MainModel implements IMainModel {

    private List<SimpleSectionedGridAdapter.Section> mCodingSections;
    private List<SimpleSectionedGridAdapter.Section> mActualSections;
    private Integer[] mCodingHeaderPositions = {0, 1};
    private Integer[] mActualHeaderPositions = {0, 2};

    public MainModel() {
        mCodingSections = new ArrayList<>();
        for (int i = 0; i < mCodingHeaderPositions.length; i++) {
            mCodingSections.add(new SimpleSectionedGridAdapter.Section(mCodingHeaderPositions[i],
                    MainApplicaton.CONTEXT.getResources().getString(CODING_GROUP[i])));
        }
        mActualSections = new ArrayList<>();
        for (int i = 0; i < mActualHeaderPositions.length; i++) {
            mActualSections.add(new SimpleSectionedGridAdapter.Section(mActualHeaderPositions[i],
                    MainApplicaton.CONTEXT.getResources().getString(ACTUAL_GROUP[i])));
        }
    }

    @Override
    public int getCodingCount() {
        return CODING_ITEMS.length;
    }

    @Override
    public int getActualCount() {
        return ACTUAL_ITEMS.length;
    }

    @Override
    public List<SimpleSectionedGridAdapter.Section> getCodingGroups() {
        return mCodingSections;
    }

    @Override
    public Object getCodingItem(int i) {
        return mCodingSections.get(i);
    }

    @Override
    public Object getActualItem(int i) {
        return mActualSections.get(i);
    }

    @Override
    public List<SimpleSectionedGridAdapter.Section> getActualGroups() {
        return mActualSections;
    }

    @Override
    public int getCodingText(int i) {
        return CODING_ITEMS[i];
    }

    @Override
    public int getActualText(int i) {
        return ACTUAL_ITEMS[i];
    }
}
