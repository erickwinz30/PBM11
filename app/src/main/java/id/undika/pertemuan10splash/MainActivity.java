package id.undika.pertemuan10splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import id.undika.pertemuan10splash.FragmentMovie;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView nav;
    Fragment fragment;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav = findViewById(R.id.navView);
        BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //halaman fragment(isinya : contoh list data, form, dll)
                //membuat fragment kosong
                fragment = null;

                //cek menu mana yang di klik
                switch (item.getItemId()) {
                    case R.id.menu_movie:
                        //panggil halaman fragment movie
                        fragment = new FragmentMovie();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, fragment.getClass().getSimpleName()).commit();
                        return true;
                    case R.id.menu_tv:
                        break;
                }
                return false;
            }
        };

        nav = findViewById(R.id.navView);
        nav.setOnNavigationItemSelectedListener(listener);
        if (savedInstanceState == null) {
            nav.setSelectedItemId(R.id.menu_movie);
        }
    }

    public boolean onCreateOptionMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}