##WheelView 滚轮控件

###desc: 
custom view achieve wheel wheel effect. core class only **WheelView.java**. Is easy to use</br>
自定义控件实现滚轮效果。核心类仅 **WheelView.java** ，使用方便，属性较为完整。

###Include the WheelView widget in your layout. 
###在布局中放入WheelView控件

```
<me.jp.wheelview.view.WheelView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:itemNumber="6"
    app:lineColor="#ff5789DC"
    app:maskHight="32dp"
    app:noEmpty="true"
    app:normalTextColor="#777"
    app:normalTextSize="14sp"
    app:selecredTextColor="#ff000000"
    app:selecredTextSize="22sp"
    app:unitHight="50dp"
    />
```

# Attributes

There are several attributes you can set:



| attr 属性          | description 描述 |
|:---				 |:---|
| lineColor  	     | divider line color 分割线颜色 |
| lineHeight  	     | divider line height 分割线高度 |
| itemNumber	 	 | wheelview show item count 此wheelView显示item的个数 |
| maskHight 		 | mask height 蒙版高度（normalText的位置） |
| noEmpty 			 | if set true select area can't be null(empty),or could be empty 设置true则选中不能为空，否则可以是空 |
| normalTextColor 	 | unSelected Text color 未选中文本颜色 |
| normalTextSize 	 | unSelected Text size 未选中文本字体大小 |
| selecredTextColor | selected Text color 选中文本颜色 |
| normalTextSize 	 | selected Text size 选中文本字体大小 |
| unitHight 		 | item unit height 每个item单元的高度 |

#Method
###setData(ArrayList<String> data)
set WheelView data</br> 
设置WheelView的数据

### resetData(ArrayList<String> data) 
reset WheelView data ,if you has setData</br>
重置WheelView的数据，如果已经设置过的话

###int getSelected()
get selected item index</br>
获取选中项的index

###String getSelectedText()
get selected item text</br>
获取选中项的文本信息

###boolean isScrolling
is WheelView is scrolling</br>
获取WheelView是否在滚动中

###boolean isEnable()
is WheelView is enable</br>
获取wheelView是否可用

###void setEnable(boolean isEnable)  
set WheelView enable</br>
设置WheelView是否可用

###void setDefault(int index)
set default selected index</br>
设置默认选中项的index
 
###int getListSize() 
get WheelView item count</br>
获取WheelView的item项个数

###String getItemText(int index)
get the text by index </br>
获取index位置上的文本数据

###void setOnSelectListener(OnSelectListener onSelectListener)
set listener on WheelView that can get info when WheelView is scrolling or end scroll.</br>
对WheelView设置监听，在华东过程或者滑动停止 返回数据信息。

