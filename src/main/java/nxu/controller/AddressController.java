package nxu.controller;

import nxu.entity.Address;
import nxu.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 地址控制器
 */
@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getAllAddress")
    @ResponseBody
    public List<Address> getAllAddress(int userId) {
        return addressService.selectByUser(userId);
    }

    @GetMapping("/getOneAddress")
    @ResponseBody
    public Address getOneAddress(int id) {
        return addressService.selectById(id);
    }

}