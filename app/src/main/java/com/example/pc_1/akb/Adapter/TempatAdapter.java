package com.example.pc_1.akb.Adapter;
/**
 09/05/2020
 10116092
 Farkan Putra Ar-Rafii
 AKB -7
 **/
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.pc_1.akb.MenuDescription;
import com.example.pc_1.akb.MenuFriends;
import com.example.pc_1.akb.MenuInfo;
import com.example.pc_1.akb.MenuProfil;

public class TempatAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public TempatAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }



    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                MenuFriends tab1 = new MenuFriends();
                return tab1;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}