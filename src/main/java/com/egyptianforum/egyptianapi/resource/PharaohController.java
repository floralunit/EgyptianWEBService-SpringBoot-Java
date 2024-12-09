package com.egyptianforum.egyptianapi.resource;

import com.egyptianforum.egyptianapi.persistence.AbydosCanon;
import com.egyptianforum.egyptianapi.persistence.SaqqaraCanon;
import com.egyptianforum.egyptianapi.service.AbydosCanonService;
import com.egyptianforum.egyptianapi.service.SaqqaraCanonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pharaohs")
public class PharaohController {

    @Autowired
    private AbydosCanonService abydosCanonService;
    @Autowired
    private SaqqaraCanonService saqqaraCanonService;

    @GetMapping("/abydoscanon")
    public List<AbydosCanon> getAllAbydosCanons() {
        return abydosCanonService.getAllAbydosCanons();
    }

    @GetMapping("/saqqaracanon")
    public List<SaqqaraCanon> getAllSaqqaraCanons() {
        return saqqaraCanonService.getAllSaqqaraCanons();
    }
}
