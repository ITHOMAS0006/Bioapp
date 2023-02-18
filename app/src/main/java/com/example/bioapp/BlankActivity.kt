package com.example.bioapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.Spinner
import android.widget.RadioButton

class BlankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blank)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.blankid, BioFragment())
                .commit()
        }
    }
}