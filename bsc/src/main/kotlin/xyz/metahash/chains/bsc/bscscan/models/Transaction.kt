package xyz.metahash.chains.bsc.bscscan.models

data class Transaction(
    var blockNumber: String?, var timeStamp: String?, var hash: String?, var nonce: String?,
    var blockHash: String?, var transactionIndex: String?, var to: String?, var value: String?,
    var gas: String?, var gasPrice: String?, var isError: String?, var txreceipt_status: String?,
    var input: String?, var contractAddress: String?, var cumulativeGasUsed: String?,
    var gasUsed: String?, var traceId: String?, var confirmations: String?,
    // Erc721
    var tokenID: String?, var tokenName: String?, var tokenSymbol: String?, var tokenDecimal: String?
)