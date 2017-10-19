package entity;

import java.awt.Point;

/**
 *
 * @author lenovo
 */
public class Ball {

    private int sizeX = 1000;
    private int sizeY = 530;
    private int topMargin = 145;
    private int leftMargin = 76;
    private int ballSize = 30;
    private double x;
    private double y;
    private double speed;
    private int id;
    private double direction;
    private String attribute;
    private boolean flag = false;

    public Ball() {
    }

    public Ball(String message) {
        String[] str = message.split(";");
        x = Integer.parseInt(str[0]);
        y = Integer.parseInt(str[1]);
        speed = Double.parseDouble(str[2]);
        direction = Double.parseDouble(str[3]);
        attribute = str[4];

    }

    public void SetBall(String message) {
        String[] str = message.split(";");
        x = Integer.parseInt(str[0]);
        y = Integer.parseInt(str[1]);
        speed = Double.parseDouble(str[2]);
        direction = Double.parseDouble(str[3]);
        attribute = str[4];
    }

    @Override
    public String toString() {
        return (int) x + ";" + (int) y + ";" + speed + ";" + direction + ";" + attribute;
    }

    public double getX() {
        return x;
    }

    public void setXYMandatory(double x, double y) {//强制赋值
        this.x = x;
        this.y = y;
    }

    public void go(double x, double y, Point point, double angle) {
        if (this.direction < angle) {
            this.direction += 0.01;
        } else {
            this.direction -= 0.01;
        }
        if (x < point.x) {
            x += 0.3;
        } else {
            x -= 0.3;
        }
        if (y < point.y) {
            y += 0.3;
        } else {
            y -= 0.3;
        }
        this.setXYMandatory(x, y);
    }

    public void setXY(double x, double y) {
        if (y < topMargin - ballSize - 13 || y > sizeY + ballSize + 8 || x < leftMargin - ballSize - 10 || x > sizeX + ballSize) {
            this.speed = 0;
            this.flag = true;
        }
        Point point = new Point();
        if (x + ballSize / 2 > 526 && x + ballSize / 2 < 578 && y < topMargin) {
            //中上位置的球洞
            point.x = 535;
            point.y = topMargin - 60;
            if (y < topMargin - 15) {
                go(x, y, point, Math.PI * 1.5);
            } else {
                this.setXYMandatory(x, y);
            }
        } else if (x + ballSize / 2 > 526 && x + ballSize / 2 < 578 && y > sizeY) {
            //中下位置的球洞
            point.x = 535;
            point.y = sizeY + 60;
            if (y > sizeY + 15) {
                go(x, y, point, Math.PI * 0.5);
            } else {
                this.setXYMandatory(x, y);
            }
        } else if (x < leftMargin + 15 && y < topMargin + 10) {
            //左上位置的球洞
            point.x = leftMargin - 31;
            point.y = topMargin - 60;
            if (x < leftMargin || y < topMargin) {
                go(x, y, point, Math.PI * 1.25);
            } else {
                this.setXYMandatory(x, y);
            }
        } else if (x < leftMargin + 15 && y > sizeY - 15) {
            //左下位置的球洞
            point.x = leftMargin - 31;
            point.y = sizeY + 60;
            if (x < leftMargin || y > sizeY) {
                go(x, y, point, Math.PI * 0.75);
            } else {
                this.setXYMandatory(x, y);
            }
        } else if (x > sizeX - 15 && y < topMargin + 10) {
            //右上位置的球洞
            point.x = sizeX + 32;
            point.y = topMargin - 60;
            if (x > sizeX || y < topMargin) {
                go(x, y, point, Math.PI * 1.75);
            } else {
                this.setXYMandatory(x, y);
            }
        } else if (x > sizeX - 15 && y > sizeY - 10) {
            //右下位置的球洞
            point.x = sizeX + 32;
            point.y = sizeY + 60;
            if (x > sizeX || y > sizeY) {
                go(x, y, point, Math.PI * 0.25);
            } else {
                this.setXYMandatory(x, y);
            }
        } else {
            setX(x);
            setY(y);
        }
    }

    public void setX(double x) {
        if (x > sizeX) {
            x += sizeX - x;
            if (direction < Math.PI) {
                direction = Math.PI - direction;
            } else {
                direction = 3 * Math.PI - direction;
            }
        }
        if (x < leftMargin) {
            x = leftMargin * 2 - x;
            if (direction < Math.PI) {
                direction = Math.PI - direction;
            } else {
                direction = 3 * Math.PI - direction;
            }
        }
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        while (direction > 2 * Math.PI) {
            direction -= 2 * Math.PI;
        }
        while (direction < 0) {
            direction += 2 * Math.PI;
        }
        this.direction = direction;
    }

    public double getDirection_PI() {
        double dir = direction;
        while (dir > Math.PI) {
            dir -= Math.PI;
        }
        return dir;
    }

    public void setY(double y) {
        if (y > sizeY) {
            y += sizeY - y;
//            if(direction <Math.PI)
            direction = 2 * Math.PI - direction;
//            else
//                direction = 3*Math.PI-direction;
        }
        if (y < topMargin) {
            y = topMargin * 2 - y;
            //    if(direction <Math.PI/2 || direction >3*Math.PI/2)
            direction = 2 * Math.PI - direction;
//            else
//                direction = 3*Math.PI-direction;
        }
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
        if (this.speed < 0) {
            this.speed = 0;
        }
    }

    public void SpeedSlowDown() {
        if (speed > 0) {
            this.speed -= (0.0005 + 0.0003 * speed * speed);
        }
        if (speed < 0) {
            speed = 0;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public boolean getFlag() {
        return this.flag;
    }

    public void SetFlag(boolean flag) {
        this.flag = flag;
    }
}
