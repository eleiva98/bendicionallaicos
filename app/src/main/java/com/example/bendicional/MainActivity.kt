package com.example.bendicional

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.common.util.CollectionUtils.listOf
import com.google.android.material.navigation.NavigationView


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

   private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: CustomPagerAdapter
    private lateinit var toolbar: Toolbar
    private lateinit var menuNavigationHandler: MenuNavigationHandler
    private lateinit var viewPagerManager: ViewPagerManager // Declarar viewPagerManager

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

        // Inicialización del ViewPager
        viewPager = findViewById(R.id.viewPager)

        // Inicialización de ViewPagerManager
        viewPagerManager = ViewPagerManager(viewPager)

                // Configurar el adaptador con las URLs
        pagerAdapter = CustomPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        // Configuración del ViewPager
        val titles = listOf(R.string.section1, R.string.section2, R.string.section3)
        ViewPagerTitleUpdater(this, titles).attachToViewPager(viewPager)

        // Inicialización del NavigationView y configuración del listener para la navegación
        val navigationView: NavigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)

        // Inicialización del MenuNavigationHandler para manejar la navegación
        menuNavigationHandler = MenuNavigationHandler(drawerLayout, viewPagerManager)
    }


    // Método llamado cuando se selecciona un elemento del NavigationView
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        menuNavigationHandler.handleNavigation(item)
        return true
    }

}





