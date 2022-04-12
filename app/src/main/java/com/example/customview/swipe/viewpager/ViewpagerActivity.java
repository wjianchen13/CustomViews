
package com.example.customview.swipe.viewpager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.customview.R;

import java.util.List;

public class ViewpagerActivity extends AppCompatActivity {

    private List<String> titleList;
    private ViewPager viewPager;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_viewpager);
        viewPager = (ViewPager)findViewById(R.id.vp_test);
        viewPager.setAdapter(new MessageViewPagerAdapter(getSupportFragmentManager(), titleList));
        viewPager.setOffscreenPageLimit(1);
        tv1 = (TextView)findViewById(R.id.tv_1);
        tv2 = (TextView)findViewById(R.id.tv_2);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
    }

    private static class MessageViewPagerAdapter extends FragmentPagerAdapter {
        private List<String> titleList;

        MessageViewPagerAdapter(FragmentManager fm, List<String> titleList) {
            super(fm);
            this.titleList = titleList;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:  // 消息
                    return MessageFragment.newInstance();

                case 1:  // 好友
                    return MessageFragment.newInstance();

                default:
                    return MessageFragment.newInstance();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position).toUpperCase();
        }

        @Override
        public int getCount() {
            return titleList == null ? 2 : titleList.size();
        }
    }
}
