package com.example.e_commerce.adpter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.e_commerce.Fragments.*
import com.example.e_commerce.ui.activity.MainActivity


class FragmentAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int = 7


    override fun createFragment(position: Int): Fragment {
        when (position) {

            0 -> {
                return AllFragments()
            }
            1 -> {
                return MensClothing()
            }
            2 -> {
                return JewelleryFragments()
            }
            3 -> {
                return ElectronicsFragment()
            }
             4 -> {
                 return WomensClothingFragment()
             }
        }
        return AllFragments()
    }

}