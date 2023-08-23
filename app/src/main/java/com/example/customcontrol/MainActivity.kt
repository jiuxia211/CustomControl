package com.example.customcontrol

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customcontrol.databinding.ActivityMainBinding
import com.example.recycleview.Tails

private val tailsList = ArrayList<Tails>()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initTails()
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = TailsAdapter(tailsList)
        binding.recyclerView.adapter = adapter
        binding.nextButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private fun initTails() {
            tailsList.apply {
                add(Tails("生气", R.drawable.angry))
                add(Tails("困困", R.drawable.sleepy))
                add(Tails("哭哭", R.drawable.cry))
                add(Tails("抱抱", R.drawable.hug))
                add(Tails("期待", R.drawable.expect))
                add(Tails("吃瓜", R.drawable.eatwatermelon))
                add(Tails("点赞", R.drawable.like))
                add(Tails("捏脸", R.drawable.pinchface))
                add(Tails("乖巧", R.drawable.lovely))
                add(Tails("宁静", R.drawable.quiet))
                add(Tails("沉思", R.drawable.ruminate))
                add(Tails("大佬喝茶", R.drawable.tea))
                add(Tails("不高兴", R.drawable.unhappy))
                add(Tails("惊讶", R.drawable.surprise))
                add(Tails("空洞", R.drawable.voidx))
            }

        }
    }
}