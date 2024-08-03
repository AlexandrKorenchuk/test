package com.example.domain.event

import com.example.domain.repository.CompletedEventRepository
import com.example.utils.provider.BaseSchedulerProvider
import io.reactivex.rxjava3.core.Completable

interface SaveEventUseCase {
    operator fun invoke(date: Long): Completable
}

internal class SaveEventUseCaseImpl(
    private val repository: CompletedEventRepository, private val scheduler: BaseSchedulerProvider
) : SaveEventUseCase {
    override fun invoke(date: Long): Completable =
        repository.save(date).subscribeOn(scheduler.io()).observeOn(scheduler.ui())
}