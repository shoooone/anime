package jp.meg.anime.domain.model.api.anime

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.net.InetSocketAddress
import java.net.Proxy

@Component
@ConfigurationProperties
data class AnimeApiSetting(
        @Value("\${api.anime.url}")
        val url: String,
        @Value("\${api.anime.timeout}")
        val timeout: Int
) {
    fun getRestTemplate(): RestTemplate {
        val factory = SimpleClientHttpRequestFactory()
        factory.setConnectTimeout(timeout)
        factory.setReadTimeout(timeout)
        //factory.setProxy(Proxy(Proxy.Type.HTTP, InetSocketAddress("proxy", 8080)))
        return RestTemplate(BufferingClientHttpRequestFactory(factory))
    }

    fun getUrl(year: Int, cool: Int) = "$url$year/$cool?ogp=1"
    fun getUrlExcludeOgp(year: Int, cool: Int) = "$url$year/$cool"

}