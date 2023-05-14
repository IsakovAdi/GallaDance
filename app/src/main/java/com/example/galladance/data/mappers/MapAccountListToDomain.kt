package com.example.galladance.data.mappers

import com.example.galladance.data.models.AccountData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Account

class MapAccountListToDomain(
    private val mapper: Mapper<AccountData, Account>,
) : Mapper<List<AccountData>, List<Account>> {
    override fun map(from: List<AccountData>) = from.run {
        map(mapper::map)
    }
}