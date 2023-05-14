package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.AccountCloud
import com.example.galladance.data.cloud.models.FitnessClubCloud
import com.example.galladance.data.models.AccountData
import com.example.galladance.data.models.FitnessClubData
import com.example.galladance.domain.Mapper

class MapAccountToData(
    private val mapper: Mapper<FitnessClubCloud, FitnessClubData>,
) : Mapper<AccountCloud, AccountData> {
    override fun map(from: AccountCloud) = from.run {
        AccountData(
            accountId = accountId,
            accountType = accountType,
            accountSum = accountSum,
            fitnessClub = mapper.map(fitnessClub)
        )
    }
}