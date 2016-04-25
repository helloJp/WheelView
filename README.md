#WheelView 滚轮控件
**WheelView仿IOS的滑动选择器**

* 继承自View，绘制所有的显示。
* 监听手势来移动（根据新坐标重新绘制）itemObject。
* 单个控件（一个类实现了滚轮效果），拓展性较强。

> 这里说明一下的是WheelView只能实现一个滚轮，联动效果 可通过多个WheelView的组合使用（issues里面有人反馈这个问题😂）

###效果图：
* CityPicker

![cityPicker](http://7xtd3c.com2.z0.glb.clouddn.com/wheelView-shot01.gif)

* TimePicker

![timePicker](http://7xtd3c.com2.z0.glb.clouddn.com/wheelView-shot02.gif)


###坐标图

下图为控件中心位置的itemObject居中时的简易坐标图。

![item_coordinate](http://7xtd3c.com2.z0.glb.clouddn.com/wheelView-chart_wheelView_item_coordinate.png)


### 在布局中放入WheelView控件

```
<me.jp.wheelview.view.WheelView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:itemNumber="6"
    app:lineColor="#ff5789DC"
    app:maskHeight="32dp"
    app:noEmpty="true"
    app:normalTextColor="#777"
    app:normalTextSize="14sp"
    app:selectedTextColor="#ff000000"
    app:selectedTextSize="22sp"
    app:unitHeight="50dp"
    />
```

# Attributes

There are several attributes you can set:

| attr 属性          | description 描述 |
|:---				 |:---|
| lineColor  	     | divider line color 分割线颜色 |
| lineHeight  	     | divider line height 分割线高度 |
| itemNumber	 	 | wheelview show item count 此wheelView显示item的个数 |
| maskHeight 		 | mask height 蒙版高度（normalText的位置） |
| noEmpty 			 | if set true select area can't be null(empty),or could be empty 设置true则选中不能为空，否则可以是空 |
| normalTextColor 	 | unSelected Text color 未选中文本颜色 |
| normalTextSize 	 | unSelected Text size 未选中文本字体大小 |
| selectedTextColor | selected Text color 选中文本颜色 |
| selectedTextSize 	 | selected Text size 选中文本字体大小 |
| unitHeight 		 | item unit height 每个item单元的高度 |

#Method
###1. setData(ArrayList<String> data)
set WheelView data</br> 
设置WheelView的数据

###2. refreshData(ArrayList<String> data) 
**refresh** WheelView data ,and draw again</br>
**刷新** WheelView的数据，并重绘

###3. int getSelected()
get selected item index</br>
获取选中项的index

###4. String getSelectedText()
get selected item text</br>
获取选中项的文本信息

###5. boolean isScrolling
is WheelView is scrolling</br>
获取WheelView是否在滚动中

###6. boolean isEnable()
is WheelView is enable</br>
获取wheelView是否可用

###7. void setEnable(boolean isEnable)  
set WheelView enable</br>
设置WheelView是否可用

###8. void setDefault(int index)
set **default selected index**</br>
设置**默认选中项的index**
 
###9. int getListSize() 
get WheelView item count</br>
获取WheelView的item项个数

###10. String getItemText(int index)
get the text by index </br>
获取index位置上的文本数据

###11. void setOnSelectListener(OnSelectListener onSelectListener)
set listener on WheelView that can get info when WheelView is **scrolling** or **stop scroll**.</br>
对WheelView**设置监听**，在 **滑动过程** 或者 **滑动停止** 返回数据信息。
