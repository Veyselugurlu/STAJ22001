package com.example.filmler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.filmler.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment1 = supportFragmentManager.findFragmentById(R.id.navHostFragment1) as NavHostFragment
        val navController = navHostFragment1.navController

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.anasayfaFragment -> {
                    navController.navigate(R.id.anasayfaFragment)
                    true
                }
                R.id.favoriFragment -> {
                    navController.navigate(R.id.favoriFragment)
                    true
                }
                R.id.sepetFragment -> {
                    navController.navigate(R.id.sepetFragment)
                    true
                }
                else -> false
            }
        }
    }
}
