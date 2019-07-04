package jp.meg.anime.controller

import jp.meg.anime.domain.model.AnimeRequest
import jp.meg.anime.domain.model.api.anime.AnimeApiAccessor
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("")
class AnimeController (val accessor: AnimeApiAccessor){

    @GetMapping
    fun top(): ModelAndView {
        val req = AnimeRequest(2018,2)
        val result = accessor.call(req)
        val mav = ModelAndView("top")
        mav.addObject("animes", result)
        mav.addObject("year", req.year)
        mav.addObject("cool", req.cool)
        return mav
    }

    @PostMapping
    fun post(@Validated req: AnimeRequest): ModelAndView {
        val result = accessor.call(req)
        val mav = ModelAndView("top")
        mav.addObject("animes", result)
        mav.addObject("year", req.year)
        mav.addObject("cool", req.cool)
        return mav
    }

}