package me.jp.wheelview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jp.wheelview.WheelView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    WheelView mWheelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWheelView = (WheelView) findViewById(R.id.wheelView);
        mWheelView.setData(getData1());
    }

    private boolean mIsData1 = true;

    /**
     * 重置数据
     *
     * @param view
     */
    public void resetData(View view) {
        if (mIsData1) {
            mWheelView.resetData(getData2());
            mWheelView.setDefault(1);
        } else {
            mWheelView.resetData(getData1());
        }
        mIsData1 = !mIsData1;
    }

    private ArrayList<String> getData1() {
        ArrayList<String> mDatas = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            mDatas.add(String.valueOf(((char) (97 + i))));
        }
        return mDatas;
    }

    private ArrayList<String> getData2() {
        ArrayList<String> mDatas = new ArrayList<>();
        mDatas.add("A");
        mDatas.add("B");
        mDatas.add("C");
        return mDatas;
    }


}
