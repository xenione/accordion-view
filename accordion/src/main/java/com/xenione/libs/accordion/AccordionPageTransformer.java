/*
Copyright 04/11/2017 Eugeni Josep Senent i Gabriel

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
package com.xenione.libs.accordion;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.xenione.accordion.R;


public class AccordionPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        Holder holder = (Holder) page.getTag();
        if (holder == null) {
            holder = new Holder();
            holder.view = page.findViewById(R.id.accordionView);
            page.setTag(holder);
        }

        if (holder.view != null) {
            holder.view.setProgress(Math.abs(position));
        }
    }

    private static class Holder {

        AccordionView view;
    }
}
