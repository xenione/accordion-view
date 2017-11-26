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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xenione.libs.accordion.AccordionView;
import com.xenione.demos.accordion.R;


public class AccordionFragment extends Fragment {

    private AccordionAdapter mAdapter;
    private LinearLayoutManager layoutManager;
    private AccordionView accordionView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new AccordionAdapter(new String[]{"orem ipsum dolor sit amet, consectetur adipiscing elit, sed ",
                "orem ipsum dolor sit amet, consectetur adipiscing elit, sed ",
                "orem ipsum dolor sit amet, consectetur adipiscing elit, sed ",
                "orem ipsum dolor sit amet, consectetur adipiscing elit, sed ",
                "orem ipsum dolor sit amet, consectetur adipiscing elit, sed ",
                "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "t", "s"});
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_one, container, false);

        accordionView = view.findViewById(R.id.accordionView);
        RecyclerView recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        return view;
    }


    public static class AccordionAdapter extends RecyclerView.Adapter<AccordionAdapter.ViewHolder> {

        private String[] mDataset;


        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;

            public ViewHolder(TextView v) {
                super(v);
                mTextView = v;
            }
        }

        public AccordionAdapter(String[] myDataset) {
            mDataset = myDataset;
        }

        @Override
        public AccordionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {

            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_text_view, parent, false);

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(mDataset[position]);
        }

        @Override
        public int getItemCount() {
            return mDataset.length;
        }
    }
}
