package com.example.data.mapper

import com.example.data.model.AndroidJobPayload
import com.example.data.model.JobsPayload
import com.example.domain.entities.AndroidJob

object AndroidJobMapper {

    fun map(payload: JobsPayload) = payload.jobsPayload.map { it }

    private fun mao(payload: AndroidJobPayload) = AndroidJob(
        title = payload.title,
        experienceTimeRequired = payload.requiredExperienceYears,
        native = payload.native,
        country = payload.country
    )

}