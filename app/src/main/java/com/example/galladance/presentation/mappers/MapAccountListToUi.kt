package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Account
import com.example.galladance.presentation.models.AccountUi

class MapAccountListToUi(
    private val mapper: Mapper<Account, AccountUi>,
) : Mapper<List<Account>, List<AccountUi>> {
    override fun map(from: List<Account>) = from.run {
        map(mapper::map)
    }
}