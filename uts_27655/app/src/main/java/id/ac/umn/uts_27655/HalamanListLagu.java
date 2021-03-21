package id.ac.umn.uts_27655;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class HalamanListLagu extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    static ArrayList<FileLagu> fileLagu;
    static boolean shuffleBoolean = false;
    static boolean repeatBoolean = false;
    private ViewPager viewPager;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_listlagu);
        dialog = new Dialog(this);
        permission();
        initViewPager();

        dialog.setContentView(R.layout.successful_login);
        dialog.show();
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menuProfile:
                Intent profileIntent = new Intent(HalamanListLagu.this, HalamanProfile.class);
                if (profileIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(profileIntent);
                }
                return true;

            case R.id.menuLogOut:
                Intent logOutIntent = new Intent(HalamanListLagu.this, HalamanLogin.class);
                startActivityForResult(logOutIntent, 1);

            default: return super.onOptionsItemSelected(item);
        }
    }

    private void initViewPager() {
        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new FragmenLagu(), "Songs");
        viewPager.setAdapter(viewPagerAdapter);
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
    }

    public static class ViewPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            this.fragments = new ArrayList<>();
            this.titles = new ArrayList<>();
        }

        void addFragments(Fragment fragment, String title) {
            fragments.add(fragment);
            titles.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    private void permission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(HalamanListLagu.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE);
        } else {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            fileLagu = getAllAudio(this);
            initViewPager();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                fileLagu = getAllAudio(this);
                initViewPager();
            } else {
                ActivityCompat.requestPermissions(HalamanListLagu.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE);
            }
        }
    }

    public static ArrayList<FileLagu> getAllAudio(Context context) {
        ArrayList<FileLagu> tempAudioList = new ArrayList<>();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA
        };
        Cursor cursor = context.getContentResolver().query(uri, projection,
                null, null, null);
        if(cursor != null) {
            while(cursor.moveToNext()) {
                String title = cursor.getString(0);
                String artist = cursor.getString(1);
                String duration = cursor.getString(2);
                String path = cursor.getString(3);

                FileLagu fileLagu = new FileLagu(path, title, artist, duration);
                tempAudioList.add(fileLagu);
            }
            cursor.close();
        }
        return tempAudioList;
    }
}