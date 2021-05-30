package xyz.metahash.chains.bsc.bscscan.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BscScanApiModule::class])
interface BscScanApiComponent {
    fun inject(impl: BscScanApiImpl)
}