package com.example.galladance.data.mappers.cloud

import com.example.galladance.data.models.AccountData
import com.example.galladance.data.models.FitnessClubData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Account
import com.example.galladance.domain.models.FitnessClub

class MapAccountToDomain(
    private val mapper: Mapper<FitnessClubData, FitnessClub>,
) : Mapper<AccountData, Account> {
    override fun map(from: AccountData) = from.run {
        Account(
            accountId = accountId,
            accountType = accountType,
            accountSum = accountSum,
            fitnessClub = mapper.map(fitnessClub)
        )
    }
}