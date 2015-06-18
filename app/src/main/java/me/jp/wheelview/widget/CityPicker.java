package me.jp.wheelview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.jp.wheelview.WheelView;

import java.util.ArrayList;

import me.jp.wheelview.R;
import me.jp.wheelview.util.AreaDataUtil;

/**
 * 省市选择器
 * 
 * 将省份和城市放入同一个布局
 * 
 * @author JiangPing
 * 
 */
public class CityPicker extends LinearLayout {
	/** 滑动控件 */
	private WheelView provincePicker;
	private WheelView cityPicker;
	/** 选择监听 */
	private OnSelectingListener onSelectingListener;
	/** 刷新界面 */
	private static final int REFRESH_VIEW = 0x001;
	/** 临时日期 */
	private int tempProvinceIndex = -1;
	private int temCityIndex = -1;

	private String city_code_string;

	private AreaDataUtil mAreaDataUtil;
	private ArrayList<String> mProvinceList = new ArrayList<String>();
	/** 初始省份设置 */
	private final String DEFUALT_PROVINCE = "北京";

	public CityPicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		getAreaInfo();
	}

	public CityPicker(Context context) {
		super(context);
		getAreaInfo();
	}

	private void getAreaInfo() {
		mAreaDataUtil = new AreaDataUtil();
		mProvinceList = mAreaDataUtil.getProvinces();
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		LayoutInflater.from(getContext()).inflate(R.layout.city_picker, this);
		// 获取控件引用
		provincePicker = (WheelView) findViewById(R.id.province);
		cityPicker = (WheelView) findViewById(R.id.city);

		provincePicker.setData(mProvinceList);
		provincePicker.setDefault(0);

		cityPicker.setData(mAreaDataUtil.getCitysByProvince(DEFUALT_PROVINCE));
		cityPicker.setDefault(1);

		provincePicker.setOnSelectListener(new WheelView.OnSelectListener() {
			@Override
			public void endSelect(int id, String text) {
				if (text.equals("") || text == null)
					return;
				if (tempProvinceIndex != id) {
					String selectDay = cityPicker.getSelectedText();
					if (selectDay == null || selectDay.equals(""))
						return;
					// 根据省份，获取Map的城市集合（产生联动效果）
					ArrayList<String> citys = mAreaDataUtil
							.getCitysByProvince(mProvinceList.get(id));
					cityPicker.setData(citys);
					if (citys.size() > 1) {// 大于1个城市，中心显示位置为第2个城市
						cityPicker.setDefault(1);
					} else {// 从第一个城市开始
						cityPicker.setDefault(0);
					}

				}
				tempProvinceIndex = id;
				Message message = new Message();
				message.what = REFRESH_VIEW;
				handler.sendMessage(message);
			}

			@Override
			public void selecting(int id, String text) {
			}
		});

		cityPicker.setOnSelectListener(new WheelView.OnSelectListener() {

			@Override
			public void endSelect(int id, String text) {
				if (text.equals("") || text == null)
					return;
				if (temCityIndex != id) {
					String selectDay = provincePicker.getSelectedText();
					if (selectDay == null || selectDay.equals(""))
						return;
					int lastIndex = Integer.valueOf(cityPicker.getListSize());
					if (id > lastIndex) {
						cityPicker.setDefault(lastIndex - 1);
					}
				}
				temCityIndex = id;
				Message message = new Message();
				message.what = REFRESH_VIEW;
				handler.sendMessage(message);
			}

			@Override
			public void selecting(int id, String text) {

			}
		});

	}

	@SuppressLint("HandlerLeak")
	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case REFRESH_VIEW:
				if (onSelectingListener != null)
					onSelectingListener.selected(true);
				break;
			default:
				break;
			}
		}

	};

	public void setOnSelectingListener(OnSelectingListener onSelectingListener) {
		this.onSelectingListener = onSelectingListener;
	}

	public String getCity_code_string() {
		return city_code_string;
	}

	/**
	 * 获取详细区域（省份+城市）
	 * 
	 * @return
	 */
	public String getDetailArea() {
		String detailArea = provincePicker.getSelectedText()
				+ cityPicker.getSelectedText();
		return detailArea;
	}

	public interface OnSelectingListener {

		public void selected(boolean selected);
	}
}
