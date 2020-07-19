package systemapps;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

            OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                    OperatingSystemMXBean.class);
            System.out.println("Which information would you like to know?");
            System.out.println("<1> CPU load");
            System.out.println("<2> CPU time");
            System.out.println("<3> memory information");
            System.out.println("<4> Size of swap space");
            System.out.println("<5> OS name");

            System.out.print(": ");
            int auswahl = eingabe.nextInt();
            switch (auswahl) {
                case 1:
                    // What % CPU load this current JVM is taking, from 0.0-1.0
                    System.out.println("Recent CPU usage for JVM process: " + osBean.getProcessCpuLoad());
                    // What % load the overall system is at, from 0.0-1.0
                    System.out.println("Recent CPU usage for the operating environment: " + osBean.getCpuLoad());
                    break;

                case 2:
                    //CPU time
                    System.out.println("CPU time used by the process in nanoseconds: " + osBean.getProcessCpuTime());
                    break;

                case 3:
                    //Total memory in bytes
                    System.out.println("Total RAM in bytes: " + osBean.getTotalMemorySize());
                    //Free Memory in bytes
                    System.out.println("Free RAM in bytes: " + osBean.getFreeMemorySize());
                    break;

                case 4:
                    //Total swap space size in bytes
                    System.out.println("Total swap space size: " + osBean.getTotalSwapSpaceSize());
                    //Free swap space size in bytes
                    System.out.println("Free swap space size: "+ osBean.getFreeSwapSpaceSize());
                    System.out.println("Please note: If there is a 0 everywhere, your swap partition may not be enabled.");
                    break;

                case 5:
                    //The name of your OS
                    System.out.println("OS name: "+ osBean.getName());
                    break;

                default:
                    System.out.println("The choice you typed in (" +auswahl+ ") is not available");
                    break;
            }

            

    }
}
