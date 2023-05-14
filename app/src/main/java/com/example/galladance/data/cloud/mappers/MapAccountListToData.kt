package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.AccountCloud
import com.example.galladance.data.models.AccountData
import com.example.galladance.domain.Mapper

class MapAccountListToData(
    private val mapper: Mapper<AccountCloud, AccountData>,
) : Mapper<List<AccountCloud>, List<AccountData>> {
    override fun map(from: List<AccountCloud>) = from.run {
        map(mapper::map)
    }
}