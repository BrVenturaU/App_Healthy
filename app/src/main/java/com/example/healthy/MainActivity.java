package com.example.healthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new SaludPagerAdapter(this));


        final TabLayout tabLayout = findViewById(R.id.tabLayout);
        final TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setIcon(R.drawable.ic_vitamina);
                        final TabItem tabVita=findViewById(R.id.tab1);
                        break;
                    }
                    case 1: {
                        tab.setIcon(R.drawable.ic_proteina);
                        final TabItem tabProteinas=findViewById(R.id.tab2);
                        break;
                    }
                    case 2: {
                        tab.setIcon(R.drawable.ic_informacion);
                       final TabItem tabInformacion=findViewById(R.id.tab3);
                        break;
                    }
                    default:
                }
            }
        }
        );
        tabLayoutMediator.attach();


    }
}