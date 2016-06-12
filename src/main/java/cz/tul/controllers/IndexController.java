package cz.tul.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
controller na základě požadavku zavolá příslušnou metodu dané služby, která
- zaobaluje práci s datovými entitami
- na základě definované logiky nastaví parametry vnitřního modelu
- vrátí jméno pohledu, který má být zobrazen uživateli

každá metoda v controlleru musí “vést k zobrazení” nějakého pohledu (nebo přesměrování požadavku)

metody většinou vrací logické jméno pohledu, které je pomocí ViewResolveru převedeno na konkrétní pohled dle použité technologie

*/
@Controller
public class IndexController {

    @RequestMapping("/")
    public String showHome() {
        return "index";
    }
}
