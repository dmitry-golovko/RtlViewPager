/*
 * Copyright 2016 Konstantin Loginov
 * Copyright 2015 Diego Gómez Olvera
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package klogi.com;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

/**
 * PagerAdapter decorator.
 */
public abstract class RtlPagerAdapter extends FragmentStatePagerAdapter {

    protected ViewPager mViewPager;

    public RtlPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (container instanceof ViewPager) {
            mViewPager = (ViewPager) container;
        }

        if (isRtl()) {
            return super.instantiateItem(container, reverse(position));
        } else {
            return super.instantiateItem(container, position);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(reverse(position));
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(reverse(position));
    }

    @Override
    public int getItemPosition(Object object) {
        if (isRtl()) {
            final int itemPosition = super.getItemPosition(object);
            return itemPosition < 0 ? itemPosition : reverse(itemPosition);
        } else {
            return super.getItemPosition(object);
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (isRtl()) {
            super.destroyItem(container, reverse(position), object);
        } else {
            super.destroyItem(container, position, object);
        }
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (isRtl()) {
            super.setPrimaryItem(container, getCount() - position - 1, object);
        } else {
            super.setPrimaryItem(container, position, object);
        }
    }

    private int reverse(int position) {
        return getCount() - position - 1;
    }

    protected boolean isRtl() {
        return mViewPager != null &&
                TextUtilsCompat.getLayoutDirectionFromLocale(
                        mViewPager.getContext().getResources().getConfiguration().locale)
                        == ViewCompat.LAYOUT_DIRECTION_RTL;
    }
}
