package com.xenione.libs.accordion;
/*
Copyright 26/11/2017 Eugeni Josep Senent i Gabriel

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

import android.support.annotation.CallSuper;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

public class AccordionDrawerListener implements DrawerLayout.DrawerListener {

    private AccordionView accordionView;

    public AccordionDrawerListener(AccordionView accordionView) {
        this.accordionView = accordionView;
    }

    @CallSuper
    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        accordionView.setProgress(1 - slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
