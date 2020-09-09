package com.example.countrymvvm.di

import com.example.countrymvvm.model.CountriesService
import com.example.countrymvvm.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: CountriesService)

    fun inject(viewModel: ListViewModel)
}