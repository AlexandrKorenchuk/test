package com.example.otstest.presentation.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.otstest.R
import com.example.otstest.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var scope: Scope

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var navController: NavController? = null

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        scope = getKoin().getOrCreateScope(DI_SCOPE_NAME, named(DI_SCOPE_NAME))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        navController = Navigation.findNavController(this, R.id.navHostFragment)
    }

    companion object{
        const val DI_SCOPE_NAME = "MainScope"
    }
}