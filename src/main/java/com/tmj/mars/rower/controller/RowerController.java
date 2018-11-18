package com.tmj.mars.rower.controller;

import com.tmj.mars.rower.entity.Plateau;
import com.tmj.mars.rower.entity.Rover;
import com.tmj.mars.rower.service.RowerService;
import com.tmj.mars.rower.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RowerController {

    private final RowerService rowerService;
    private Plateau plateau;
    private Rover rover;
    private List<Rover> placedRoverList = new ArrayList<>();

    @Autowired
    public RowerController(RowerService rowerService) {
        this.rowerService = rowerService;
    }

    @RequestMapping("/rover")
    public String loadPage() {
        return "rover";
    }

    @RequestMapping(value = "/plateau", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseObject plateau(@RequestParam(value = "plateau") String coordinates) {
        ResponseObject responseObject = this.rowerService.setPlateau(coordinates);
        if (responseObject.isStatus()) {
            this.rover = null;
            this.plateau = (Plateau) responseObject.getObject();
        }
        return responseObject;
    }

    @RequestMapping(value = "/position", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseObject position(@RequestParam(value = "position") String position) {
        ResponseObject responseObject = this.rowerService.setPosition(position, this.plateau);
        if (responseObject.isStatus()) {
            if (this.rover != null) {
                this.placedRoverList.add(this.rover);
            }
            this.rover = (Rover) responseObject.getObject();
        }
        return responseObject;
    }

    @RequestMapping(value = "/movement", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseObject movement(@RequestParam(value = "movement") String movement) {
        ResponseObject responseObject = this.rowerService.setMovement(movement, this.rover);
        if (responseObject.isStatus()) {
            this.rover = (Rover) responseObject.getObject();
        }
        return responseObject;
    }

    @RequestMapping(value = "/rovers", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Rover> rovers() {
        return this.placedRoverList;
    }
}
