package com.example.otstest.presentation.events

import com.example.otstest.presentation.base.BasePresenter
import com.example.utils.provider.BaseSchedulerProvider

class EventsPresenter(
    schedulers: BaseSchedulerProvider
) : BasePresenter<EventsView>(
    schedulers
) {}