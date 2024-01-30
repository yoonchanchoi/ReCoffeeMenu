package com.example.recoffeemenu.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPageAdapter(
    private val fragmentList: ArrayList<Fragment>,
    container: AppCompatActivity
) :  FragmentStateAdapter(container.supportFragmentManager,container.lifecycle){
    override fun getItemCount(): Int {
        return fragmentList.count()
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}


//class PageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
//
//    var fragmentList: ArrayList<CoffeeListFragment> = ArrayList()
//
//    override fun getCount(): Int = fragmentList.size
//
//    override fun getItem(position: Int): Fragment = fragmentList[position]
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return fragmentList[position].fragCategory
//    }
//
//    override fun getItemPosition(`object`: Any): Int {
//        return POSITION_NONE
//    }
//
//    //데이터 싱크를 맞추기 위한 mainActivity에서 add를 사용, adapter의 데이터와 다를 경우 adapter에서만 삭제 되어 실제 데이터가 삭제되지 않을 경우 발생 방지
//    fun addItems(fragment: CoffeeListFragment) {
//        fragmentList.add(fragment)
//    }
//}




//class PageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
//
//    var fragmentList: ArrayList<CoffeeListFragment> = ArrayList()
//
//    override fun getCount(): Int = fragmentList.size
//
//    override fun getItem(position: Int): Fragment = fragmentList[position]
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return fragmentList[position].category
//    }
//
//    override fun getItemPosition(`object`: Any): Int {
//        return POSITION_NONE
//    }
//
//    //데이터 싱크를 맞추기 위한 mainActivity에서 add를 사용, adapter의 데이터와 다를 경우 adapter에서만 삭제 되어 실제 데이터가 삭제되지 않을 경우 발생 방지
//    fun addItems(fragment: CoffeeListFragment) {
//        fragmentList.add(fragment)
//    }
//}