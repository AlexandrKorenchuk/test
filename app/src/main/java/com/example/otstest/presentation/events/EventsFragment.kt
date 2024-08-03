package com.example.otstest.presentation.events

import android.os.Bundle
import com.example.otstest.R
import com.example.otstest.databinding.FragmentEventsBinding
import com.example.otstest.presentation.main.MainActivity
import com.example.otstest.utils.extensions.viewBinding
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class EventsFragment : MvpAppCompatFragment(R.layout.fragment_events), EventsView {
    private lateinit var scope: Scope

    @InjectPresenter
    lateinit var presenter: EventsPresenter

    @ProvidePresenter
    fun providePresenter(): EventsPresenter = EventsPresenter(scope.get())

    private val binding by viewBinding<FragmentEventsBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        scope = getKoin().getOrCreateScope(
            MainActivity.DI_SCOPE_NAME, named(MainActivity.DI_SCOPE_NAME)
        )
        super.onCreate(savedInstanceState)
    }
}