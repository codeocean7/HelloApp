package com.zealsoft.helloapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.zealsoft.helloapp.TabFragments.CallFrag
import com.zealsoft.helloapp.TabFragments.ChatFrag
import com.zealsoft.helloapp.TabFragments.StatusFrag
import java.util.*

class MyTabActivity : AppCompatActivity() {

    var mViewPager: ViewPager? = null
    var mTabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tab_activity_layout)

        mViewPager=findViewById(R.id.viewpager_id)
        mTabLayout=findViewById(R.id.tablelayout)

        val mViewPagerAdapter=MyViewPagerAdapter(supportFragmentManager)
        mViewPagerAdapter.addFragment(ChatFrag(),"CHAT")
        mViewPagerAdapter.addFragment(StatusFrag(),"STATUS")
        mViewPagerAdapter.addFragment(CallFrag(),"CALL")

        mViewPager!!.setAdapter(mViewPagerAdapter)
        mTabLayout!!.setupWithViewPager(mViewPager)

    }

    class MyViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){

        val listFragment: MutableList<Fragment> = ArrayList()
        val listTitles: MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return listFragment[position]
        }

        override fun getCount(): Int {
            return listFragment.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return listTitles[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            listFragment.add(fragment)
            listTitles.add(title)
        }


    }
}