package com.tjedit.finaltest_201904_android.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tjedit.finaltest_201904_android.R;
import com.tjedit.finaltest_201904_android.databinding.FragmentMyProfileBinding;
import com.tjedit.finaltest_201904_android.databinding.FragmentNoticeBinding;

public class NoticeListFragment extends Fragment {
    FragmentNoticeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notice, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}

