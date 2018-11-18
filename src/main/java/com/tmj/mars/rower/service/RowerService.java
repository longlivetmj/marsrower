package com.tmj.mars.rower.service;

import com.tmj.mars.rower.entity.Plateau;
import com.tmj.mars.rower.entity.Rover;
import com.tmj.mars.rower.util.ResponseObject;

public interface RowerService {

    ResponseObject setPlateau(String coordinates);

    ResponseObject setPosition(String position, Plateau plateau);

    ResponseObject setMovement(String movement, Rover rover);
}
