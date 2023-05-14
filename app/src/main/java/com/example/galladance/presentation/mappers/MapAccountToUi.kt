package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.Account
import com.example.galladance.domain.models.FitnessClub
import com.example.galladance.presentation.models.AccountUi
import com.example.galladance.presentation.models.FitnessClubUi

class MapAccountToUi(
    private val mapper: Mapper<FitnessClub, FitnessClubUi>,
) : Mapper<Account, AccountUi> {
    override fun map(from: Account) = from.run {
        AccountUi(
            accountId = accountId,
            accountType = accountType,
            accountSum = accountSum,
            fitnessClub = mapper.map(fitnessClub)
        )
    }
}