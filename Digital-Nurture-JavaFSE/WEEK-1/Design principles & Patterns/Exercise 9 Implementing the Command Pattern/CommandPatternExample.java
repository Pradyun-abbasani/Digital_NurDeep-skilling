import java.util.*;

public class CommandPatternExample {
    interface Command {
        void execute();
    }

    static class Light {
        void turnOn() {
            System.out.println("Light is ON");
        }
        void turnOff() {
            System.out.println("Light is OFF");
        }
    }

    static class LightOnCommand implements Command {
        private Light light;
        public LightOnCommand(Light light) {
            this.light = light;
        }
        public void execute() {
            light.turnOn();
        }
    }

    static class LightOffCommand implements Command {
        private Light light;
        public LightOffCommand(Light light) {
            this.light = light;
        }
        public void execute() {
            light.turnOff();
        }
    }

    static class RemoteControl {
        private Command command;
        public void setCommand(Command command) {
            this.command = command;
        }
        public void pressButton() {
            command.execute();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Light light = new Light();
        Command on = new LightOnCommand(light);
        Command off = new LightOffCommand(light);
        RemoteControl remote = new RemoteControl();

        System.out.println("1. Turn ON Light");
        System.out.println("2. Turn OFF Light");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            remote.setCommand(on);
        } else if (choice == 2) {
            remote.setCommand(off);
        } else {
            System.out.println("Invalid input");
            return;
        }

        remote.pressButton();
    }
}
