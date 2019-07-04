package jp.meg.anime.domain.model.api.anime

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import jp.meg.anime.domain.model.Anime
import jp.meg.anime.domain.model.AnimeRequest
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Component
import org.springframework.web.client.getForObject

@Component
class AnimeApiAccessor(val setting: AnimeApiSetting) {

    fun call(req: AnimeRequest): Array<Anime> {
        val restTemplate = setting.getRestTemplate()
        restTemplate.setMessageConverters(listOf(converter()))

        var result: Array<Anime>?
        try {
            result = restTemplate.getForObject(setting.getUrl(req.year, req.cool))
        } catch (e: Exception) {
            result = restTemplate.getForObject(setting.getUrlExcludeOgp(req.year, req.cool))
        }
        return result ?: arrayOf()
    }

    fun converter(): MappingJackson2HttpMessageConverter {
        val converter = MappingJackson2HttpMessageConverter()
        converter.setObjectMapper(myObjectMapper())
        return converter
    }

    fun myObjectMapper(): ObjectMapper {
        val objectMapper = jacksonObjectMapper()
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        return objectMapper
    }
}