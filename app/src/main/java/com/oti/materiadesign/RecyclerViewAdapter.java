package com.oti.materiadesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

	LayoutInflater layoutInflater;
	List<String> data;
	Context context;


	public RecyclerViewAdapter(LayoutInflater layoutInflater, List<String> data, Context context) {
		this.layoutInflater = layoutInflater;
		this.data = data;
		this.context = context;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = layoutInflater.inflate(R.layout.row_view, parent, false);
		MyViewHolder myViewHolder = new MyViewHolder(view, context);
		return myViewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
		holder.textView.setText(data.get(position));
/*holder.textView.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View view) {
		delete(position);
	}
});*/

	}

	public void delete(int position) {
		if (data.size() != 0) {
			data.remove(position);
			notifyItemRemoved(position);
			notifyItemRangeChanged(position, data.size());
		}
	}

	@Override
	public int getItemCount() {
		return data.size();
	}
}
