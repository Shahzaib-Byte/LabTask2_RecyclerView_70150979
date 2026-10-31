package com.example.madlabtask;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CourseDetailActivity extends AppCompatActivity {
    public static final String EXTRA_CODE = "extra_code";
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_INSTRUCTOR = "extra_instructor";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    public static final String EXTRA_CREDIT_HOURS = "extra_credit_hours";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        String code = getIntent().getStringExtra(EXTRA_CODE);
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String instructor = getIntent().getStringExtra(EXTRA_INSTRUCTOR);
        String email = getIntent().getStringExtra(EXTRA_EMAIL);
        String description = getIntent().getStringExtra(EXTRA_DESCRIPTION);
        int creditHours = getIntent().getIntExtra(EXTRA_CREDIT_HOURS, 0);

        setTitle(code);
        ((TextView) findViewById(R.id.tvDetailTitle)).setText(title);
        ((TextView) findViewById(R.id.tvDetailInstructor)).setText(
                getString(R.string.instructor_format, instructor));
        ((TextView) findViewById(R.id.tvDetailCreditHours)).setText(
                getString(R.string.credit_hours_format, creditHours));
        ((TextView) findViewById(R.id.tvDetailDescription)).setText(description);

        Button emailButton = findViewById(R.id.btnEmailInstructor);
        emailButton.setOnClickListener(view -> {
            Intent emailIntent = new Intent(
                    Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
            try {
                startActivity(emailIntent);
            } catch (ActivityNotFoundException exception) {
                Toast.makeText(this, R.string.no_email_app, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
