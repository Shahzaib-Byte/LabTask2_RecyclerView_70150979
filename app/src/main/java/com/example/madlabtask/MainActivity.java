package com.example.madlabtask;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CourseAdapter.OnItemClickListener {
    private ArrayList<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle(R.string.course_list_title);

        courses = new ArrayList<>();
        courses.add(new Course("CS-301", "Data Structures", "Dr. Ayesha Khan",
                "ayesha.khan@example.edu", "Lists, trees, graphs, hashing and algorithmic analysis.", 3));
        courses.add(new Course("CS-302", "Database Systems", "Dr. Hamza Ali",
                "hamza.ali@example.edu", "Relational design, SQL, normalization and transactions.", 3));
        courses.add(new Course("CS-303", "Operating Systems", "Dr. Sara Ahmed",
                "sara.ahmed@example.edu", "Processes, memory management, file systems and scheduling.", 3));
        courses.add(new Course("CS-304", "Computer Networks", "Dr. Bilal Raza",
                "bilal.raza@example.edu", "Network models, protocols, routing and network security basics.", 3));
        courses.add(new Course("CS-305", "Software Engineering", "Dr. Hina Malik",
                "hina.malik@example.edu", "Requirements, design, testing and software project management.", 3));
        courses.add(new Course("CS-306", "Mobile Application Development", "Dr. Usman Tariq",
                "usman.tariq@example.edu", "Android components, layouts, persistence and app architecture.", 3));
        courses.add(new Course("CS-307", "Artificial Intelligence", "Dr. Nadia Iqbal",
                "nadia.iqbal@example.edu", "Search, knowledge representation, reasoning and machine learning.", 3));
        courses.add(new Course("CS-308", "Web Engineering", "Dr. Omar Farooq",
                "omar.farooq@example.edu", "Modern web applications, APIs, usability and deployment.", 3));

        RecyclerView rvCourses = findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this));
        rvCourses.setAdapter(new CourseAdapter(courses, this));
    }

    @Override
    public void onItemClick(int position) {
        Course course = courses.get(position);
        Intent intent = new Intent(this, CourseDetailActivity.class);
        intent.putExtra(CourseDetailActivity.EXTRA_CODE, course.getCode());
        intent.putExtra(CourseDetailActivity.EXTRA_TITLE, course.getTitle());
        intent.putExtra(CourseDetailActivity.EXTRA_INSTRUCTOR, course.getInstructor());
        intent.putExtra(CourseDetailActivity.EXTRA_EMAIL, course.getEmail());
        intent.putExtra(CourseDetailActivity.EXTRA_DESCRIPTION, course.getDescription());
        intent.putExtra(CourseDetailActivity.EXTRA_CREDIT_HOURS, course.getCreditHours());
        startActivity(intent);
    }
}
