package com.example.galladance.data.cloud.mappers

import com.example.galladance.data.cloud.models.FitnessManagerCloud
import com.example.galladance.data.models.FitnessManagerData
import com.example.galladance.domain.Mapper

class MapFitnessManagerToData: Mapper<FitnessManagerCloud, FitnessManagerData> {
    override fun map(from: FitnessManagerCloud) = from.run {
        FitnessManagerData(
            managerId = managerId,
            managerName = managerName,
            managerImage = managerImage
        )
    }

}