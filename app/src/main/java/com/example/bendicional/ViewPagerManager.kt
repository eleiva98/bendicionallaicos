package com.example.bendicional
import androidx.viewpager.widget.ViewPager

class ViewPagerManager(private val viewPager: ViewPager) {

    //private lateinit var pagerAdapter: CustomPagerAdapter;


    fun setCurrentItem(position: Int) {
        viewPager.currentItem = position
    }
}