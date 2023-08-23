package com.example.customcontrol

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customcontrol.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 初始化二维数组
        val numRows = 5
        val numCols = 3
        val dataArray = Array(numRows) { FloatArray(numCols) }
        for (i in 0 until numRows) {
            for (j in 0 until numCols) {
                dataArray[i][j] = (0..100).random().toFloat() // 生成 0 到 100 的随机浮点数
            }
        }
        binding.barChart.setChartData(dataArray, StatisticChartView.BAR_CHART)
    }
}