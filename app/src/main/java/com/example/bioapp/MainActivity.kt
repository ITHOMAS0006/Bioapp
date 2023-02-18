package com.example.bioapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.Spinner
import android.widget.RadioButton




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val createbutton = findViewById<Button>(R.id.CreateButton)
        val firstNameTextField = findViewById<EditText>(R.id.FirstNameTextField)
        val lastNameTextField = findViewById<EditText>(R.id.LastNameTextField)
        val graduationYearTextField = findViewById<EditText>(R.id.GraduationYearTextField)
        val degreeRadioGroup = findViewById<GridLayout>(R.id.DegreeRadioGroup)
        val majorSpinner = findViewById<Spinner>(R.id.major_spinner)
        val schoolTextField = findViewById<EditText>(R.id.SchoolTextField)
        val favoriteActivitiesTextField = findViewById<EditText>(R.id.FavoriteActivitiesTextField)

        createbutton.setOnClickListener {
            // Get user input from form
            val firstName = firstNameTextField.text.toString()
            val lastName = lastNameTextField.text.toString()
            val graduationYear = graduationYearTextField.text.toString()
            val degree = getDegree(degreeRadioGroup)
            val major = majorSpinner.selectedItem.toString()
            val school = schoolTextField.text.toString()
            val favoriteActivities = favoriteActivitiesTextField.text.toString()

            // Create Bio Fragment instance and pass in user data
            val bioFragment = BioFragment()
            val bundle = Bundle().apply {
                putString("firstName", firstName)
                putString("lastName", lastName)
                putString("graduationYear", graduationYear)
                putString("degree", degree)
                putString("major", major)
                putString("school", school)
                putString("favoriteActivities", favoriteActivities)
            }
            bioFragment.arguments = bundle
        if(bundle!=null){System.out.print("not null")}
            // Show Bio Fragment
//            val bioFraggment = BioFragment.newInstance(firstName, lastName, graduationYear, degree, major, school, favoriteActivities)

            // Replace current fragment with BioFragment
            val intent = Intent(this, BlankActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = supportFragmentManager.beginTransaction()
//            fragmentTransaction.add(R.id.frameLayoutcontainer, bioFragment, "bio_fragment")
//            fragmentTransaction.addToBackStack(null)
//            fragmentTransaction.commit()
        }
        }private fun getDegree(degreeRadioGroup: GridLayout): String {
        var selectedDegree = ""

        for (i in 0 until degreeRadioGroup.childCount) {
            val radioButton = degreeRadioGroup.getChildAt(i) as? RadioButton
            if (radioButton != null && radioButton.isChecked) {
                selectedDegree = radioButton.text.toString()
                break
            }
        }

        return selectedDegree


    }
}
