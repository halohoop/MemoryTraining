package com.halohoop.memorytraining.presenters;

import java.util.List;

import dev.dworks.libs.astickyheader.SimpleSectionedGridAdapter;

/**
 * Created by Pooholah on 2017/3/31.
 */

public interface IMainPresenter {
    int getCodingListCount();
    int getActualListCount();

    Object getCodingItem(int i);
    Object getActualItem(int i);

    List<SimpleSectionedGridAdapter.Section> getCodingGroups();

    List<SimpleSectionedGridAdapter.Section>  getActualGroups();

    int getCodingText(int i);

    int getActualText(int i);

    void onCodingItemClick(int position);

    void onActualItemClick(int position);
}
