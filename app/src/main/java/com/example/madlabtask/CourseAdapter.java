package com.example.madlabtask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private final ArrayList<Course> courses;
    private final OnItemClickListener listener;

    public CourseAdapter(ArrayList<Course> courses, OnItemClickListener listener) {
        this.courses = courses;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_course, parent, false);
        return new CourseViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.codeTextView.setText(course.getCode());
        holder.titleTextView.setText(course.getTitle());
        holder.creditHoursTextView.setText(
                holder.itemView.getContext().getString(
                        R.string.credit_hours_format, course.getCreditHours()));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {
        private final TextView codeTextView;
        private final TextView titleTextView;
        private final TextView creditHoursTextView;

        CourseViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            codeTextView = itemView.findViewById(R.id.tvCourseCode);
            titleTextView = itemView.findViewById(R.id.tvCourseTitle);
            creditHoursTextView = itemView.findViewById(R.id.tvCreditHours);
            itemView.setOnClickListener(view -> {
                int position = getBindingAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position);
                }
            });
        }
    }
}
