package com.fakhrulasa.emailvalidator_composeclean.di

import com.fakhrulasa.emailvalidator_composeclean.domain.interactor.ValidateEmailUseCase
import com.fakhrulasa.emailvalidator_composeclean.domain.repository.BaseRepository
import com.fakhrulasa.emailvalidator_composeclean.network.client.provideHttpClient
import com.fakhrulasa.emailvalidator_composeclean.presentation.viewmodel.EmailValidatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { provideHttpClient() } // Provide the HttpClient

    // Provide the base URL as a singleton or constant
    single { "https://mailcheck.p.rapidapi.com/" }

    // Provide the BaseRepository with the baseUrl from Koin
    factory { BaseRepository(baseUrl = get()) } // Retrieve baseUrl from Koin
    factory { ValidateEmailUseCase(baseRepository = get()) } // Provide the use case

    // Provide the SomeViewModel
    viewModel { EmailValidatorViewModel(validateEmailUseCase = get()) } // Inject BaseRepository


}
