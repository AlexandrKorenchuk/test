package com.example.domain.event

import com.example.domain.repository.CompletedEventRepository
import com.example.model.CompletedEvent
import com.example.utils.provider.BaseSchedulerProvider
import io.reactivex.rxjava3.core.Single

interface GetEventsUseCase {
    operator fun invoke(): Single<List<CompletedEvent>>
}

internal class GetEventsUseCaseImpl(
    private val repository: CompletedEventRepository,
    private val scheduler: BaseSchedulerProvider,
) : GetEventsUseCase {
    override fun invoke(): Single<List<CompletedEvent>> =
        repository.getAll().subscribeOn(scheduler.io()).observeOn(scheduler.ui())
}