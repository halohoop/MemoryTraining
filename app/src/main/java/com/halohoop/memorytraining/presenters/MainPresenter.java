package com.halohoop.memorytraining.presenters;

import com.halohoop.memorytraining.models.IMainModel;
import com.halohoop.memorytraining.models.MainModel;
import com.halohoop.memorytraining.views.activities.IMainActivity;

import java.util.List;

import dev.dworks.libs.astickyheader.SimpleSectionedGridAdapter;

/**
 * Created by Pooholah on 2017/3/31.
 */

public class MainPresenter implements IMainPresenter {
    private IMainActivity mIMainActivity;
    private IMainModel mMainModel;

    public MainPresenter(IMainActivity iMainActivity) {
        this.mIMainActivity = iMainActivity;
        mMainModel = new MainModel();
    }

    @Override
    public int getCodingListCount() {
        return mMainModel.getCodingCount();
    }

    @Override
    public int getActualListCount() {
        return mMainModel.getActualCount();
    }

    @Override
    public Object getCodingItem(int i) {
        return mMainModel.getCodingItem(i);
    }

    @Override
    public Object getActualItem(int i) {
        return mMainModel.getActualItem(i);
    }

    @Override
    public List<SimpleSectionedGridAdapter.Section> getCodingGroups() {
        return mMainModel.getCodingGroups();
    }

    @Override
    public List<SimpleSectionedGridAdapter.Section> getActualGroups() {
        return mMainModel.getActualGroups();
    }

    @Override
    public int getCodingText(int i) {
        return mMainModel.getCodingText(i);
    }

    @Override
    public int getActualText(int i) {
        return mMainModel.getActualText(i);
    }

    @Override
    public void onCodingItemClick(int position) {
        switch (position) {
            case 0://110数字编码
                break;
            case 1://地点桩
                break;
        }
    }

    @Override
    public void onActualItemClick(int position) {
        switch (position) {
            case 0://三十六计
                break;
            case 1://二十四节气
                break;
            case 2://圆周率
                break;
        }
    }

}
