package com.example.galladance.presentation.mappers

import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.FitnessManager
import com.example.galladance.presentation.models.FitnessManagerUi

class MapFitnessManagerToUi: Mapper<FitnessManager, FitnessManagerUi> {
    override fun map(from: FitnessManager) = from.run {
        FitnessManagerUi(
            managerId = managerId,
            managerName = managerName,
            managerImage = managerImage
        )
    }

}