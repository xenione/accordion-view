package com.xenione.demos.accordion;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xenione.demos.accordion.fragments.PagerAdapter;
import com.xenione.libs.accordion.AccordionDrawerListener;
import com.xenione.libs.accordion.AccordionPageTransformer;
import com.xenione.libs.accordion.AccordionView;

public class MainActivity extends AppCompatActivity {

    private LateralMenuAdapter mAdapter;

    private AccordionView accordionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fill lateral menu
        mAdapter = new LateralMenuAdapter(new String[]{"Ai mare, jo vull casar-me",
                "Batre xabiero",
                "Bressol",
                "Cançonetes de Mariners",
                "Cant de Batre",
                "Cant de batre de Sella",
                "Coses de Sant Vicent Ferrer",
                "De l'Ebre a l'Albaida",
                "De la flor de la farina",
                "Des de que el sol ha sortit ",
                "Déu va fer pobres i rics ",
                "Dotze i U ",
                "Dotze i u de la tia Rosario ",
                "El casamiento de Maria la Xapa ",
                "El Velatori",
                " Els vetlatoris ",
                "Fandango de l'emigrant ",
                "Granaïna de Montaverner ",
                "Granaïna del tio Palero ",
                "Havanera de canyes i fang "});

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_lateral_menu);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        // set listener on lateral menu
        DrawerLayout lateralMenu = (DrawerLayout) findViewById(R.id.drawer_layout);
        accordionView = (AccordionView) findViewById(R.id.accordion_lateral_menu);
        lateralMenu.addDrawerListener(BuildDrawerListener(accordionView));

        // fill content with viewPager
        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter mPagerAdapter = new PagerAdapter(
                getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setPageTransformer(true, new AccordionPageTransformer());
    }

    private DrawerLayout.DrawerListener BuildDrawerListener(AccordionView accordionView) {
        return new AccordionDrawerListener(accordionView) {

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
        };
    }

    public static class LateralMenuAdapter extends RecyclerView.Adapter<LateralMenuAdapter.ViewHolder> {

        private String[] songs;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView title;

            public ViewHolder(TextView v) {
                super(v);
                title = v;
            }
        }

        public LateralMenuAdapter(String[] songs) {
            this.songs = songs;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {

            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.lateral_menu_row, parent, false);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Deliberately no action performed,", Toast.LENGTH_LONG).show();
                }
            });
            ViewHolder vh = new ViewHolder(v);

            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.title.setText(songs[position]);
        }

        @Override
        public int getItemCount() {
            return songs.length;
        }
    }
}
