package com.atuwayli.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var tvEmail:TextView? = null
    private var drawer:DrawerLayout? = null
    private var toolbar:Toolbar? = null
    private var navView:NavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email = intent.getStringExtra("email")
        connectViews()
        tvEmail?.text = email

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupDrawer()
        drawerClickis()


    }

    private fun drawerClickis() {
        navView?.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    val i = Intent(this,MainActivity::class.java)
                    startActivity(i)
                   // Toast.makeText(this, "open home", Toast.LENGTH_SHORT).show()
                    drawer?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {
                    val i = Intent(this,LoginActivity::class.java)
                    startActivity(i)
                  //  Toast.makeText(this, "open logout", Toast.LENGTH_SHORT).show()
                    drawer?.closeDrawer(GravityCompat.START)
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
    }
}