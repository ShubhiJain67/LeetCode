class ParkingSystem {
    int bigAvailable = 0;
    int mediumAvailable = 0;
    int smallAvailable = 0;
    
    public ParkingSystem(int big, int medium, int small) {
        this.bigAvailable = big;
        this.mediumAvailable = medium;
        this.smallAvailable = small;
    }
    
    public boolean addCar(int carType) {
        switch(carType){
            case 1:
                return (--bigAvailable) >= 0;
            case 2:
                return (--mediumAvailable) >= 0;
            case 3:
                return (--smallAvailable) >= 0;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */