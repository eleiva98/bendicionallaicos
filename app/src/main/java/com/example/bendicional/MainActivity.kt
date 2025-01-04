package com.example.bendicional

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

   private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: CustomPagerAdapter
    private lateinit var toolbar: Toolbar
    private lateinit var menuNavigationHandler: MenuNavigationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Inicialización de la barra de herramientas (Toolbar)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Inicialización del DrawerLayout y configuración del DrawerInitializer
        drawerLayout = findViewById(R.id.drawerLayout)
        val drawerInitializer = DrawerInitializer(this, drawerLayout, toolbar)

        drawerInitializer.initialize()

        viewPager = findViewById(R.id.viewPager)

        val titles = listOf(
            R.string.section1, R.string.section2, R.string.section3,
        )

        ViewPagerTitleUpdater(this, titles).attachToViewPager(viewPager)


        // Inicialización del ViewPagerManager y configuración de páginas HTML
        val viewPagerManager = ViewPagerManager(this, viewPager)
        viewPagerManager.initialize(getHtmlFiles())


        // Inicialización del NavigationView y configuración del listener para la navegación
        val navigationView: NavigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)


        pagerAdapter = CustomPagerAdapter(this, getHtmlFiles())
        viewPager.adapter = pagerAdapter

        // Inicialización del MenuNavigationHandler para manejar la navegación
        menuNavigationHandler = MenuNavigationHandler(drawerLayout, viewPagerManager)

        }


    // Método llamado cuando se selecciona un elemento del NavigationView
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        menuNavigationHandler.handleNavigation(item)
        return true
    }


    // Método para obtener la lista de archivos HTML
    private fun getHtmlFiles() = listOf(
        R.raw.rito1,
        R.raw.rito2,
        R.raw.rito3,
        /*R.string.rito4,
        R.string.rito5,
        R.string.rito6,
        R.string.rito7,
        R.string.rito8,
        R.string.rito9,
        R.string.rito10,
        R.string.rito11,
        R.string.rito12,
        R.string.rito13,
        R.string.rito14,
        R.string.rito15,
        R.string.rito16*/
    )





}





