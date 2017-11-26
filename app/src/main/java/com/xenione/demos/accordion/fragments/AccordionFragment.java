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

package com.xenione.demos.accordion.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xenione.demos.accordion.R;


public class AccordionFragment extends Fragment {


    private String lyric = "Mira si he corregut terres\n" +
            "Que he estat en Alfarrasí\n" +
            "En Adzaneta i Albaida\n" +
            "En el Palomar i ací\n" +
            "\n" +
            "Omplim el sarró de pa\n" +
            "Si vols que et guarde les cabres\n" +
            "Que les figues ja s'acaben\n" +
            "I raïm no queda un gra\n" +
            "\n" +
            "La Llosa i el Genovès\n" +
            "Lloc Nou, la Torre i Barxeta\n" +
            "Xàtiva, Rotglà i Valles\n" +
            "Llanera, Vallà i Montesa\n" +
            "Alboi, Cerdà i Estubeny\n" +
            "La Granja, Sorió i Torrella";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_accordion, container, false);
        ((TextView)view.findViewById(R.id.malagenya_lyrics)).setText(lyric);

        return view;
    }
}
