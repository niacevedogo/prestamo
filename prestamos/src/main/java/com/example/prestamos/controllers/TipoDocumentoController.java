package com.example.prestamos.controllers;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.TipoDocumentoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("documento")
public class TipoDocumentoController {

    private TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoController(TipoDocumentoService service){
        this.tipoDocumentoService = service;
    }

    @RequestMapping("getTipoDocumento")
    public ArrayList<TipoDocumento> getTipodocumento(){
        return this.tipoDocumentoService.SelectAll();
    }

    @PostMapping("create")
    public Response createTipodocumento(@RequestBody TipoDocumento request){
        return this.tipoDocumentoService.createTipoDocumento(request);
    }


}
