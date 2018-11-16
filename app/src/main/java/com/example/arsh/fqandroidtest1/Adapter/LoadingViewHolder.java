package com.example.arsh.fqandroidtest1.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.arsh.fqandroidtest1.R;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class LoadingViewHolder extends RecyclerView.ViewHolder {
    public ProgressBar progressBar;
    public LoadingViewHolder(@NonNull View itemView) {
        super(itemView);
        progressBar = (ProgressBar) itemView.findViewById(R.id.progress_bar);
    }
}
