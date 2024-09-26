package com.fakhrulasa.emailvalidator_composeclean.di

import com.fakhrulasa.emailvalidator_composeclean.domain.repository.BaseRepository
import com.fakhrulasa.emailvalidator_composeclean.presentation.viewmodel.EmailValidatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Define a singleton for ApiService
//    single { ApiService() }

    // Define a factory for Repository, injecting ApiService
//    factory { BaseRepository(get()) }

    // Define a ViewModel, injecting Repository
    viewModel { EmailValidatorViewModel(get()) }
}
