package edu.seoul42.doitmission10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val drawerToggle = ActionBarDrawerToggle(this, drawer, toolbar, 0,0)

        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val pager = findViewById<ViewPager>(R.id.view_pager)
        pager.offscreenPageLimit = 3

        val adaptor = PageAdaptor(supportFragmentManager)
        adaptor.addItem(PageFragment1())
        adaptor.addItem(PageFragment2())
        adaptor.addItem(PageFragment3())

        pager.adapter = adaptor

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.selectedItemId = R.id.tab1
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.tab1 -> pager.currentItem = 0
                R.id.tab2 -> pager.currentItem = 1
                else -> pager.currentItem = 2
            }
            true
        }



        pager.addOnPageChangeListener( object: ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { }

            override fun onPageSelected(position: Int) {
                bottomNavigation.selectedItemId = adaptor.getItemId(position)
            }
            override fun onPageScrollStateChanged(state: Int) { }
        })

    }

    class PageAdaptor (var fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        val items = ArrayList<Fragment>()
        fun addItem(item: Fragment) {
            items.add(item)
        }
        override fun getItem(position: Int) : Fragment {
            return items[position]
        }
        override fun getCount() : Int {
            return items.size
        }
        fun getItemId(position: Int) : Int {
            return when(position) {
                0 -> R.id.tab1
                1 -> R.id.tab2
                else -> R.id.tab3
            }
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        if (drawer.isDrawerOpen((GravityCompat.START))) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val pager = findViewById<ViewPager>(R.id.view_pager)
        when (item.itemId) {
            R.id.tab1 -> pager.currentItem = 0
            R.id.tab2 -> pager.currentItem = 1
            else -> pager.currentItem = 2
        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}