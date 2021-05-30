package xyz.metahash.chains.bsc.bscscan.di

import xyz.metahash.chains.bsc.bscscan.services.AccountService
import xyz.metahash.chains.bsc.bscscan.services.TokenService
import xyz.metahash.chains.bsc.bscscan.services.TransactionService
import javax.inject.Inject

abstract class BscScanApiImpl {
    @Inject lateinit var accountService: AccountService
    @Inject lateinit var tokenService: TokenService
    @Inject lateinit var transactionService: TransactionService
    init {
        DaggerBscScanApiComponent.create().inject(this)
    }
}