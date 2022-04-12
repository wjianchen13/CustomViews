
package com.example.customview.swipe.recyclerview;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.customview.R;
import com.example.customview.swipe.bean.SwipeBean;
import com.example.customview.swipe.view.SwipeMenuLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mSmartRecyclerview;
    private List<SwipeBean> mDatas;
    private RecycleViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);
        initDatas();
        mSmartRecyclerview = (RecyclerView) findViewById(R.id.smart_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mSmartRecyclerview.setLayoutManager(layoutManager);


        mAdapter = new RecycleViewAdapter(R.layout.item_swipe_message_main, mDatas);
        mAdapter.setmOnSwipeListener(new RecycleViewAdapter.ISwipeMenuListener() {
            @Override
            public void onDel(int pos) {
                if (pos >= 0 && pos < mDatas.size()) {
                    Toast.makeText(RecyclerViewActivity.this, "删除:" + pos, Toast.LENGTH_SHORT).show();
                    mDatas.remove(pos);
//                    mAdapter.notifyItemRemoved(pos);//推荐用这个
                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((SwipeMenuLayout) holder.itemView).quickClose();
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTop(int pos) {
            }

            @Override
            public void onClick(BaseQuickAdapter adapter, View v, int position) {
                if(adapter != null) {
                    Toast.makeText(RecyclerViewActivity.this, ((SwipeBean)(adapter.getData().get(position))).name, Toast.LENGTH_SHORT).show();
                }
            }
        });
        mSmartRecyclerview.setAdapter(mAdapter);
        mSmartRecyclerview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    SwipeMenuLayout viewCache = SwipeMenuLayout.getViewCache();
                    if (null != viewCache) {
                        viewCache.smoothClose();
                    }

                }
                return false;
            }
        });
    }

    public long StringtoLong(String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mDatas.add(new SwipeBean("" + i));
        }
    }
}
