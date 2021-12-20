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
        fieldsValidation()




    }

    private fun fieldsValidation() {
        btnAddStory?.setOnClickListener {
            val title = etAddTitle?.text.toString()
            val subTitle = etAddSubtitle?.text.toString()
            val desc = etAddDescription?.text.toString()

            when {
                title.isEmpty() -> {
                    etAddTitle?.error = getString(R.string.enter_title)
                }
                subTitle.isEmpty() -> {
                    etAddSubtitle?.error = getString(R.string.enter_subtitle)
                }
                desc.isEmpty() -> {
                    etAddDescription?.error = getString(R.string.enter_desc)
                }
                else -> {
                    this.finish()
                    val i = Intent(this,MainActivity::class.java)
                    i.putExtra("title",title)
                    i.putExtra("subtitle",subTitle)
                    i.putExtra("desc",desc)
                    startActivity(i)
                }
            }
        }
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