package com.atuwayli.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import java.text.SimpleDateFormat
import java.util.*

class StoryDetailsActivity : AppCompatActivity() {

    private var tvTitle1:TextView? = null
    private var tvDesc1:TextView? = null
    private var toolbar: Toolbar? = null
    private var tvTime: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)

        connecViews()

        setToolbarProperties()

        receiveVariable()
        currentDateAndTime()





    }

    private fun currentDateAndTime() {
        val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd 'at' HH:mm")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        tvTime?.text = currentDateAndTime
    }

    private fun receiveVariable() {
        val title:String = intent.getStringExtra("title").toString()
        val disc:String = intent.getStringExtra("desc").toString()

        tvTitle1?.text = title
        tvDesc1?.text = disc
    }


    private fun setToolbarProperties() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val upArrow = resources.getDrawable(R.drawable.ic_baseline_arrow_back_24, theme)
        val title = intent.getStringExtra("title").toString()
        supportActionBar?.title = title
        supportActionBar?.setHomeAsUpIndicator(upArrow)
        tvDesc1?.movementMethod = ScrollingMovementMethod()
        toolbar?.setNavigationOnClickListener {
            onBackPressed()

        }
    }


    private fun connecViews() {
        tvTitle1 =findViewById(R.id.tvTitle1)
        tvDesc1 =findViewById(R.id.tvDesc1)
        toolbar =findViewById(R.id.toolbar)
        tvTime =findViewById(R.id.tvTime)
    }
}