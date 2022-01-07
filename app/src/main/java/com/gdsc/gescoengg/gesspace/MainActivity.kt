package com.gdsc.gescoengg.gesspace


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId){


                R.id.nav_home -> replacefragment(HomeFragment(),it.title.toString())
                R.id.nav_YourAdds -> replacefragment(YourAddsFragment(),it.title.toString())
                R.id.nav_about_us -> replacefragment(AboutFragment(),it.title.toString())
                R.id.nav_faqs -> replacefragment(faqsFragment(),it.title.toString())
                R.id.nav_settings -> replacefragment(SettingsFragment(),it.title.toString())
                R.id.nav_Share -> replacefragment(ShareFragment(),it.title.toString())
                R.id.nav_RateUs -> replacefragment(RateusFragment(),it.title.toString())


            }

            true


        }

    }
    private fun replacefragment(fragment: Fragment,title :String){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){

            return true


        }
        return super.onOptionsItemSelected(item)
    }

}