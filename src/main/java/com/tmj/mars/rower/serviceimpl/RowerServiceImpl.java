package com.tmj.mars.rower.serviceimpl;

import com.tmj.mars.rower.entity.Plateau;
import com.tmj.mars.rower.entity.Position;
import com.tmj.mars.rower.entity.Rover;
import com.tmj.mars.rower.service.RowerService;
import com.tmj.mars.rower.util.Direction;
import com.tmj.mars.rower.util.ResponseObject;
import org.springframework.stereotype.Service;

@Service
public class RowerServiceImpl implements RowerService {


    @Override
    public ResponseObject setPlateau(String coordinates) {
        ResponseObject responseObject;
        try {
            String[] positionArray = coordinates.split(" ");
            int xCoordinate = Integer.parseInt(positionArray[0]);
            int yCoordinate = Integer.parseInt(positionArray[1]);
            Plateau plateau = new Plateau(xCoordinate, yCoordinate);
            responseObject = new ResponseObject("Plateau upper limit set as " + coordinates, true, plateau);
        } catch (Exception e) {
            e.printStackTrace();
            responseObject = new ResponseObject("Error Setting Plateau", false);
        }
        return responseObject;
    }

    @Override
    public ResponseObject setPosition(String position, Plateau plateau) {
        ResponseObject responseObject;
        try {
            if (plateau != null) {
                String[] positionArray = position.split(" ");
                int xCoordinate = Integer.parseInt(positionArray[0]);
                int yCoordinate = Integer.parseInt(positionArray[1]);
                Direction direction = Direction.get(positionArray[2]);
                Position roverPosition = new Position(xCoordinate, yCoordinate, direction);
                Rover rover = new Rover(plateau, roverPosition);
                responseObject = new ResponseObject("Rover Placed at " + position, true, rover);
            } else {
                responseObject = new ResponseObject("Create Plateau First", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseObject = new ResponseObject("Error Setting Rover Position", false);
        }
        return responseObject;
    }

    @Override
    public ResponseObject setMovement(String movement, Rover rover) {
        ResponseObject responseObject;
        try {
            if (rover != null) {
                rover.setMovement(movement);
                responseObject = new ResponseObject(rover.getPosition().toString(), true, rover);
            } else {
                responseObject = new ResponseObject("Place a Rover and try again", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseObject = new ResponseObject("Error moving the Rover", false);
        }
        return responseObject;
    }

}
