package com.idputuwiprah.outlay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.idputuwiprah.outlay.R
import com.idputuwiprah.outlay.databinding.ActivityMainBinding
import com.idputuwiprah.outlay.other.Constants.ADD_INCOME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainActivity: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivity.root)

        navController = findNavController(R.id.navHostFragment)
    }

    fun toIncomeFragment() {
        navController.navigate(R.id.toIncomeFragment)
    }

    fun toExpenseFragment() {
        navController.navigate(R.id.toExpenseFragment)
    }

    fun toDebtFragment() {
        navController.navigate(R.id.toDebtFragment)
    }

    fun toAddFragment(fragment: Int) {
        when (fragment) {
            ADD_INCOME -> navController.navigate(fragment)
            else -> Unit
        }
    }
}