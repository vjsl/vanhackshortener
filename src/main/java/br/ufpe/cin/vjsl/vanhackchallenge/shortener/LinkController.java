package br.ufpe.cin.vjsl.vanhackchallenge.shortener;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(path = "/")
public class LinkController {

    @Autowired
    private LinkRepository linkRepository;
    private String original;

    @GetMapping(path = "/short")
    public @ResponseBody String shortner(@RequestParam String link, HttpServletResponse httpServletResponse){
        Link l = new Link();
        l.setOriginalLink(link);
        l.setShortened(RandomStringUtils.random(6, "abcdefghijklmnopqrstuvwxyz0123456789"));
        linkRepository.save(l);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        return "localhost:8080/"+l.getShortened();
    }

    @RequestMapping(value="/{code}", method=RequestMethod.GET)
    public void unshortner(HttpServletResponse httpServletResponse, @PathVariable("code") String code){
        Iterable<Link> find = linkRepository.findAll();
        find.forEach(links -> {
            if(links.getShortened().equals(code)){
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                try{
                    httpServletResponse.sendRedirect(links.getOriginalLink());
                }catch (IOException e){
                    e.getLocalizedMessage();
                }
            }
        });

    }

}
