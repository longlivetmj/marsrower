package com.tmj.mars.rower.entity;

import java.util.Objects;

public class Rover {

    private Plateau plateau;
    private Position position;

    public Rover(Plateau plateau, Position position) {
        this.plateau = plateau;
        this.position = position;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setMovement(String movements) {
        movements.chars().mapToObj(c -> (char) c).forEach(this::setMovement);
    }

    private void setMovement(Character instruction) {
        switch (instruction) {
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            case 'M':
                move();
                break;
        }
    }

    private void move() {
        if (plateau.isValidMove(this.position)) {
            this.position = position.moveAhead();
        }
    }

    private void turnLeft() {
        this.position = position.rotateLeft();
    }

    private void turnRight() {
        this.position = position.rotateRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(plateau, rover.plateau) &&
                Objects.equals(position, rover.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateau, position);
    }
}
