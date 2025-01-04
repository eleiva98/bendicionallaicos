package com.example.bendicional

import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class MenuNavigationHandler(private val drawerLayout: DrawerLayout, private val viewPagerManager: ViewPagerManager) {

    fun handleNavigation(item: MenuItem) {
        val selectedIndex = when (item.itemId) {
            R.id.menu_rito1 -> 0
            R.id.menu_rito2 -> 1
            R.id.menu_rito3 -> 2

            // Agrega los casos para los demás ítems del menú
            else -> -1
        }

        if (selectedIndex >= 0) {
            viewPagerManager.setCurrentItem(selectedIndex)
        }

        drawerLayout.closeDrawer(GravityCompat.START)
    }
}
