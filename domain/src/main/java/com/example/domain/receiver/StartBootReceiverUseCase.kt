package com.example.domain.receiver

import com.example.domain.repository.BootReceiverRepository

interface StartBootReceiverUseCase {
    operator fun invoke()
}

class StartBootReceiverUseCaseImpl(private val receiver: BootReceiverRepository) :
    StartBootReceiverUseCase {
    override fun invoke() {
        receiver.start()
    }
}