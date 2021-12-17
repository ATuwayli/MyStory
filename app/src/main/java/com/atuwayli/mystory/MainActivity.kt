package com.atuwayli.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var tvEmail:TextView? = null
    private var drawer:DrawerLayout? = null
    private var toolbar:Toolbar? = null
    private var navView:NavigationView? = null

    private var recyclerView: RecyclerView? = null
    private var storyLetter: TextView? = null
    private var tvTitle: TextView? = null
    private var tvSubTitle: TextView? = null

    private var fab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email = intent.getStringExtra("email")
        connectViews()
        tvEmail?.text = email

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupDrawer()
        drawerClicks()
        updateEmailHeader(email!!)
        displayStories()
        openAddStory()



    }



    private fun displayStories() {
        val storiesArray: ArrayList<Story> = ArrayList()
        storiesArray.add(Story(getString(R.string.title_one),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_two),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_three),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_four),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_five),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_sixth),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_seventh),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_eight),getString(R.string.subtitle_one),getString(R.string.disc_one)))



        val customAdapter: CustomAdapter = CustomAdapter(storiesArray,this)
        recyclerView?.adapter = customAdapter

        // تم الاستغناء عن هذا الكود
        //        recyclerView?.layoutManager = LinearLayoutManager(this,
        //        LinearLayoutManager.VERTICAL, false)
        // تم استخدام هذا الكود بدلا عنه
        // in activity_main.xml/recyclerview
        // app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"



    }

    private fun updateEmailHeader(email:String) {
       val headerView = navView?.getHeaderView(0)
        val tvViewEmail = headerView?.findViewById<TextView>(R.id.tvEmail)
        tvViewEmail?.text = email
    }

    private fun drawerClicks() {
        navView?.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    drawer?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {
                    finish()
                    val i = Intent(this,LoginActivity::class.java)
                    startActivity(i)
                    true
                }

                else -> true
            }
        }
    }

    private fun openAddStory() {
        fab?.setOnClickListener {
            val i = Intent(this,AddStoryActivity::class.java)
            startActivity(i)
        }
    }

    private fun setupDrawer() {
        val toggle = ActionBarDrawerToggle(this,drawer,R.string.open
        ,R.string.close)
        drawer?.addDrawerListener(toggle)
        toggle.drawerArrowDrawable.color = getColor(R.color.white)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                drawer?.openDrawer(GravityCompat.START)
                true
            } else -> true
        }
    }

    private fun connectViews() {
        tvEmail =findViewById(R.id.tvEmail)
        drawer =findViewById(R.id.drawer)
        toolbar =findViewById(R.id.toolbar)
        navView =findViewById(R.id.navView)
        recyclerView =findViewById(R.id.recyclerview)
        tvTitle =findViewById(R.id.tvTitle)
        tvSubTitle =findViewById(R.id.tvSubTitle)
        storyLetter =findViewById(R.id.storyLetter)
        fab =findViewById(R.id.fab)
    }
}