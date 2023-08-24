# CustomControl
 自定义控件学习

目前使用自定义view完成了

1.一个可以检测右滑动，自动回调的自定义 view 控件，作为 recyclerView 的子 view，右滑可以直接删除该子项，回调功能使用 lambda 函数功能实现。

实现思路: 

- 让控件继承子LinearLayout,使其能够成为`recyclerView` 的子 `view`
- 创建一个`(() -> Unit)?`类型的变量`onSwipeDeleteListener`,在`recycleview`的`adapter`中定义并传入
- 创建一个GestureDetector对象来检测右滑手势,当用户右滑之后触发回调函数`onSwipeDeleteListener?.invoke()`
- 重写`onTouchEvent`方法,调用`parent?.requestDisallowInterceptTouchEvent(true)`阻止`recycleview`拦截事件,并加入`onSwipeDeleteListener`处理手势

2.一个展示数据的统计图控件，支持接收一个二维数组然后展示数据（可选条形统计图和折线图的形式），数据改变时调用该控件的刷新方法更新数据，控件能够使用动画的方式改变展示的数据

实现思路

- 创建一个 `ValueAnimator` 对象,设置动画的更新监听器
- 动画每次更新，就执行invalidate()调用`onDraw()`，重绘当前视图
- 重写`onDraw`,根据`animation.animatedFraction`(动画进行的百分比)来绘制相应的条形/折线统计图

apk路径:CustomControl\app\build\outputs\apk\debug

好像也没有很多可以说的,重要的是原理的学习

PS:因为go那边比较忙，compose 部分没有完成
