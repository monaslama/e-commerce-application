package com.example.mona.e_commerce_app_v1;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mona.e_commerce_app_v1.BlankFragment2;
import com.example.mona.e_commerce_app_v1.bar_codeFragment;
import com.example.mona.e_commerce_app_v1.search_text_fragment;

public class simplefragmentpageadapter extends FragmentPagerAdapter {
    public simplefragmentpageadapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new search_text_fragment();
            case 1:
                return new BlankFragment2();
            case 2:
                return new bar_codeFragment();
        }
        return null;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 3;
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "text_search";
            case 1:
                return "voice_search";
            case 2:
                return "camera_search";
        }
        return super.getPageTitle(position);
    }
}
