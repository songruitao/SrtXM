package com.bawei.srtxm.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.bawei.srtxm.R;
import com.bawei.srtxm.fragment.FlFragment;
import com.bawei.srtxm.fragment.GwcFragment;
import com.bawei.srtxm.fragment.PtFragment;
import com.bawei.srtxm.fragment.SyFragment;
import com.bawei.srtxm.fragment.WdFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FragmentTransaction fragmentTransaction;
    private RadioButton syF1, flF1, ptF1,gwcF1,wdF1;
    private SyFragment syfragment;
    private FlFragment flfragment;
    private PtFragment ptfragment;
    private GwcFragment gwcfragment;
    private WdFragment wdfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        //默认状态
        clicksy();
    }
    private void initView() {
        //实例化对象
        syF1 = (RadioButton) findViewById(R.id.sy);
        flF1 = (RadioButton) findViewById(R.id.fl);
        ptF1 = (RadioButton) findViewById(R.id.pt);
        gwcF1 = (RadioButton) findViewById(R.id.gwc);
        wdF1 = (RadioButton) findViewById(R.id.wd);
        //设置监听
        syF1.setOnClickListener(this);
        flF1.setOnClickListener(this);
        ptF1.setOnClickListener(this);
        gwcF1.setOnClickListener(this);
        wdF1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //点击首页
            case R.id.sy:
                clicksy();
                break;
            //点击分类
            case R.id.fl:
                clickfl();
                break;
            //点击拼图
            case R.id.pt:
                clickpt();
                break;
            //点击购物车
            case R.id.gwc:
                clickgwc();
                break;
            //点击我的
            case R.id.wd:
                clickwd();
                break;
        }
    }
    //点击首页
    private void clicksy() {
        //实例化fragment页面
        syfragment = new SyFragment();
        //得到fragment事务管理器
        fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        //替换当前的页面
        fragmentTransaction.replace(R.id.frame_content,syfragment);
        //提交事务管理器
        fragmentTransaction.commit();
        //改变选中状态
        syF1.setSelected(true);
        flF1.setSelected(false);
        ptF1.setSelected(false);
        gwcF1.setSelected(false);
        wdF1.setSelected(false);
    }
    //点击分类
    private void clickfl() {
        //实例化fragment页面
        flfragment = new FlFragment();
        //得到fragment事务管理器
        fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        //替换当前的页面
        fragmentTransaction.replace(R.id.frame_content,flfragment);
        //提交事务管理器
        fragmentTransaction.commit();
        //改变选中状态
        syF1.setSelected(false);
        flF1.setSelected(true);
        ptF1.setSelected(false);
        gwcF1.setSelected(false);
        wdF1.setSelected(false);
    }
    //点击拼图
    private void clickpt() {
        //实例化fragment页面
        ptfragment = new PtFragment();
        //得到fragment事务管理器
        fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        //替换当前的页面
        fragmentTransaction.replace(R.id.frame_content,ptfragment);
        //提交事物管理器
        fragmentTransaction.commit();
        //改变选中状态
        syF1.setSelected(false);
        flF1.setSelected(false);
        ptF1.setSelected(true);
        gwcF1.setSelected(false);
        wdF1.setSelected(false);
    }
    //点击购物车
    private void clickgwc() {
        //实例化fragment页面
        gwcfragment = new GwcFragment();
        //得到fragment的事务管理器
        fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        //替换当前的页面
        fragmentTransaction.replace(R.id.frame_content,gwcfragment);
        //提交事务管理器
        fragmentTransaction.commit();
        //改变选中状态
        syF1.setSelected(false);
        flF1.setSelected(false);
        ptF1.setSelected(false);
        gwcF1.setSelected(true);
        wdF1.setSelected(false);
    }
    //点击我的
    private void clickwd() {
        //实例化fragment页面
        wdfragment = new WdFragment();
        //得到fragment的事务管理器
        fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        //替换当前页面
        fragmentTransaction.replace(R.id.frame_content,wdfragment);
        //提交事务管理器
        fragmentTransaction.commit();
        //改变选中状态
        syF1.setSelected(false);
        flF1.setSelected(false);
        ptF1.setSelected(false);
        gwcF1.setSelected(false);
        wdF1.setSelected(true);
    }
}
