package com.fakhrulasa.emailvalidator_composeclean.domain.interactor

interface BaseUseCase<Request, Result> {
    suspend fun execute(request: Request): Result
}