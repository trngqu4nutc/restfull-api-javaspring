package com.javaweb.api;

import com.javaweb.api.output.NewOutput;
import com.javaweb.dto.NewDTO;
import com.javaweb.service.impl.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class NewAPI {

    @Autowired
    private NewService newService;

    @GetMapping(value = "/new")
    public NewOutput showNew(@RequestParam(value = "page", required = false) Integer page,
                             @RequestParam(value = "limit", required = false) Integer limit){
        NewOutput result = new NewOutput();
        if(page != null && limit != null){
            Pageable pageable = new PageRequest(page - 1, limit);
            result.setLstResult(newService.findAll(pageable));
            result.setPage(page);
            result.setTotalPage((int) Math.ceil((double) newService.totalItem() / limit));
        }else {
            result.setLstResult(newService.findAll());
        }
        return result;
    }

    @PostMapping(value = "/new")
    public NewDTO createNew(@RequestBody NewDTO model){
        return newService.save(model);
    }

    @PutMapping(value = "/new/{id}")
    public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id){
        model.setId(id);
        return newService.save(model);
    }

    @DeleteMapping(value = "/new")
    public void deleteNew(@RequestBody long[] ids){
        newService.delete(ids);
    }

}
