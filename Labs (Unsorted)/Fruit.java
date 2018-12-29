// SUBMITTED BY: ALAN HUANG
// HELPED BY: NOBODY

import acm.graphics.GCompound;

public abstract class Fruit extends GCompound {

    private double vx;
    private double vy;
    
    private double ax;
    private double ay;
    
    public void setXVelocity(double vx) {
        this.vx = vx;
    }
    
    public void setYVelocity(double vy) {
        this.vy = vy;
    }
    
    public void setXAcceleration(double ax) {
        this.ax = ax;
    }
    
    public void setYAcceleration(double ay) {
        this.ay = ay;
    }
    
    public double getXVelocity() {
        return vx;
    }
    
    public double getYVelocity() {
        return vy;
    }
    
    public double getXAcceleration() {
        return ax;
    }
    
    public double getYAcceleration() {
        return ay;
    }
        
    public void update() {
        //this.move(this.getXVelocity(),this.getYVelocity());
        this.setLocation(this.getX() + this.getXVelocity(), this.getY() + this.getYVelocity());
        this.setXVelocity(this.getXVelocity() + this.getXAcceleration());
        this.setYVelocity(this.getYVelocity() + this.getYAcceleration());
    }
    
}
