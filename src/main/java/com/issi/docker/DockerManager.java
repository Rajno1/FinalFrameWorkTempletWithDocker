package com.issi.docker;

import java.io.IOException;

public final class DockerManager {
    private DockerManager() {
    }

    public static void startDockerGrid(){
        try { // this will run Start_DockerGrid bat file before starting remote execution
            Runtime.getRuntime().exec("cmd /c start Start_DockerGrid.bat");
            Thread.sleep(20000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void stopDockerGrid(){
        try { // this will run Stop_DockerGrid bat file before starting remote execution
            Process stop = Runtime.getRuntime().exec("cmd /c start Stop_DockerGrid.bat");
            Thread.sleep(15000);
            Runtime.getRuntime().exec("taskkill /f /im cmd.exe");  // This command will closes all command prompts open in your system

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
