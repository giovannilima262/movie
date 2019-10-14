package com.e.themovieapp.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.e.themovieapp.R
import com.e.themovieapp.enums.GenreEnum

private val TAB_TITLES = GenreEnum.values()

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getText(TAB_TITLES[position].nameRString)
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}