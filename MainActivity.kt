package com.stocktracker.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.widget.*

class MainActivity : Activity() {
    private lateinit var content: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        home()
    }

    private fun screen(title: String) {
        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(24, 50, 24, 12)

        val head = TextView(this)
        head.text = title
        head.textSize = 27f
        head.setTextColor(Color.rgb(15, 65, 120))
        root.addView(head)

        content = LinearLayout(this)
        content.orientation = LinearLayout.VERTICAL
        val scroll = ScrollView(this)
        scroll.addView(content)
        root.addView(scroll, LinearLayout.LayoutParams(-1, 0, 1f))

        val nav = LinearLayout(this)
        listOf("Home", "Alerts", "Trades", "Portfolio", "Tips").forEach { name ->
            val button = Button(this)
            button.text = name
            button.textSize = 11f
            button.setOnClickListener {
                when (name) {
                    "Home" -> home()
                    "Alerts" -> alerts()
                    "Trades" -> trades()
                    "Portfolio" -> portfolio()
                    "Tips" -> tips()
                }
            }
            nav.addView(button, LinearLayout.LayoutParams(0, -2, 1f))
        }
        root.addView(nav)
        setContentView(root)
    }

    private fun card(text: String) {
        val view = TextView(this)
        view.text = text
        view.textSize = 17f
        view.setPadding(18, 24, 18, 24)
        content.addView(view)
    }

    private fun home() {
        screen("STOCK TRACKER")
        card("📊 MARKET\n\nNifty 200 • Gold • Silver\n\nClean Build v1")
        card("🔔 SWING ALERTS\n\nScanner foundation ready")
        card("💼 PORTFOLIO\n\nPortfolio tracking will be added next")
    }

    private fun alerts() {
        screen("🔔 SWING ALERTS")
        card("Clean build successful foundation.\n\nMarket data will be connected in the next stage.")
    }

    private fun trades() {
        screen("💼 MY TRADES")
        card("Trade tracking will be added after the clean build test.")
    }

    private fun portfolio() {
        screen("📊 PORTFOLIO")
        card("Indian Stocks • Mutual Funds • Gold • Silver • US Investments")
    }

    private fun tips() {
        screen("💡 TIPS")
        card("Technical analysis • Fundamentals • Risk/Reward")
    }
}
