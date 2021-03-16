package com.example.viewpagerqr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager viewPager1;
    MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs=findViewById(R.id.tabs);
        viewPager1=findViewById(R.id.viewPager1);
        tabs.addTab(tabs.newTab().setText("홈"));
        tabs.addTab(tabs.newTab().setText("배송"));
        tabs.addTab(tabs.newTab().setText("반품"));
        tabs.addTab(tabs.newTab().setText("오류"));
        tabs.setTabGravity(tabs.GRAVITY_FILL);
        myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),4);
        viewPager1.setAdapter(myPagerAdapter);
        //탭메뉴 클릭하면 해당 프래그먼트로 변경>>싱크화
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager1));
        //뷰페이저를 밀면 해당 탭메뉴로 이동
        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
    }
}