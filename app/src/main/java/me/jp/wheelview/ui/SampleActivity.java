package me.jp.wheelview.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import me.jp.wheelview.R;
import me.jp.wheelview.ui.fragment.CityFragment;
import me.jp.wheelview.ui.fragment.OtherFragment;
import me.jp.wheelview.ui.fragment.TimeFragment;

/**
 * Created by jiangp on 16/4/20.
 */
public class SampleActivity extends AppCompatActivity {

    private Fragment mCurrFragment;

    private Fragment mCityFragment;
    private Fragment mTimeFragment;
    private Fragment mNumberFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        mCityFragment = new CityFragment();
        mTimeFragment = new TimeFragment();
        mNumberFragment = new OtherFragment();

        //这里直接设置Fragment进入,不知道为什么延时replace就会页面排版错乱
        replaceFragment(R.id.fragment, mNumberFragment);
        replaceFragment(R.id.fragment, mTimeFragment);
        replaceFragment(R.id.fragment, mCityFragment);

        initView();
    }

    private void initView() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                switch (pos) {
                    case 0:
                        replaceFragment(R.id.fragment, mCityFragment);
                        break;
                    case 1:
                        replaceFragment(R.id.fragment, mTimeFragment);
                        break;
                    case 2:
                        replaceFragment(R.id.fragment, mNumberFragment);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    private void replaceFragment(int resView, Fragment targetFragment) {
        if (targetFragment.equals(mCurrFragment)) {
            return;
        }
       FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!targetFragment.isAdded()) {
            transaction.add(resView, targetFragment, targetFragment.getClass().getName());
        }
        if (targetFragment.isHidden()) {
            transaction.show(targetFragment);
        }
        if (mCurrFragment != null && mCurrFragment.isVisible()) {
            transaction.hide(mCurrFragment);
        }
        mCurrFragment = targetFragment;
        transaction.commit();
    }

}
