class Solution {
    public double angleClock(int hour, int minutes) {
        double angle=Math.abs((hour*60+minutes)*0.5-minutes*6);
        return angle>180.0?360.0-angle:angle;
    }
}