# RtlViewPager with TabLayout support
ViewPager that displays items from right to left for RTL locales and behaves like a regular ViewPager otherwise

![Image of RtlViewPager](http://i.stack.imgur.com/dIhuy.gif)

With modified tab layout

![Image of RtlViewPager](http://cdn.makeagif.com/media/2-08-2016/na7MlX.gif)

Usage
-------------

Import it using gradle

    dependencies {
        ...    
        compile 'klogi.com:rtlviewpager:1.0.0'
    }

In XML:

    <klogi.com.RtlViewPager
        android:id="@+id/viewPager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
  
In code:

    TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
    ViewPager viewPager = (RtlViewPager)findViewById(R.id.viewPager);
    viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), fragments));
    tabLayout.setupWithViewPager(viewPager);      
  


Acknowledgment
-------------
This module was originally developed for Booking.com. With approval from Booking.com, this module was generalized and published on GitHub and jCenter. From my side, I did important bugfix to enable TabLayout.

License
-------------
> Copyright 2016 Konstantin Loginov

> Copyright 2015 Diego Gómez Olvera

> Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

>   http://www.apache.org/licenses/LICENSE-2.0

>Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
