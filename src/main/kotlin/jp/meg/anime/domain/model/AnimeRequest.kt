package jp.meg.anime.domain.model

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern

data class AnimeRequest(
        @Min(2014)
        @Max(2018)
        val year: Int,
        @Min(1)
        @Max(4)
        val cool: Int
)