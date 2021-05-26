package xyz.metahash.chains.bsc.bscscan.models

data class Response<T>(var status: String, var message: String, var result: T)