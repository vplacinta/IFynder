package com.llc.ifynder;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

public class ScreenNavigation {
    private FragmentManager fragmentManager;

    @Inject
    public ScreenNavigation(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void switchFragment(Fragment fragment, int containerId, boolean shouldAddToBackStack) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerId, fragment);
        if (shouldAddToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
