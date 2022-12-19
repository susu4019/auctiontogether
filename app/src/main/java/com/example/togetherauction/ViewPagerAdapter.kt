package com.example.togetherauction

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter (fragment : FragmentActivity, position: Int, mg : String) : FragmentStateAdapter(fragment){

    var pos = position
    var mg = mg

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Fragment1(pos,mg)
            1 -> Fragment2(pos,mg)
            else -> Fragment1(pos,mg)
        }
    }
}