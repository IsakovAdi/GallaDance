package com.example.galladance.data.mappers.cloud

import com.example.galladance.data.models.FitnessManagerData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.FitnessManager

class MapFitnessManagerToDomain: Mapper<FitnessManagerData, FitnessManager> {
    override fun map(from: FitnessManagerData) = from.run {
        FitnessManager(
            managerId = managerId,
            managerName = managerName,
            managerImage = managerImage
        )
    }

}