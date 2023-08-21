package com.example.customcontrol

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.LinearLayout
import kotlin.math.abs

class SwipeToDeleteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val gestureDetector = GestureDetector(context, SwipeGestureListener())
    private var onSwipeDeleteListener: (() -> Unit)? = null

    override fun onTouchEvent(event: MotionEvent): Boolean {
        //阻止recycleview拦截事件
        parent?.requestDisallowInterceptTouchEvent(true)
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
    }

    private inner class SwipeGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {


            val deltaX = e2.x - e1!!.x
            val deltaY = e2.y - e1.y
            if (abs(deltaX) > abs(deltaY) && abs(velocityX) > 2000) {
                if (deltaX > 0) {
                    animate().translationX(width.toFloat()).alpha(0f).setDuration(300)
                        .withEndAction {
                            onSwipeDeleteListener?.invoke()
                        }
                    Log.d("zz", "右滑一次")
                }
            }

            return super.onFling(e1, e2, velocityX, velocityY)
        }

        //为啥这个方法返回true滑动才生效呢?
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

    }

    fun setOnSwipeDeleteListener(listener: () -> Unit) {
        onSwipeDeleteListener = listener
    }

}
