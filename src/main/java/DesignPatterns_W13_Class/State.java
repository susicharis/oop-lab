package DesignPatterns_W13_Class;

interface TrafficLightState {
    void transitionToRed();
    void transitionToGreen();
    void transitionToYellow();
}

class RedLightState implements TrafficLightState {
    public void transitionToRed() {
        System.out.println("RED!");
    }
    public void transitionToGreen() {
        System.out.println("GREEN!");
    }
    public void transitionToYellow() {
        System.out.println("YELLOW!");
    }
}

class GreenLightState implements TrafficLightState {
    public void transitionToRed() {
        System.out.println("RED!");
    }
    public void transitionToGreen() {
        System.out.println("GREEN!");
    }
    public void transitionToYellow() {
        System.out.println("YELLOW!");
    }
}

class YellowLightState implements TrafficLightState {
    public void transitionToRed() {
        System.out.println("RED!");
    }
    public void transitionToGreen() {
        System.out.println("GREEN!");
    }
    public void transitionToYellow() {
        System.out.println("YELLOW!");
    }
}

class TrafficLightContext {
    private TrafficLightState lightState;

    public TrafficLightContext() {
        this.lightState = new RedLightState();
    }

    public void setState(TrafficLightState lightState) {
        this.lightState = lightState;
    }

    public void transitionToRed() {
        lightState.transitionToRed();
    }

    public void transitionToGreen() {
        lightState.transitionToGreen();
    }

    public void transitionToYellow() {
        lightState.transitionToYellow();
    }

}

class TrafficLightController {

}
