package com.oti.materiadesign;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
	TextView textView;
	Context context;
	ClickListener clickListener;

	public MyViewHolder(@NonNull View itemView, Context context) {
		super(itemView);
		itemView.setOnClickListener(this);
		textView = itemView.findViewById(R.id.textView);
		this.context = context;

	}

	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}

	@Override
	public void onClick(View view) {
		context.startActivity(new Intent(context, MainActivity.class));

	}

	public interface ClickListener {
		void itemClick(View view, int position);
	}

}
