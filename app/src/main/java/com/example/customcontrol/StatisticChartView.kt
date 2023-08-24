package com.example.customcontrol

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator

class StatisticChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    companion object {
        const val BAR_CHART = 0
        const val LINE_CHART = 1
    }

    // 数据更新动画
    private val dataAnimator: ValueAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
        duration = 1000
        // 设置先加速后减速
        interpolator = AccelerateDecelerateInterpolator()
        addUpdateListener { animation ->
            animProgress = animation.animatedFraction
            // 在动画更新监听中根据 fraction 来更新数据绘制状态
            invalidate()
        }
    }
    private val paint = Paint().apply {
        //画线模式 默认为填充模式
        style = Paint.Style.STROKE
        textSize = 18f
    }
    private var data: Array<FloatArray>? = null // 二维数组存储数据
    private var chartFlag: Int = 0
    private var animProgress = 0f // 动画进度
    private var maxDataValue = 0f
    fun setChartData(data: Array<FloatArray>, chartFlag: Int) {
        maxDataValue = calculateMaxDataValue(data)
        this.data = data
        this.chartFlag = chartFlag
        dataAnimator.start()
    }

    // 计算数据最大值，以此确定条形高度
    private fun calculateMaxDataValue(data: Array<FloatArray>): Float {
        var max = 0f
        for (row in data) {
            for (value in row) {
                if (value > max) {
                    max = value
                }
            }
        }
        //留一些空隙用来写数据
        return max + 10
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        when (chartFlag) {
            BAR_CHART -> {
                data?.let {
                    //计算宽度
                    val numRows = it.size
                    val numCols = it[0].size
                    val barWidth = width.toFloat() / (numCols * numRows + numRows - 1)
                    Log.d("zz", (numCols * numRows + numRows - 1).toString())
                    var startX = 0f
                    it.forEach { dataArray ->
                        dataArray.forEach { value ->
                            val barHeight = value / maxDataValue * height * animProgress
                            canvas.drawRect(
                                startX,
                                height - barHeight,
                                startX + barWidth,
                                height.toFloat(),
                                paint
                            )
                            canvas.drawText(
                                value.toString(),
                                startX,
                                height - barHeight,
                                paint
                            )
                            startX += barWidth
                        }
                        // 条形间的间隔
                        startX += barWidth
                    }
                }

            }
            LINE_CHART -> {
                data?.let {
                    //计算宽度
                    val barWidth = width.toFloat() / (it[0].size + 1)
                    it.forEach { dataArray ->
                        var startX = barWidth
                        for (i in 0 until (dataArray.size - 1)) {
                            canvas.drawLine(
                                startX,
                                height - (dataArray[i] / maxDataValue * height * animProgress),
                                (startX + barWidth) * animProgress,
                                height - (dataArray[i + 1] / maxDataValue * height * animProgress),
                                paint
                            )
                            canvas.drawText(
                                dataArray[i].toString(),
                                startX,
                                height - (dataArray[i] / maxDataValue * height * animProgress),
                                paint
                            )
                            startX += barWidth
                        }
                        //补充最后一个点的数据
                        canvas.drawText(
                            dataArray[dataArray.size - 1].toString(),
                            startX,
                            height - (dataArray[dataArray.size - 1] / maxDataValue * height * animProgress),
                            paint
                        )
                    }
                }
            }
        }
    }
}