package com.llc.ifynder.base;

import android.support.v4.app.Fragment;

import butterknife.Unbinder;

public class BaseFragment extends Fragment {
    private Unbinder unbinder;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }
}


