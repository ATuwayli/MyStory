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
import androidx.appcompat.app.AlertDialog
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
    private var tvUsername:TextView? = null
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
      //  try {updateEmailHeader(email!!)} catch (e:NullPointerException){ }
        updateEmailHeader(email)
        drawerClicks()
        displayStories()
        openAddStory()

    }

    private fun updateEmailHeader(email:String?) {
        val headerView = navView?.getHeaderView(0)
        val tvViewEmail = headerView?.findViewById<TextView>(R.id.tvEmail)
        val tvViewUsername = headerView?.findViewById<TextView>(R.id.tvUsername)
        tvViewEmail?.text = email
        tvViewUsername?.text = getString(R.string.my_name)
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
        tvUsername =findViewById(R.id.tvUsername)
        drawer =findViewById(R.id.drawer)
        toolbar =findViewById(R.id.toolbar)
        navView =findViewById(R.id.navView)
        recyclerView =findViewById(R.id.recyclerview)
        tvTitle =findViewById(R.id.tvTitle)
        tvSubTitle =findViewById(R.id.tvSubTitle)
        storyLetter =findViewById(R.id.storyLetter)
        fab =findViewById(R.id.fab)
    }

    private fun drawerClicks() {
        navView?.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    drawer?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {
                    alertDialog()
                    true
                }
                R.id.share -> {
                    Toast.makeText(this, "Share code", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.send -> {
                    Toast.makeText(this, "Send email code", Toast.LENGTH_SHORT).show()

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

    private fun displayStories() {
        val storiesArray: ArrayList<Story> = ArrayList()
        storiesArray.add(Story(getString(R.string.title_one),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_two),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_three),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_three),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_three),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_three),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_three),getString(R.string.subtitle_one),getString(R.string.disc_one)))
        storiesArray.add(Story(getString(R.string.title_three),getString(R.string.subtitle_one),getString(R.string.disc_one)))

        val customAdapter = CustomAdapter(storiesArray,this)
        recyclerView?.adapter = customAdapter

        if (intent.getStringExtra("title") != null){
            val title = intent.getStringExtra("title")
            val subtitle = intent.getStringExtra("subtitle")
            val desc = intent.getStringExtra("desc")

            val newStory = Story(title!!,subtitle!!,desc!!)
            storiesArray.add(newStory)
            customAdapter.notifyDataSetChanged()

        }

        // تم الاستغناء عن هذا الكود
        //        recyclerView?.layoutManager = LinearLayoutManager(this,
        //        LinearLayoutManager.VERTICAL, false)
        // تم استخدام هذا الكود بدلا عنه
        // in activity_main.xml/recyclerview
        // app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"



    }

    private fun intentToLogin(){
        finish()
        val i = Intent(this,LoginActivity::class.java)
        startActivity(i)
    }

    private fun alertDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle(getString(R.string.confirm_exit))
        dialog.setIcon(R.drawable.ic_baseline_warning_24)
        dialog.setMessage(getString(R.string.tv_dialog))
        dialog.setPositiveButton(getString(R.string.yes)){ dialog, which -> intentToLogin()}
        dialog.setNegativeButton(getString(R.string.no),null)
        dialog.show()

    }






}