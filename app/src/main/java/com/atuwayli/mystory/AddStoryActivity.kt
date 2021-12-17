package com.atuwayli.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar

class AddStoryActivity : AppCompatActivity() {

    private var etAddTitle: EditText? = null
    private var etAddSubtitle: EditText? = null
    private var etAddDescription: EditText? = null
    private var btnAddStory: Button? = null

    private var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)

        connectViews()
        setToolbarProperties()




    }



    private fun setToolbarProperties() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.add_new_story) //If you don't want to set title
        val upArrow = resources.getDrawable(R.drawable.ic_baseline_arrow_back_24, theme)

        supportActionBar?.setHomeAsUpIndicator(upArrow)
        toolbar?.setNavigationOnClickListener {
            onBackPressed()

        }
    }





    private fun connectViews() {
        etAddTitle = findViewById(R.id.etAddTitle)
        etAddSubtitle = findViewById(R.id.etAddSubtitle)
        etAddDescription = findViewById(R.id.etAddDescription)
        btnAddStory = findViewById(R.id.btnAddStory)
        toolbar =findViewById(R.id.toolbar)

    }
}