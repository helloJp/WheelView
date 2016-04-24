package me.jp.wheelview.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import me.jp.wheelview.R;

/**
 * 全国省份城市操作类
 *
 * @author JiangPing
 */
public class AreaDataUtil {

    /**
     * 所有的省市String
     */
    public String AREAS_DATA;
    /**
     * 一个省份对应多个城市
     */
    private String[] single_province_city;
    /**
     * 全国省市Map key:省份 |Value:城市集合
     */
    private HashMap<String, List<String>> mCityMap = new HashMap<>();

    public AreaDataUtil(Context context) {
        AREAS_DATA = context.getResources().getString(R.string.province_and_city);
        splitProvince();
        getAllCityMap();
    }

    /**
     * 将省份和对应城市分割出来
     * <p/>
     * 得到：宁夏!!银川!石嘴山!吴忠!固原
     */
    private void splitProvince() {
        single_province_city = AREAS_DATA.split("!!!");
    }

    /**
     * 获得全国省份的列表
     *
     * @return
     */
    public ArrayList<String> getProvinces() {
        ArrayList<String> provinceList = new ArrayList<>();
        for (String str : single_province_city) {
            String province = str.split("!!")[0];
            provinceList.add(province);
        }
        return provinceList;
    }

    /**
     * 根据省份获取城市列表
     *
     * @return
     */
    private void getAllCityMap() {
        for (String str : single_province_city) {
            // 得到省份
            String province = str.split("!!")[0];
            // 得到当前省份对应的城市
            String city = str.split("!!")[1];
            // 分离城市放入集合
            List<String> cityList = Arrays.asList(city.split("!"));
            // 省份和城市放入Map中
            mCityMap.put(province, cityList);
        }
    }

    /**
     * 根据省份查找对应的城市列表
     *
     * @return 城市集合
     */
    public ArrayList<String> getCityByProvince(String provinceStr) {

        List<String> list = mCityMap.get(provinceStr);
        ArrayList<String> arrList = new ArrayList<>();
        for (String city : list) {
            arrList.add(city);
        }
        return arrList;
    }

}
