# accordion-view

A Library that fold everything. just do it, we fold it. 5 minutes integration garantee.

Add it on your project:

Gradle:
```java 
compile 'com.xenione.libs:accordion:1.0.1'
```

Wrap your layout around AccordionView 


```java
<?xml version="1.0" encoding="utf-8"?>
<com.xenione.libs.accordion.AccordionView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@id/accordionView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#000">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fillViewport="true">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">


            <ImageView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:scaleType="centerCrop"
                android:src="@drawable/pep_botifarra_cover" />

            <TextView
                android:id="@+id/malagenya_lyrics"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:padding="5dp"
                android:textColor="@android:color/white"
                android:textSize="35dp"
                android:textStyle="bold" />
        </LinearLayout>

    </ScrollView>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="top"
        android:background="#7F000000"
        android:gravity="center"
        android:padding="@dimen/title_text_padding"
        android:text="@string/title_view_pager_accordion"
        android:textColor="@android:color/white"
        android:textStyle="bold" />

</com.xenione.libs.accordion.AccordionView>
  ```  

  Note that: AccordionView has id: accordionView keep it as long you use it along viewPager.

  ```java

    accordionView = (AccordionView) findViewById(R.id.accordionView);
    accordionView.setProgress(percentage);

 ```  
 where percentage goes from 0 (completly closed) to 1 (completly opened)

 AccordionView can came along ViewPager or DrawerLayout.

* Added into ViewPager

Set your ViewPager and adapter as usual, and don't forget to add into ViewPager AccordionPageTransformer' PageTransformer as it shows below.
Important to have been identified your accordionView with android:id="@id/accordionView" according to previous note.
 

  ```java

       ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
       PagerAdapter mPagerAdapter = new PagerAdapter(
                getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setPageTransformer(true, new AccordionPageTransformer());

 ```  

or 

* Added into DrawerLayout

Set your DrawerLayout as usual, but don't forget to pass through AccordionDrawerListener.

  ```java

        DrawerLayout lateralMenu = (DrawerLayout) findViewById(R.id.drawer_layout);
        accordionView = (AccordionView) findViewById(R.id.accordionView);
        lateralMenu.addDrawerListener(new AccordionDrawerListener(accordionView) {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                // add your code here to manage drawerLayout
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // add your code here to manage drawerLayout
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                // add your code here to manage drawerLayout
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                // add your code here to manage drawerLayout
            }
        });


 ```  

 Note: Here is NOT mandatory to identify your accordionView with 'id:accordionView' 

# What next?
-------

Try to add AccordionView into a RecyclerView, for this I need any extra support consider a donation.




# Donation
-------

The full money collected here will be destinated to improve Open Source Projects(accordiong to previus point).

[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=WQH9LXLLELC3N)



 # Develop by
-------

Eugeni Josep Senent i Gabriel - @xenione

xenione@gmail.com

www.xenione.com

<a href="https://www.linkedin.com/in/eugeni-senent-gabriel-bb198723">
  <img alt="Add me to Linkedin" src="https://image.freepik.com/iconos-gratis/boton-del-logotipo-linkedin_318-84979.png" height="60" width="60"/>
</a>




# License
-------
    Copyright 2016 Eugeni Josep Senent i Gabriel

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

