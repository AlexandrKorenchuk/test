package com.example.domain.receiver

import com.example.domain.repository.BootReceiverRepository

interface FinishBootReceiverUseCase {
    operator fun invoke()
}

internal class FinishBootReceiverUseCaseImpl(
    private val receiver: BootReceiverRepository
) : FinishBootReceiverUseCase {
    override fun invoke() {
        receiver.finish()
    }
}