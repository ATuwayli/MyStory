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
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var tvEmail:TextView? = null
    private var drawer:DrawerLayout? = null
    private var toolbar:Toolbar? = null
    private var navView:NavigationView? = null
    private var recyclerView: RecyclerView? = null
    private var imageViewProfile: ImageView? = null
    private var tvTitle: TextView? = null
    private var tvDescription: TextView? = null

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
        prepareRecyclerView()



    }

     private fun prepareRecyclerView() {
        val array: ArrayList<Story> = ArrayList()
        array.add(Story("Week two", "I learned arrays and loops and their control", R.drawable.icon))
        array.add(Story("Week three", "I learned arrays and loops and their control", R.drawable.icon))
        array.add(Story("Week four", "I learned arrays and loops and their control", R.drawable.icon))
        array.add(Story("Week five", "I learned arrays and loops and their control", R.drawable.icon))
        array.add(Story("Week six", "I learned arrays and loops and their control", R.drawable.icon))
        array.add(Story("Week seven", "I learned arrays and loops and their control", R.drawable.icon))
        array.add(Story("Week eight", "I learned arrays and loops and their control", R.drawable.icon))





        val customAdapter: CustomAdapter = CustomAdapter(array)
        recyclerView?.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        recyclerView?.adapter = customAdapter

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
        tvDescription =findViewById(R.id.tvDescription)
        imageViewProfile =findViewById(R.id.imageViewProfile)
    }
}