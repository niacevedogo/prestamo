package com.example.prestamos.services;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.repository.ITipoDocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TipoDocumentoService {

    private ITipoDocumentoRepository TipodocumentoRepository;

    public TipoDocumentoService(ITipoDocumentoRepository rep1){
            this.TipodocumentoRepository = rep1;
    }

    public ArrayList<TipoDocumento> SelectAll(){
        return (ArrayList<TipoDocumento>) this.TipodocumentoRepository.findAll();
    }

    public Response createTipoDocumento(TipoDocumento data){

        Response response = new Response();
        ArrayList<TipoDocumento> documentos = this.TipodocumentoRepository.findbyNombre(data.getNombre());
        if (documentos != null && documentos.size() > 0){
            response.setCode(500);
            response.setMessage("Tipo de documento ya fue registrado");
            return response;
        }

        this.TipodocumentoRepository.save(data);
        response.setCode(200);
        response.setMessage("Tipo de documento retistrado correctamente");
        return response;
    }

}
