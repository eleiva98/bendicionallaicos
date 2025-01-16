package com.example.bendicional

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.viewpager.widget.PagerAdapter


class CustomPagerAdapter (private val context: Context) : PagerAdapter() {
    //private val createdWebViews = mutableListOf<WebView>()

    // Lista de URLs alojadas en Firebase Hosting
    private val htmlUrls = listOf(
        "https://bendicionallaicos.web.app/rito1.html",
        "https://bendicionallaicos.web.app/rito2.html",
        "https://bendicionallaicos.web.app/rito3.html"
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val webView = createWebView()
       // createdWebViews.add(webView)

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_html_display, container, false)

        val webViewContainer: ViewGroup = view.findViewById(R.id.webView)
        webViewContainer.addView(webView)
        //updateWebViewTextSize(webView, textSize)

        webView.loadUrl(htmlUrls[position])


        container.addView(view)
        return view
    }



    override fun getCount(): Int {return htmlUrls.size}

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`}

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)    }

    private fun createWebView(): WebView {
        val webView = WebView(context)

        webView.settings.setSupportZoom(true)
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        webView.settings.domStorageEnabled = true
        return webView
    }


}

