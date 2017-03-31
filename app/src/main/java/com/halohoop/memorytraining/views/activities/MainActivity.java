package com.halohoop.memorytraining.views.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.halohoop.bounceprogressbar.views.BounceProgressBar;
import com.halohoop.memorytraining.R;
import com.halohoop.memorytraining.presenters.IMainPresenter;
import com.halohoop.memorytraining.presenters.MainPresenter;

import dev.dworks.libs.astickyheader.SimpleSectionedGridAdapter;

public class MainActivity extends AppCompatActivity implements IMainActivity,
        AdapterView.OnItemClickListener {

    private ViewPager mVpMain;
    private BounceProgressBar mBpb;

    private LayoutInflater mInflater;
    private IMainPresenter mMainPresenter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mVpMain.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mVpMain.setCurrentItem(1);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainPresenter = new MainPresenter(this);
        mVpMain = (ViewPager) findViewById(R.id.vp_main);
        mBpb = (BounceProgressBar) findViewById(R.id.bpb);
        mVpMain.setAdapter(new ViewPagerAdapter());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mInflater = LayoutInflater.from(this);
    }

    @Override
    public void showItem(int position) {

    }

    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = null;
            switch (position) {
                case 0:
                    view = mInflater.inflate(R.layout.coding_page, null);
                    GridView gridViewCoding = (GridView) view.findViewById(R.id.grid_coding);
                    CodingAdapter codingAdapter = new CodingAdapter();
                    SimpleSectionedGridAdapter simpleSectionedGridAdapter
                            = new SimpleSectionedGridAdapter(MainActivity.this, codingAdapter,
                            R.layout.grid_item_header, R.id.header_layout, R.id.header);
                    simpleSectionedGridAdapter.setGridView(gridViewCoding);
                    simpleSectionedGridAdapter.setSections(
                            mMainPresenter.getCodingGroups()
                                    .toArray(new SimpleSectionedGridAdapter.Section[0]));
                    gridViewCoding.setAdapter(simpleSectionedGridAdapter);
                    gridViewCoding.setOnItemClickListener(MainActivity.this);
                    break;
                case 1:
                    view = mInflater.inflate(R.layout.actual_page, null);
                    GridView gridViewActual = (GridView) view.findViewById(R.id.grid_actual);
                    ActualAdapter actualAdapter = new ActualAdapter();
                    SimpleSectionedGridAdapter simpleSectionedGridAdapter2
                            = new SimpleSectionedGridAdapter(MainActivity.this, actualAdapter,
                            R.layout.grid_item_header, R.id.header_layout, R.id.header);
                    simpleSectionedGridAdapter2.setGridView(gridViewActual);
                    simpleSectionedGridAdapter2.setSections(
                            mMainPresenter.getActualGroups()
                                    .toArray(new SimpleSectionedGridAdapter.Section[0]));
                    gridViewActual.setAdapter(simpleSectionedGridAdapter2);
                    gridViewActual.setOnItemClickListener(MainActivity.this);
                    break;
            }
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        int currentItem = mVpMain.getCurrentItem();
        switch (currentItem) {
            case 0://编码训练
                mMainPresenter.onCodingItemClick(position);
                break;
            case 1://实战训练
                mMainPresenter.onActualItemClick(position);
                break;
        }
    }

    class CodingAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mMainPresenter.getCodingListCount();
        }

        @Override
        public Object getItem(int i) {
            return mMainPresenter.getCodingItem(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewItem;
            ImageView iv;
            TextView tv;
            if (view == null) {
                viewItem = mInflater.inflate(R.layout.grid_item, null);
            } else {
                viewItem = view;
            }
            iv = (ImageView) viewItem.findViewById(R.id.iv_rcv);
            tv = (TextView) viewItem.findViewById(R.id.tv_rcv);
            iv.setImageResource(R.mipmap.ic_launcher);
            tv.setText(mMainPresenter.getCodingText(i));
            return viewItem;
        }
    }

    class ActualAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mMainPresenter.getActualListCount();
        }

        @Override
        public Object getItem(int i) {
            return mMainPresenter.getActualItem(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewItem;
            ImageView iv;
            TextView tv;
            if (view == null) {
                viewItem = mInflater.inflate(R.layout.grid_item, null);
            } else {
                viewItem = view;
            }
            iv = (ImageView) viewItem.findViewById(R.id.iv_rcv);
            tv = (TextView) viewItem.findViewById(R.id.tv_rcv);
            iv.setImageResource(R.mipmap.ic_launcher);
            tv.setText(mMainPresenter.getActualText(i));
            return viewItem;
        }
    }


}
