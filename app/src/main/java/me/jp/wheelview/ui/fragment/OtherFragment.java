package me.jp.wheelview.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jp.wheelview.WheelView;

import java.util.ArrayList;

import me.jp.wheelview.R;

/**
 * Created by jiangp on 16/4/20.
 */
public class OtherFragment extends Fragment {

    private View mRootView;
    WheelView mWheelView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_number, null);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        mWheelView = (WheelView) mRootView.findViewById(R.id.wheelView);
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
            mWheelView.refreshData(getData2());
            mWheelView.setDefault(1);
        } else {
            mWheelView.refreshData(getData1());
        }
        mIsData1 = !mIsData1;
    }

    private ArrayList<String> getData1() {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            data.add(String.valueOf(((char) (97 + i))));
        }
        return data;
    }

    private ArrayList<String> getData2() {
        ArrayList<String> data = new ArrayList<>();
        data.add("A");
        data.add("B");
        data.add("C");
        return data;
    }

}
