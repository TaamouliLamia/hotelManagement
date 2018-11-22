package com.ensi.ilsi.hotelmanagement.web;

import static com.ensi.ilsi.hotelmanagement.common.Web.API;
import com.ensi.ilsi.hotelmanagement.service.BillService;
import com.ensi.ilsi.hotelmanagement.web.Dto.BillDto;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(API + "/bills")
public class BillResource {

	
	private final BillService billService;

    public BillResource(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public List<BillDto> findAll() {
        return this.billService.findAll();
    }

    @GetMapping("/{id}")
    public BillDto findById(@PathVariable Long id) {
        return this.billService.findById(id);
    }

    @PostMapping
    public BillDto create(Long customerId, BillDto billDto) {
        return this.billService.create(customerId, billDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.billService.delete(id);
    }
}
