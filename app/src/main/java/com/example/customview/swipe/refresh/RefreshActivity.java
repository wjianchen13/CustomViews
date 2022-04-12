
package com.example.customview.swipe.refresh;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customview.R;
import com.example.customview.swipe.bean.SwipeBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class RefreshActivity extends AppCompatActivity {

    private SmartRefreshLayout mSmartRefreshLayout;
    private RecyclerView mSmartRecyclerview;
    private List<SwipeBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);
        mSmartRefreshLayout = (SmartRefreshLayout) findViewById(R.id.smart_refreshlayout);
        mSmartRefreshLayout.setEnableLoadmore(true);
//        mSmartRefreshLayout.setEnableLoadmore(false);
//        mSmartRefreshLayout.setHeaderMaxDragRate(5);
//        mSmartRefreshLayout.setReboundDuration(3000);//回弹动画时长（毫秒）
//        mSmartRefreshLayout.setEnablePureScrollMode(true);
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {

            }
        });
        initDatas();
        mSmartRecyclerview = (RecyclerView) findViewById(R.id.smart_recyclerview);

        // 创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // 默认是Vertical，可以不写
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // 设置布局管理器
        mSmartRecyclerview.setLayoutManager(layoutManager);
        adapter = new RefreshAdapter(R.layout.item_swipe_message_main, mDatas);
        mSmartRecyclerview.setAdapter(adapter);
    }

    private RefreshAdapter adapter;

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mDatas.add(new SwipeBean("" + i));
        }
    }
}
