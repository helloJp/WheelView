package me.jp.wheelview.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import me.jp.wheelview.R;
import me.jp.wheelview.widget.CityPickerLayout;
import me.jp.wheelview.widget.TimePickerLayout;

/**
 * Created by jiangp on 16/4/20.
 */
public class TimeFragment extends Fragment implements View.OnClickListener {

    private View mRootView;
    private TimePickerLayout mTimePickerLayout;
    private TextView mSelectedTv;
    private Button mShowSelectedBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_time, null);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTimePickerLayout = (TimePickerLayout) mRootView.findViewById(R.id.time_picker);
        mSelectedTv = (TextView) mRootView.findViewById(R.id.select_tv);
        mShowSelectedBtn = (Button) mRootView.findViewById(R.id.show_select_btn);
        mShowSelectedBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_select_btn:

                mSelectedTv.setText(new StringBuffer().append(mTimePickerLayout.getYear()).append("年 ")
                        .append(mTimePickerLayout.getMonth()).append("月 ")
                        .append(mTimePickerLayout.getDay()).append("日"));
                break;
        }
    }
}
