package com.xenione.demos.accordion;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xenione.accordion.AccordionPageTransformer;
import com.xenione.demos.accordion.fragments.PagerAdapter;

public class MainActivity extends AppCompatActivity {

    private LateralMenuAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // fill lateral menu
        mAdapter = new LateralMenuAdapter(new String[]{"orem ipsum dolor sit amet, consectetur adipiscing elit, sed ",
                "orem ipsum dolor sit amet, consectetur adipiscing elit, sed ",
                "orem ipsum dolor sit amet, consectetur adipiscing elit, sed ",
                "orem ipsum dolor sit amet, consectetur adipiscing elit, sed ",
                "orem ipsum dolor sit amet, consectetur adipiscing elit, sed ",
                "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "t", "s"});

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_lateral_menu);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);


        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter mPagerAdapter = new PagerAdapter(
                getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setPageTransformer(true, new AccordionPageTransformer());
    }

    public static class LateralMenuAdapter extends RecyclerView.Adapter<LateralMenuAdapter.ViewHolder> {

        private String[] mDataset;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;

            public ViewHolder(TextView v) {
                super(v);
                mTextView = v;
            }
        }

        public LateralMenuAdapter(String[] myDataset) {
            mDataset = myDataset;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,
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
