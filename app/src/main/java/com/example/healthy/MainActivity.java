package com.example.healthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends FragmentActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    //private TabItem tabProteina, tabVitamina, tabInfo;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);

        viewPager2.setAdapter(new SaludPagerAdapter(this));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:{
                        tab.setText("Proteinas");
                        tab.setIcon(R.drawable.ic_proteina);
                        break;
                    }
                    case 1:{
                        tab.setText("Vitaminas");
                        tab.setIcon(R.drawable.ic_vitamina);
                        break;
                    }
                    case 2:{
                        tab.setText("Información");
                        tab.setIcon(R.drawable.ic_informacion);
                        break;
                    }
                }
            }
        });

        tabLayoutMediator.attach();

    }
}