package me.jp.wheelview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.ArrayList;

import me.jp.wheelview.R;
import me.jp.wheelview.view.WheelView;

/**
 * Created by JiangPing on 2015/6/17.
 */
public class TimePicker extends LinearLayout {
    private WheelView mWheelYear;
    private WheelView mWheelMonth;
    private WheelView mWheelDay;

    public TimePicker(Context context) {
        this(context, null);
    }

    public TimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.time_picker, this);
        mWheelYear = (WheelView) findViewById(R.id.year);
        mWheelMonth = (WheelView) findViewById(R.id.month);
        mWheelDay = (WheelView) findViewById(R.id.day);

        mWheelYear.setData(getYearData());
        mWheelMonth.setData(getMonthData());
        mWheelDay.setData(getDayData());
    }


    /**
     * get selected year
     */
    public String getYearText() {
        return mWheelYear.getSelectedText();
    }

    /**
     * get selected year
     */
    public int getYearIndex() {
        return mWheelYear.getSelected();
    }

    /**
     * get selected Month
     */
    public String getMonthText() {
        return mWheelMonth.getSelectedText();
    }

    /**
     * get selected Month
     */
    public int getMonthIndex() {
        return mWheelMonth.getSelected();
    }

    /**
     * get selected year
     */
    public String getDayText() {
        return mWheelDay.getSelectedText();
    }

    /**
     * get selected Day
     */
    public int getDayIndex() {
        return mWheelDay.getSelected();
    }



    private ArrayList<String> getYearData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 2015; i > 2000; i--) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    private ArrayList<String> getMonthData() {
        //这里忽略闰年、平年、月份大小 -_-|||
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    private ArrayList<String> getDayData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }
}
